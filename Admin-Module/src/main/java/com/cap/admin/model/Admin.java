package com.cap.admin.model;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Admin {

	@Id
	private String uid;
	private String fname;
	private String mname;
	private String lname;
	private String email;
	private String password;
	
	@DBRef
	private Set<Role> role;
	
	@Indexed(unique = true)
	private String userName;
	
}
