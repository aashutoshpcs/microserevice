package com.ashu.rating.service;

import java.util.List;

import com.ashu.rating.entities.Rating;

public interface RatingService {
	
	//create
	Rating create(Rating rating);
	
	//get all rating
	
	List<Rating> getRatings();
	
	//get all bye user ID
	
	List<Rating> getRatingByUserId(String userId);
	
	//get all by Hotel Id
	
	List<Rating> getRatingByHotelId(String hotelId);

}
