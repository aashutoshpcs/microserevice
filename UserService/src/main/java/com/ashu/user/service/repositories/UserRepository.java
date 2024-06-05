package com.ashu.user.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashu.user.service.entities.User;

public interface UserRepository  extends JpaRepository<User, String>{
	

}
