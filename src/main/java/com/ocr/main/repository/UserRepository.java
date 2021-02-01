package com.ocr.main.repository;

import org.springframework.data.repository.CrudRepository;

import com.ocr.main.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
}