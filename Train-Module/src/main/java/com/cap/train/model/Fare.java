package com.cap.train.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fare {
	
	private double firstAc;
	private double secondAc;
	private double thirdAc;
	private double sleeper;

}
