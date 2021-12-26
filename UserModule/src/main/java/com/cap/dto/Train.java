package com.cap.dto;


//import org.springframework.data.mongodb.core.mapping.Document;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Train {
	
	

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