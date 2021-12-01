package com.cap.train.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Train")
public class Train {
	
	@Id
	private Integer  train_num;
	@Field
	private String  train_Name;
	@Field
	private String start_Loc;
	@Field
	private String end_Loc;
	@Field
	private Integer seat;
	@Field
	private String time;

}
