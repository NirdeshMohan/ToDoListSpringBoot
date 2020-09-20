package com.isnit.rest.webservices.restfulwebservices.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.isnit.rest.webservices.restfulwebservices.exceptions.UserNotFoundException;
import com.isnit.rest.webservices.restfulwebservices.model.JPAUser;
import com.isnit.rest.webservices.restfulwebservices.model.Post;
import com.isnit.rest.webservices.restfulwebservicesrepository.JPAUserRepository;
import com.isnit.rest.webservices.restfulwebservicesrepository.PostRepository;

@RestController
public class UserJPAController {
	@Autowired
	private JPAUserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/jpa/users")
	public List<JPAUser> getAllJPAUsers(){
		return userRepository.findAll();
	}

	@GetMapping("/jpa/users/{id}")
	public Optional<JPAUser>  getJPAUsers(@PathVariable int id){
		Optional<JPAUser> jpaUser = userRepository.findById(id);
		
		if(!jpaUser.isPresent())
			throw new UserNotFoundException("id-"+id);
		
		
		return jpaUser;
	}
	
	@PostMapping("/jpa/Users")
	public ResponseEntity saveJPAUsers(@Validated @RequestBody JPAUser JPAUser){
		JPAUser savedJPAUser =  userRepository.save(JPAUser);
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedJPAUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	@DeleteMapping("/jpa/Users/{id}")
	public void deleteJPAUser(@PathVariable int id){
		userRepository.deleteById(id);
	}
	
	
	
	
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> getAllJPAUsersWithPosts(@PathVariable int id){
		Optional<JPAUser> jpaUser = userRepository.findById(id);
		
		if(!jpaUser.isPresent())
			throw new UserNotFoundException("id:-"+id);
		
		return jpaUser.get().getPosts();
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity saveJPAUserPost(@PathVariable int id, @RequestBody Post post){
		Optional<JPAUser> jpaUser = userRepository.findById(id);
		
		if(!jpaUser.isPresent())
			throw new UserNotFoundException("id:-"+id);
		
		JPAUser user = jpaUser.get();
		post.setJpaUser(user);
		postRepository.save(post);
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(post.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}

}
