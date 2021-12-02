package com.cap;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.cap.train.repository")
@ComponentScan("com.cap.*")
@EnableEurekaClient
public class TrainModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainModuleApplication.class, args);
	}

}
