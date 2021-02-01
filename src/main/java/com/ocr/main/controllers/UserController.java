package com.ocr.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ocr.main.entity.User;
import com.ocr.main.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserRepository repository;
	
	@GetMapping
	public Iterable<User> getUsers() {
		return repository.findAll();
	}
	
	@PostMapping
	public User create(@RequestBody User user){
		return repository.save(user);
	}
	
	@PutMapping
	public Iterable<User> edit(@RequestBody Iterable<User> user) {
		return repository.saveAll(user);
	}	
	
	@PatchMapping
	public User partialEdit(@RequestBody User user) {
		return repository.save(user);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") int id) {
		 repository.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public void findById(@PathVariable("id") int id) {
		 repository.findById(id);
	}
}
