package com.cap.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cap.admin.model.Admin;
import com.cap.admin.model.UserRequest;
import com.cap.admin.model.UserResponse;
import com.cap.admin.repository.AdminRepository;
import com.cap.admin.service.AdminService;
import com.cap.dto.Train;
import com.cap.util.JwtUtil;


@RestController
@CrossOrigin(origins= "*")
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService service;
	
	@Autowired
	private AdminRepository repo;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil util;
	
	
	@PostMapping("/addAdmin")
	public Admin addAdmin(@RequestBody Admin admin)
	{
		return service.createAdmin(admin);
	}
	
	// Authentication for login
		@PostMapping("/authenticates")
		public UserResponse genenrateTokenForUser(@RequestBody UserRequest request)throws Exception
		{
			try
			{
				System.out.println(request.getUsername()+"   "+request.getPassword());
//				System.out.println(repo.findByUserName(request.getUsername()).getRole());
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
				throw new Exception("Invalid Credential");
			}
			String token = util.generateToken(request.getUsername());
			return new UserResponse(token);
		}
	
	
	
	
	
	
	@GetMapping("/adminAll")
	public List<Admin> getadmin()
	{
		return service.getAdmin();
	}
	
	@PutMapping("/updateAdmin/{id}")
	public Admin update(@PathVariable("id") String id,@RequestBody Admin admin)
	{
		System.out.println(id);
		return service.updateById(id, admin);
	}
	
	@DeleteMapping("/deleteAdmin/{id}")
	public String delete(@PathVariable("id") String id)
	{
		return service.deleteAdmin(id);
	}
	
	@GetMapping("/user/{username}")
	public Admin getByName(@PathVariable("username") String username)
	{
	  return service.findUserName(username);	
	}
	
	@PostMapping("/addTrain")
    public Train addTrain(@RequestBody Train train)
    {
    	return service.addTrain(train);
    }
	
	// getAll Train from Train microservice
	@GetMapping("/allTrain")
	public List<Train> getAllTrain()
	{
		return service.getallTrain();
		
	}
	
	
//	find by id
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
	
	
	//Update Train Data 
	@PutMapping("/update/{id}")
	public String update(@PathVariable("id") int id,@RequestBody Train train)
	{
		 return service.updateTrain(id, train);
	}
	
	//delete Train 
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id)
	{
		return service.deleteTrain(id);
	}
	
	
	
	
	
}
