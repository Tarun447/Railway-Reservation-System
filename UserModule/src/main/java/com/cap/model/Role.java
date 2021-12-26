package com.cap.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Role implements GrantedAuthority {

	@Id
	private String rid;
	@Indexed(unique = true)
	private String role;
	@Override
	public String getAuthority() {
		
		return role;
	}

}
