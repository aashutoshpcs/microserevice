package com.ashu.hotel.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashu.hotel.entities.Hotel;
import com.ashu.hotel.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelControllers {

	@Autowired
	private HotelService hotelService;
	
	//create
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		String hotelId = UUID.randomUUID().toString();
		hotel.setId(hotelId);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
	}
	
	//get single
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> gethotel(@PathVariable String hotelId){
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.get(hotelId));
	}
	
	//get all
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAll());
	}
	
}
