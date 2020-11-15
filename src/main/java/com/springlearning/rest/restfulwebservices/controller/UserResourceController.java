package com.springlearning.rest.restfulwebservices.controller;

import java.net.URI;
import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springlearning.rest.restfulwebservices.dao.UserDaoService;
import com.springlearning.rest.restfulwebservices.exceptions.UserNotFoundException;
import com.springlearning.rest.restfulwebservices.bean.User;

@RestController
public class UserResourceController {

	@Autowired
	private UserDaoService service;

	// retrieve all users
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.finaAll();
	}

	// retrieve one user

	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);
		
		if(null == user) {
			throw new UserNotFoundException("id: " + id);
		}
		
		//"all-users", SERVER_PATH + "/users"
		//retrieveAllUsers
		EntityModel<User> entityModel = EntityModel.of(user);
		Link link = linkTo(
				methodOn(this.getClass()).retrieveAllUsers()).withRel("all-users");
		
		entityModel.add(link);
		
		return entityModel;
	}

	// input - details of user
	// output - URI of the created user
	/**
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = service.deleteById(id);
		
		if(null == user) {
			throw new UserNotFoundException("id: " + id);
		}
		
	}
}
