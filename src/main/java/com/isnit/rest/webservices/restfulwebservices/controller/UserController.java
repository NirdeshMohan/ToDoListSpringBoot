package com.isnit.rest.webservices.restfulwebservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.isnit.rest.webservices.restfulwebservices.dao.UserDAOService;
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
		return userService.findOne(id);
	}
	
	@PostMapping("/users")
	public User saveUsers(@RequestBody User user){
		return userService.save(user);
	}

}
