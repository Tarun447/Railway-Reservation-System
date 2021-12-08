package com.cap.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cap.model.User;
import com.cap.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = repository.findByUserName(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("userName not found");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),user.getRole());
	}

}
