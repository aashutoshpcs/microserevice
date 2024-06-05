package com.ashu.hotel.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashu.hotel.entities.Hotel;
import com.ashu.hotel.exceptions.ResourceNotFoundException;
import com.ashu.hotel.repositories.HotelRepository;
import com.ashu.hotel.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel create(Hotel hotel) {
		// TODO Auto-generated method stub
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		// TODO Auto-generated method stub
		return hotelRepository.findAll();
	}

	@Override
	public Hotel get(String id) {
		// TODO Auto-generated method stub
		return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel with given Id not found!!"));
	}

}
