package com.ashu.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashu.hotel.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
