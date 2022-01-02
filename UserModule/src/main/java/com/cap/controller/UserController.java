package com.cap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cap.dto.Train;
import com.cap.model.User;
import com.cap.model.UserRequest;
import com.cap.model.UserResponse;
import com.cap.repository.UserRepository;
import com.cap.service.UserService;
import com.cap.util.JwtUtil;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService service;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil util;
	
	@Autowired
	private UserRepository repo;
	
	
	@PostMapping("/create")
	public User create(@RequestBody User user)
	{
		return service.createUser(user);
	}
	
	
	
	// Authentication for login
	@PostMapping("/authenticates")
	public UserResponse genenrateTokenForUser(@RequestBody UserRequest request)throws Exception
	{
		try
		{

			if(repo.findByUserName(request.getUsername()).getRole()!=null) {
				authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
						);
				
			}
			else
			{
				throw new Exception("Role is not defined");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("Invalid Credential");
		}
		String token = util.generateToken(request.getUsername());
		return new UserResponse(token);
	}
	
	
	
	@GetMapping("/user/{username}")
	public User getByName(@PathVariable("username") String username)
	{
	  return service.findUserName(username);	
	}
	
	
	// getAll Train from Train microservice
		@GetMapping("/allTrain")
		public List<Train> getAllTrain()
		{
			return service.getallTrain();
			
		}
		
		
//		find by id
		@GetMapping("/find/{id}")
		public Train find(@PathVariable("id") int id)
		{
		   return service.findId(id);	
		}
		
		//find by name
		@GetMapping("/find-train/{name}")
		public List<Train> findbyName(@PathVariable("name") String name)
		{
		   return service.findName(name);
		}
		
		// find by location
		@GetMapping("/findLoc/{start}/{end}")
		public List<Train> findbyloc(@PathVariable("start") String start,@PathVariable("end") String end)
		{
		   return service.findloc(start, end);
		}
	
		
		
		
		
}

