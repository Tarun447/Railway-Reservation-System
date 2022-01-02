package com.cap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cap.controller.BookOrderController;
import com.cap.model.BookOrder;
import com.cap.service.BookOrderService;

@SpringBootTest(classes=BookOrderControllerTest.class)
public class BookOrderControllerTest {
	
	@Mock
	BookOrderService service;
	
	@InjectMocks
	BookOrderController controller;
	
	BookOrder order;
	
	@BeforeEach
	public void startup()
	{
		order = new BookOrder("1","Traun","xyz@gmail.com",1212121,"Pune Intercity","thirdAC",2675.00,"Pune","MUmbai","8.14");
	}
	
	
	@Test
	public void TestcreateBook()
	{
		when(service.addBook(order)).thenReturn(order);
		assertEquals(order, controller.createBook(order));
	}
	
	@Test
	public void TestgetBookById()
	{
		when(service.findId("1")).thenReturn(order);
		assertEquals(order, controller.getBookById("1"));
	}
	
	
	@Test
	public void TestUpdateBook()
	{
		when(service.updateId("1", order)).thenReturn(order);
		assertEquals(order, controller.updateBook("1", order));
	}
	
	@Test
	public void TestDeleteBook()
	{
		controller.deletBook("1");
		verify(service).delete("1");
	}
	
	

}
