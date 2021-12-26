package com.cap.train.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cap.train.model.Train;
import com.cap.train.service.TrainService;

@RestController
@RequestMapping("/train")
@CrossOrigin(origins = "*")
public class TrainController {
	

	
	@Autowired
	private TrainService service;
	
	@PostMapping("/add-train")
	public Train createTrain(@RequestBody Train train)
	{	
		return service.addTrain(train);
	}

	
	@GetMapping("/allTrain")
	    public List<Train> allTrain()
	    {
	    	return service.getAll();
	    }
	
	@GetMapping("/find/{id}")
	public Train findByTrainNumber(@PathVariable ("id") int id)
	{
		  return service.getById(id);
	}
	
	@PutMapping("/update/{id}")
	public Train updateTrain(@PathVariable("id") int id,@RequestBody Train train)
	{
		return service.updateById(id, train);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteTrain(@PathVariable("id") int id)
	{
		return service.delete(id);
	}
	@GetMapping("/find-train/{name}")
	public List<Train> findbyname(@PathVariable("name") String name)
	{
		return service.findbyName(name);
	}
	
	@GetMapping("/find/{start}/{end}")
	public List<Train> findbyloc(@PathVariable("start") String start,@PathVariable("end") String end)
	{
		return service.findBylocation(start, end);
	}
	
}
