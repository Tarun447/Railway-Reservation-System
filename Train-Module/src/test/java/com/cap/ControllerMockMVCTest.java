package com.cap;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cap.train.controller.TrainController;
//import com.cap.train.model.Fare;
import com.cap.train.model.Train;
import com.cap.train.service.TrainService;
import com.fasterxml.jackson.databind.ObjectMapper;





@AutoConfigureMockMvc
@ContextConfiguration
@SpringBootTest(classes=ControllerMockMVCTest.class)
public class ControllerMockMVCTest {
	
	@Autowired
	MockMvc mockmvc;
	
	@Mock
	TrainService service;
	
	@InjectMocks
	TrainController controller;
	
	
	List<Train> train;
	Train t;
	
	@BeforeEach
	public void setUp()
	{
		mockmvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	
	@Test
	public void TestCreateTrain()throws Exception
	{
		t = new Train (12121,"Bandra","bandra","Mumbai",400,"6.45", 5898.0,3564.0,2454.0,675.0);
		
		when(service.addTrain(t)).thenReturn(t);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonbody = mapper.writeValueAsString(t);
		
		mockmvc.perform(post("/train/add-train").content(jsonbody)
				.contentType(MediaType.APPLICATION_JSON))
		      .andExpect(jsonPath(".trainNum").value(12121))
	        .andExpect(jsonPath(".trainName").value("Bandra"))
	        .andExpect(jsonPath(".startLoc").value("bandra"))
	        .andExpect(jsonPath(".endLoc").value("Mumbai"))
	        .andExpect(jsonPath(".seat").value(400))
	        .andExpect(jsonPath(".time").value("6.45"))
	        .andExpect(jsonPath(".firstAc").value(5898.0))
			.andExpect(jsonPath(".secondAc").value(3564.0))
			.andExpect(jsonPath(".thirdAc").value(2454.0))
			.andExpect(jsonPath(".sleeper").value(675.0));
		       
	}
	
	
	@Test
	public void TestGetAll() throws Exception
	{
		train = new ArrayList<Train>();
		train.add(new Train (12121,"Bandra","bandra","Mumbai",400,"6.45", 5898.0,3564.0,2454.0,675.0));
		when(service.getAll()).thenReturn(train);
		mockmvc.perform(get("/train/allTrain"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].trainNum", is(12121)))
        .andExpect(jsonPath("$[0].trainName", is("Bandra")))
        .andExpect(jsonPath("$[0].startLoc", is("bandra")))
        .andExpect(jsonPath("$[0].endLoc", is("Mumbai")))
        .andExpect(jsonPath("$[0].seat", is(400)))
        .andExpect(jsonPath("$[0].time", is("6.45")))
        .andExpect(jsonPath("$[0].firstAc", is(5898.0)))
		.andExpect(jsonPath("$[0].secondAc", is(3564.0)))
		.andExpect(jsonPath("$[0].thirdAc", is(2454.0)))
		.andExpect(jsonPath("$[0].sleeper", is(675.0)));
	}
	
	
	@Test
	public void TestFindByNumber() throws Exception
	{

		t = new Train (12121,"Bandra","bandra","Mumbai",400,"6.45", 5898.0,3564.0,2454.0,675.0);
	    when(service.getById(12121)).thenReturn(t);
	    mockmvc.perform(get("/train/find/{id}",12121))
	    .andExpect(jsonPath(".trainNum").value(12121))
        .andExpect(jsonPath(".trainName").value("Bandra"))
        .andExpect(jsonPath(".startLoc").value("bandra"))
        .andExpect(jsonPath(".endLoc").value("Mumbai"))
        .andExpect(jsonPath(".seat").value(400))
        .andExpect(jsonPath(".time").value("6.45"))
        .andExpect(jsonPath(".firstAc").value(5898.0))
		.andExpect(jsonPath(".secondAc").value(3564.0))
		.andExpect(jsonPath(".thirdAc").value(2454.0))
		.andExpect(jsonPath(".sleeper").value(675.0));
	  
	}
	
	

	@Test
	public void TestFindByName() throws Exception
	{

		train = new ArrayList<Train>();
		train.add(new Train (12121,"Bandra","bandra","Mumbai",400,"6.45", 5898.0,3564.0,2454.0,675.0));
		train.add(new Train (12122,"Pune Express","Pune","delhi",400,"6.45", 5898.00,3564.00,2454.00,675.00));
		when(service.findbyName("Bandra")).thenReturn(train);
		
		mockmvc.perform(get("/train/find-train/{name}","Bandra")) 
      	.andExpect(jsonPath("$", hasSize(2)))
      	
        .andExpect(jsonPath("$[0].trainNum", is(12121)))
        .andExpect(jsonPath("$[0].trainName", is("Bandra")))
        .andExpect(jsonPath("$[0].startLoc", is("bandra")))
        .andExpect(jsonPath("$[0].endLoc", is("Mumbai")))
        .andExpect(jsonPath("$[0].seat", is(400)))
        .andExpect(jsonPath("$[0].time", is("6.45")))
        .andExpect(jsonPath("$[0].firstAc", is(5898.0)))
		.andExpect(jsonPath("$[0].secondAc", is(3564.0)))
		.andExpect(jsonPath("$[0].thirdAc", is(2454.0)))
		.andExpect(jsonPath("$[0].sleeper", is(675.0)));
	  
	}
	
	@Test
	public void TestFindByloc() throws Exception
	{

		train = new ArrayList<Train>();
		train.add(new Train (12121,"Bandra","bandra","Mumbai",400,"6.45", 5898.0,3564.0,2454.0,675.0));
		train.add(new Train (12122,"Pune Express","Pune","delhi",400,"6.45", 5898.00,3564.00,2454.00,675.00));
		when(service.findBylocation("bandra","Mumbai")).thenReturn(train);
		mockmvc.perform(get("/train/find/{start}/{end}","bandra","Mumbai")) 
      	.andExpect(jsonPath("$", hasSize(2)))
        .andExpect(jsonPath("$[0].trainNum", is(12121)))
        .andExpect(jsonPath("$[0].trainName", is("Bandra")))
        .andExpect(jsonPath("$[0].startLoc", is("bandra")))
        .andExpect(jsonPath("$[0].endLoc", is("Mumbai")))
        .andExpect(jsonPath("$[0].seat", is(400)))
        .andExpect(jsonPath("$[0].time", is("6.45")))
        .andExpect(jsonPath("$[0].firstAc", is(5898.0)))
		.andExpect(jsonPath("$[0].secondAc", is(3564.0)))
		.andExpect(jsonPath("$[0].thirdAc", is(2454.0)))
		.andExpect(jsonPath("$[0].sleeper", is(675.0)));
	  
	}
	
	
	@Test
	public void TestUpdateTrain() throws Exception
	{
		t = new Train (12121,"Bandra","bandra","Mumbai",400,"6.45", 5898.0,3564.0,2454.0,675.0);
		when(service.getById(12121)).thenReturn(t);
		when(service.updateById(12121, t)).thenReturn(t);
		
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonbody = mapper.writeValueAsString(t);
		
         mockmvc.perform(put("/train/update/{id}",12121).content(jsonbody)
		    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath(".trainNum").value(12121))
	        .andExpect(jsonPath(".trainName").value("Bandra"))
	        .andExpect(jsonPath(".startLoc").value("bandra"))
	        .andExpect(jsonPath(".endLoc").value("Mumbai"))
	        .andExpect(jsonPath(".seat").value(400))
	        .andExpect(jsonPath(".time").value("6.45"))
	        .andExpect(jsonPath(".firstAc").value(5898.0))
			.andExpect(jsonPath(".secondAc").value(3564.0))
			.andExpect(jsonPath(".thirdAc").value(2454.0))
			.andExpect(jsonPath(".sleeper").value(675.0));;
         
         
	}
	
	
	@Test
	public void TestDeletetrain() throws Exception
	{
		t = new Train (12121,"Bandra","bandra","Mumbai",400,"6.45", 5898.0,3564.0,2454.0,675.0);
//		when(service.getById(12121)).thenReturn(t);
		when(service.delete(12121)).thenReturn("deleted");
		
		mockmvc.perform(delete("/train/delete/{id}",12121))
		 .andExpect(status().isOk())
		 .andDo(print());
	}
	
	

}
