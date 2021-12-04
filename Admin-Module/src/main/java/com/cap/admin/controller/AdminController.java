package com.cap.admin.controller;

import java.util.List;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cap.admin.model.Admin;
import com.cap.admin.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService service;
	
	@PostMapping("/addAdmin")
	public Admin addAdmin(@RequestBody Admin admin)
	{
		return service.createAdmin(admin);
	}
	
	@GetMapping("/adminAll")
	public List<Admin> getadmin()
	{
		return service.getAdmin();
	}
	
	@PutMapping("/update/{id}")
	public Admin update(@PathVariable("id") int id,@RequestBody Admin admin)
	{
		System.out.println(id);
		return service.updateById(id, admin);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id)
	{
		return service.deleteAdmin(id);
	}
	
}
