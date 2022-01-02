package com.cap;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.cap.controller.BookOrderController;
import com.cap.model.BookOrder;
import com.cap.service.BookOrderService;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@ContextConfiguration
@SpringBootTest(classes=BookOrderControllerMVCTest.class)
public class BookOrderControllerMVCTest {

	
	@Autowired
	MockMvc mockmvc;
	
	@Mock
	BookOrderService service;
	
	@InjectMocks
	BookOrderController controller;
	
	BookOrder order;
	
	@BeforeEach
	public void setUp()
	{
		mockmvc = MockMvcBuilders.standaloneSetup(controller).build();
		order = new BookOrder("1","Traun","xyz@gmail.com",1212121,"Pune Intercity","thirdAC",2675.00,"Pune","MUmbai","8.14");
	}
	
	
	@Test
	public void TestCreateBook() throws Exception
	{
		when(service.addBook(order)).thenReturn(order);
		ObjectMapper mapper = new ObjectMapper();
		String jsonbody = mapper.writeValueAsString(order);
		mockmvc.perform(post("/book/makebook").content(jsonbody)
				.contentType(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath(".bid").value("1"))
		        .andExpect(jsonPath(".userName").value("Traun"))
		        .andExpect(jsonPath(".email").value("xyz@gmail.com"))
		        .andExpect(jsonPath(".trainNumber").value(1212121))
		        .andExpect(jsonPath(".trainName").value("Pune Intercity"))
		        .andExpect(jsonPath(".ticketType").value("thirdAC"))
		        .andExpect(jsonPath(".amnt").value(2675.00))
				.andExpect(jsonPath(".stratpoint").value("Pune"))
				.andExpect(jsonPath(".endpoint").value("MUmbai"))
				.andExpect(jsonPath(".time").value("8.14"));
//				.andExpect(jsonPath(".quantity").value(8));
	}
	
	
	@Test
	public void TestFindBookById() throws Exception
	{
		when(service.findId("1")).thenReturn(order);
	    mockmvc.perform(get("/book/findBook/{id}","1"))
	    .andExpect(jsonPath(".bid").value("1"))
        .andExpect(jsonPath(".userName").value("Traun"))
        .andExpect(jsonPath(".email").value("xyz@gmail.com"))
        .andExpect(jsonPath(".trainNumber").value(1212121))
        .andExpect(jsonPath(".trainName").value("Pune Intercity"))
        .andExpect(jsonPath(".ticketType").value("thirdAC"))
        .andExpect(jsonPath(".amnt").value(2675.00))
		.andExpect(jsonPath(".stratpoint").value("Pune"))
		.andExpect(jsonPath(".endpoint").value("MUmbai"))
		.andExpect(jsonPath(".time").value("8.14"));
//		.andExpect(jsonPath(".quantity").value(8));
	}
	
	
	@Test
	public void TestUpdateBookOrder() throws Exception
	{
		when(service.findId("1")).thenReturn(order);
		when(service.updateId("1", order)).thenReturn(order);

		ObjectMapper mapper = new ObjectMapper();
		String jsonbody = mapper.writeValueAsString(order);
		mockmvc.perform(put("/book/update/{id}","1").content(jsonbody)
			    .contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath(".bid").value("1"))
		        .andExpect(jsonPath(".userName").value("Traun"))
		        .andExpect(jsonPath(".email").value("xyz@gmail.com"))
		        .andExpect(jsonPath(".trainNumber").value(1212121))
		        .andExpect(jsonPath(".trainName").value("Pune Intercity"))
		        .andExpect(jsonPath(".ticketType").value("thirdAC"))
		        .andExpect(jsonPath(".amnt").value(2675.00))
				.andExpect(jsonPath(".stratpoint").value("Pune"))
				.andExpect(jsonPath(".endpoint").value("MUmbai"))
				.andExpect(jsonPath(".time").value("8.14"));
//				.andExpect(jsonPath(".quantity").value(8));
	}
	
	
	@Test
	public void TestDeleteBookOrder() throws Exception
	{
		mockmvc.perform(delete("/book/delete/{id}","1"))
		 .andExpect(status().isOk())
		 .andDo(print());
	}
}
