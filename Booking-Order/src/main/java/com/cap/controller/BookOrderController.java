package com.cap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cap.model.BookOrder;
import com.cap.service.BookOrderService;



@RestController
@RequestMapping("/book")
public class BookOrderController {
	
	@Autowired
	private BookOrderService service;
	
	@PostMapping("/makebook")
	public BookOrder createBook(@RequestBody BookOrder order)
	{
		return service.addBook(order);
		
	}
	
	
	@GetMapping("/findBook/{id}")
	public BookOrder getBookById(@PathVariable("id") String id)
	{
		return service.findId(id);
	}
	
	@PutMapping("/update/{id}")
   public BookOrder updateBook(@PathVariable("id") String id,@RequestBody BookOrder order)
   {
		return service.updateId(id, order);
   }
	
	@DeleteMapping("/delete/{id}")
	public void deletBook(@PathVariable("id") String id)
	{
		service.delete(id);
	}
}
