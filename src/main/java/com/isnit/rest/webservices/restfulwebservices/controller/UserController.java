package com.isnit.rest.webservices.restfulwebservices.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.isnit.rest.webservices.restfulwebservices.dao.UserDAOService;
import com.isnit.rest.webservices.restfulwebservices.exceptions.UserNotFoundException;
import com.isnit.rest.webservices.restfulwebservices.model.User;

@RestController

public class UserController {
	@Autowired
	private UserDAOService userService;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User getUsers(@PathVariable int id){
		User user = userService.findOne(id);
		if(user == null)
			throw new UserNotFoundException("id-"+id);
		
		
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity saveUsers(@Validated @RequestBody User user){
		User savedUser =  userService.save(user);
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id){
		User user = userService.delete(id);
		if(user == null)
			throw new UserNotFoundException("id-"+id);
	}

}
