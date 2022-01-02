package com.cap.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.model.BookOrder;
import com.cap.repository.BookOrderRepository;


@Service
public class BookOrderService {
	
	@Autowired
	private BookOrderRepository repository;
	
	public BookOrder addBook(BookOrder order)
	{
		return repository.save(order);
		
	}
	
	public BookOrder findId(String id)
	{
		Optional<BookOrder> op = repository.findById(id);
		return op.get();
	}
	
	
	public BookOrder updateId(String id,BookOrder order)
	{
		Optional<BookOrder> op = repository.findById(id);
		BookOrder od =op.get();
		
		od.setUserName(order.getUserName());
		od.setTrainNumber(order.getTrainNumber());
		od.setTrainName(order.getTrainName());
		od.setTicketType(order.getTicketType());
		od.setAmnt(order.getAmnt());
		od.setStratpoint(order.getStratpoint());
		od.setEndpoint(order.getEndpoint());
		od.setTime(order.getTime());
		od.setEmail(order.getEmail());
		
		return repository.save(od);
	}
	
	public void delete(String id)
	{
		repository.deleteById(id);
	}
}
