package com.cap.controller;

import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

//import org.json.JSONObject;
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



import com.cap.model.BookOrder;
import com.cap.service.BookOrderService;




@RestController
@CrossOrigin(origins="*")
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
