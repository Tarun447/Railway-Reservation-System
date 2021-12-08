package com.cap.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cap.admin.model.Admin;
import com.cap.admin.repository.AdminRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	
	@Autowired
	private AdminRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Admin user = repository.findByUserName(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("userName not found");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),user.getRole());
	}

}
