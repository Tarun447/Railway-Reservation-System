package com.cap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cap.model.BookOrder;
import com.cap.repository.BookOrderRepository;
import com.cap.service.BookOrderService;


@SpringBootTest(classes=BookOrderServiceTest.class)
public class BookOrderServiceTest {
	
	@Mock
	BookOrderRepository repo;
	
	@InjectMocks
	BookOrderService service;
	
	BookOrder order;
	
	@Test
	public void TestCreateBook()
	{
		order = new BookOrder("1","797739876387","Traun",1212121,"Pune Intercity","thirdAC",2675.00,"Pune","MUmbai","8.14",8);
		when(repo.save(order)).thenReturn(order);
        assertEquals(order, service.addBook(order));
	}
	
	
	@Test
	public void TestGetById()
	{
		order = new BookOrder("1","797739876387","Traun",1212121,"Pune Intercity","thirdAC",2675.00,"Pune","MUmbai","8.14",8);
		Optional<BookOrder> op = Optional.of(order);
		when(repo.findById("1")).thenReturn(op);
		assertEquals("1",service.findId("1").getBid());	
	}
	
	@Test
	public void TestUpdateById()
	{
		order = new BookOrder("1","797739876387","Traun",1212121,"Pune Intercity","thirdAC",2675.00,"Pune","MUmbai","8.14",8);
		Optional<BookOrder> op = Optional.of(order);
		when(repo.findById("1")).thenReturn(op);
		when(repo.save(op.get())).thenReturn(order);
		assertEquals(order,service.updateId("1", op.get()));
	}
	
	@Test
	public void TestBookDelete()
	{
		order = new BookOrder("1","797739876387","Traun",1212121,"Pune Intercity","thirdAC",2675.00,"Pune","MUmbai","8.14",8);
		service.delete("1");
		verify(repo).deleteById("1");
	}

}
