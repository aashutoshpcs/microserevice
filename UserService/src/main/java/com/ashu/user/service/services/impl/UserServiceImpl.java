package com.ashu.user.service.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ashu.user.service.entities.Hotel;
import com.ashu.user.service.entities.Rating;
import com.ashu.user.service.entities.User;
import com.ashu.user.service.exceptions.ResourceNotFoundException;
import com.ashu.user.service.external.services.HotelService;
import com.ashu.user.service.repositories.UserRepository;
import com.ashu.user.service.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class); 
	
	@Override
	public User saveUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	//get single user
	@Override
	public User getUser(String userId) {
		User user= userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server!!"));
		//fetch rating from another service
		Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
		logger.info("{} ",ratingsOfUser);
		
		List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
		
		List<Rating> ratingList = ratings.stream().map(rating ->{
			//api call to hotel service to get an hotel
//			ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
//			Hotel hotel = forEntity.getBody();
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
//			logger.info("Response Status code : ",forEntity.getStatusCode());
			//set the hotel to rating
			rating.setHotel(hotel);
			//return the rating
			return rating;
		} ).collect(Collectors.toList());
		user.setRatings(ratingList);
		return user;
	}

	@Override
	public void deleteUserById(String userId) {
		userRepository.deleteById(userId);
		
	}

	@Override
	public User updateUser(User user) {
		User savedUser = userRepository.save(user);
		return savedUser;
	}

}
