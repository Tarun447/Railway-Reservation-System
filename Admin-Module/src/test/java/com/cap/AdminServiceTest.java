package com.cap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cap.admin.model.Admin;
import com.cap.admin.model.Role;
import com.cap.admin.repository.AdminRepository;
import com.cap.admin.repository.RoleRepository;
import com.cap.admin.service.AdminService;
import com.cap.dto.Train;

@SpringBootTest(classes = AdminServiceTest.class)
public class AdminServiceTest {
	
	@Mock
	AdminRepository repo;
	
	@Mock
	RoleRepository role;
	
	@InjectMocks
	AdminService service;
	
     Admin admin;
     
     @Mock
     PasswordEncoder passwordEncoder;
     
     
     Train train;
     
	
	@Test
	public void TestAddAdmin()
	{
		Set<Role> role1 = new HashSet<Role>();
		role1.add(new Role("1","Admin"));
		 admin = new Admin ("1","Tarun","Kumar","Nanda","xyz@gmail.com","1234",role1,"Tarunk");
     	when(repo.save(admin)).thenReturn(admin);
        assertEquals(admin, service.createAdmin(admin));
 
	}
	
	@Test
	public void TestUpdateById()
	{
		Set<Role> role1 = new HashSet<Role>();
		role1.add(new Role("1","Admin"));
		 admin = new Admin ("1","Tarun","Kumar","Nanda","xyz@gmail.com","1234",role1,"Tarunk");
		Optional<Admin> op = Optional.of(admin);
		when(repo.findById("1")).thenReturn(op);
		when(repo.save(op.get())).thenReturn(admin);
		assertEquals(admin,service.updateById("1", op.get()));
	}
	
	@Test
	public void TestFindByName()
	{
		Set<Role> role1 = new HashSet<Role>();
		role1.add(new Role("1","Admin"));
		 admin = new Admin ("1","Tarun","Kumar","Nanda","xyz@gmail.com","1234",role1,"Tarunk");
		 when(repo.findByUserName("TarunK")).thenReturn(admin);
		 assertEquals(admin,service.findUserName("TarunK"));
		
	}
	
	@Test
	public void TestUpdateAdmin()
	{
		Set<Role> role1 = new HashSet<Role>();
		role1.add(new Role("1","Admin"));
		 admin = new Admin ("1","Tarun","Kumar","Nanda","xyz@gmail.com","1234",role1,"Tarunk");
		Optional<Admin> op = Optional.of(admin);
		when(repo.findById("1")).thenReturn(op);
		when(repo.save(op.get())).thenReturn(admin);
		assertEquals(admin,service.updateById("1", admin));
	}
	
	
	
	
	
//	@Test
//	public void TestDeleteAdmin()
//	{
//		Set<Role> role1 = new HashSet<Role>();
//		role1.add(new Role(1l,"Admin"));
//		 admin = new Admin ("1","Tarun","Kumar","Nanda","xyz@gmail.com","1234",role1,"Tarunk");
//		 when(repo.deleteById("1")).thenReturn("Deleted");
//		 assert
//	}
	
	

	
}
