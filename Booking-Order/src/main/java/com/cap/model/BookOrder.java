package com.cap.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class BookOrder {

	@Id
	private String bid;
	private String userName;
	private String email;
	private int trainNumber;
	private String trainName;
	private String ticketType;
	private double amnt;
	private String stratpoint;
	private String endpoint;
	private String time;
//	private int quantity;
	
	
}
