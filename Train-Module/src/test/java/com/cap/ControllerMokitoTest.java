package com.cap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cap.train.controller.TrainController;
//import com.cap.train.model.Fare;
import com.cap.train.model.Train;
import com.cap.train.service.TrainService;

@SpringBootTest(classes=ControllerMokitoTest.class)
public class ControllerMokitoTest {
	
	@Mock
	TrainService service;
	
	@InjectMocks
	TrainController controller;
	
	List<Train> train;
	
	Train t;
	
	
	@Test
	public void TestCreateTrain()
	{

		Train train = new Train (12121,"Bandra","bandra","Mumbai",400,"6.45", 5898.00,3564.00,2454.00,675.00);
		when(service.addTrain(train)).thenReturn(train);
        assertEquals(train, controller.createTrain(train));
		
	}
	
	
	
	@Test
	public void TestAllTrain()
	{
        train = new ArrayList<Train>();
		train.add(new Train (12121,"Bandra","bandra","Mumbai",400,"6.45", 5898.00,3564.00,2454.00,675.00));
		train.add(new Train (12122,"Pune Express","Pune","delhi",400,"6.45", 5898.00,3564.00,2454.00,675.00));
		when(service.getAll()).thenReturn(train);
		assertEquals(2, controller.allTrain().size());
		
	}
	
	@Test
	public void TestFindByNumber()
	{
		t = new Train (12121,"Bandra","bandra","Mumbai",400,"6.45", 5898.00,3564.00,2454.00,675.00);
	    when(service.getById(12121)).thenReturn(t);
	    assertEquals(12121,controller.findByTrainNumber(12121).getTrainNum() );
	    
	}
	
	@Test
	public void TestFindByName()
	{
		List<Train> train = new ArrayList<Train>();
		train.add(new Train (12122,"Pune Express","Pune","delhi",400,"6.45", 5898.00,3564.00,2454.00,675.00));
		when(service.findbyName("Pune Express")).thenReturn(train);
		assertEquals(1, controller.findbyname("Pune Express").size());
	}
	
	
	@Test
	public  void TestFindbyLoc()
	{
		List<Train> train = new ArrayList<Train>();
		train.add(new Train (12122,"Pune Express","Pune","delhi",400,"6.45", 5898.00,3564.00,2454.00,675.00));
		when(service.findBylocation("Pune", "delhi")).thenReturn(train);
		assertEquals(1,controller.findbyloc("Pune","delhi").size());
	}
	
	
	@Test
	public void TestupdateTrain()
	{
		t = new Train (12121,"Bandra","bandra","Mumbai",400,"6.45", 5898.00,3564.00,2454.00,675.00);
		when(service.updateById(12121, t)).thenReturn(t);
		assertEquals(t,controller.updateTrain(12121, t));
	}
	
	
	@Test
	public void TestDeleteTrain()
	{
		t = new Train (12121,"Bandra","bandra","Mumbai",400,"6.45", 5898.00,3564.00,2454.00,675.00);
		when(service.delete(12121)).thenReturn("hello");
		assertEquals("hello", controller.deleteTrain(12121));
	}

}
