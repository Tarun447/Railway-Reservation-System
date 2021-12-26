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
	private Integer  trainNum;
	private String  trainName;
	private String startLoc;
	private String endLoc;
	private Integer seat;
	private String time;
	private double firstAc;
	private double secondAc;
	private double thirdAc;
	private double sleeper;
}
