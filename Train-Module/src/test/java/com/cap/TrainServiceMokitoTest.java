package com.cap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

//import com.cap.train.model.Fare;
import com.cap.train.model.Train;
import com.cap.train.repository.TrainRepository;
import com.cap.train.service.TrainService;

@SpringBootTest(classes= {TrainServiceMokitoTest.class})
public class TrainServiceMokitoTest {
	
	//  create Mock Repo with name Train Repository
	@Mock
	TrainRepository repo;
	
	// create Mock service
	@InjectMocks
	TrainService service;
	
	public List<Train> train;
	
	
	
	@Test
	public void TestAddTrain()
	{
		Train train = new Train (12121,"Bandra","bandra","Mumbai",400,"6.45", 5898.00,3564.00,2454.00,675.00);
		when(repo.save(train)).thenReturn(train);
        assertEquals(train, service.addTrain(train));
	}
	
	
	
	@Test
	public void  TestGetAll()
	{
		List<Train> train = new ArrayList<Train>();
		train.add(new Train (12121,"Bandra","bandra","Mumbai",400,"6.45", 5898.00,3564.00,2454.00,675.00));
		train.add(new Train (12122,"Pune Express","Pune","delhi",400,"6.45",5898.00,3564.00,2454.00,675.00));
		when(repo.findAll()).thenReturn(train); //mocking
		assertEquals(2,service.getAll().size());;
	}
	
	@Test
	public void TestGetById()
	{
		Train train = new Train (12121,"Bandra","bandra","Mumbai",400,"6.45", 5898.00,3564.00,2454.00,675.00);
		Optional<Train> op = Optional.of(train);
		when(repo.findById(12121)).thenReturn(op);
		assertEquals(12121,op.get().getTrainNum());
		
	}
	
	@Test
	public void TestfindByName()
	{
		List<Train> train = new ArrayList<Train>();
		train.add(new Train (12122,"Pune Express","Pune","delhi",400,"6.45", 5898.00,3564.00,2454.00,675.00));
		when(repo.findByTrainName("Pune Express")).thenReturn(train);
		assertEquals(1, service.findbyName("Pune Express").size());
	}
	
	@Test
	public void TestFindByLocation()
	{
		List<Train> train = new ArrayList<Train>();
		train.add(new Train (12122,"Pune Express","Pune","delhi",400,"6.45", 5898.00,3564.00,2454.00,675.00));
		when(repo.findByStartLocAndEndLoc("Pune", "delhi")).thenReturn(train);
		assertEquals(1,service.findBylocation("Pune","delhi").size());
	}
	
	
	@Test
	public void TestUpdateById()
	{
		Train train = new Train (12121,"Bandra","bandra","Mumbai",400,"6.45", 5898.00,3564.00,2454.00,675.00);
		Optional<Train> op = Optional.of(train);
		when(repo.findById(12121)).thenReturn(op);
		when(repo.save(op.get())).thenReturn(train);
		assertEquals(train,service.updateById(12121, op.get()));
	}
	
//	@Test
//	public void TestDelete()
//	{
//		Train train = new Train (12121,"Bandra","bandra","Mumbai",400,"6.45", new Fare(5898.00,3564.00,2454.00,675.00));
//		verify(repo,times(1)).deleteById(1212);
//		
//	}
	
	
	

}
