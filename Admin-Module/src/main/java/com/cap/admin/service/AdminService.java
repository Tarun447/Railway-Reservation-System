package com.cap.admin.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cap.admin.model.Admin;
import com.cap.admin.repository.AdminRepository;
import com.cap.admin.repository.RoleRepository;
import com.cap.dto.Train;



@Service
public class AdminService {

	@Autowired
	private AdminRepository repository;
	
	@Autowired
	private RoleRepository repository2;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	private String url = "http://localhost:8989/train";
	
	
	//Add Admin
	public Admin createAdmin(Admin admin)
	{if(admin.getRole()!=null && admin.getRole().size()>0)
	{
		repository2.saveAll(admin.getRole());
	}
	
	admin.setPassword(passwordEncoder.encode(admin.getPassword()));
	
	return repository.save(admin);
	}
	
	//update Admin
	public Admin updateById(String id ,Admin admin)
	{
		System.out.println(id);
		Optional<Admin> op = repository.findById(id);
		if(op.isPresent())
		{
			Admin ad = op.get();
		ad.setUserName(admin.getUserName());
			ad.setPassword(admin.getPassword());
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
  public String  deleteAdmin(String id)
  {
	  repository.deleteById(id);
	  return "delete successfully";
  }
  
  
  public Admin findUserName(String username)
  {
 	 return repository.findByUserName(username);
  }
  
  
  
  public Train addTrain(Train train)
  {
  	return restTemplate.postForObject(url+"/add-train", train ,Train.class);
  }
  
  public List<Train> getallTrain()
	{
		Train[] train=restTemplate.getForObject(url+"/allTrain", Train[].class);
		return Arrays.asList(train); 

	}
  
  public Train findId(int id)
	{
	   return restTemplate.getForObject(url+"/find/"+id, Train.class);	
	}
  
  public List<Train> findName( String name)
	{
	   Train[] train = restTemplate.getForObject(url+"/find-train/"+name, Train[].class);
	   return Arrays.asList(train);
	}
	
	public List<Train> findloc(String start,String end)
	{
	   Train[] train=restTemplate.getForObject(url+"/find/"+start+"/"+end, Train[].class);
	   return Arrays.asList(train);
	}
	
	public String updateTrain(int id, Train train)
	{
		 restTemplate.put(url+"/update/"+id, train);
		 return "Update Successfully done";
	}
	
	public String deleteTrain(int id)
	{
		restTemplate.delete(url+"/delete/"+id);
		return "Deleted Successfully";
	}
  
}
