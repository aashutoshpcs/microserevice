package com.ashu.hotel.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ashu.hotel.entities.Hotel;

@Service
public interface HotelService {
	
	//create
	Hotel create(Hotel hotel);
	
	//getAll
	List<Hotel> getAll();
	
	//get single
	Hotel get(String id);	

}
