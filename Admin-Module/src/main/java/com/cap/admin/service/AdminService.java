package com.cap.admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.admin.model.Admin;
import com.cap.admin.repository.AdminRepository;


@Service
public class AdminService {

	@Autowired
	private AdminRepository repository;
	
	//Add Admin
	public Admin createAdmin(Admin admin)
	{
		return repository.save(admin);
	}
	
	//update Admin
	public Admin updateById(int id ,Admin admin)
	{
		System.out.println(id);
		Optional<Admin> op = repository.findById(id);
		if(op.isPresent())
		{
			Admin ad = op.get();
		ad.setUserName(admin.getUserName());
			ad.setPassWord(admin.getPassWord());
			ad.setEmail(admin.getEmail());
//			repository.save(ad);
			return repository.save(ad);
		
		}
		else
		{
			System.out.println("nothing");
			return null;
		}
		
	}
	
	// getAdmin
	public List<Admin> getAdmin()
	{
		return repository.findAll();
	}
	
	
	// delete Admin
  public String  deleteAdmin(int id)
  {
	  repository.deleteById(id);
	  return "delete successfully";
  }
}
