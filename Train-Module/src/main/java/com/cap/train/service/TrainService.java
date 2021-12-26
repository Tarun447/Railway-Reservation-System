package com.cap.train.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.train.model.Train;
import com.cap.train.repository.TrainRepository;

@Service
public class TrainService {
	
	@Autowired
	private TrainRepository repository;
	
	public Train addTrain(Train train)
	{
		return repository.save(train);
	}

	
	public Train getById(int id)
	{
		return repository.findById(id).get();
	}
	
	public List<Train> getAll()
	{
		return repository.findAll();
	}
	
	
	public Train updateById(int id,Train train)
	{
		Optional<Train> op = repository.findById(id);
		
		if(op.isPresent())
		{
			Train tr = op.get();
			tr.setTrainName(train.getTrainName());
			tr.setStartLoc(train.getStartLoc());
			tr.setEndLoc(train.getEndLoc());
			tr.setSeat(train.getSeat());
			tr.setTime(train.getTime());
//			tr.setFare(train.getFare());
			tr.setFirstAc(train.getFirstAc());
			tr.setSecondAc(train.getSecondAc());
			tr.setThirdAc(train.getThirdAc());
			tr.setSleeper(train.getSleeper());
			
			return repository.save(tr);
		}
		else
		{
		return null;
		}
		
	}
	
	public String delete(int id)
	{
		repository.deleteById(id);
		return "Train have Deleted";
	}
	
	public List<Train> findbyName(String trainName)
	{
		return repository.findByTrainName(trainName);
	}
	
	public List<Train> findBylocation(String start,String end)
	{
		return repository.findByStartLocAndEndLoc(start, end);
	}
}
