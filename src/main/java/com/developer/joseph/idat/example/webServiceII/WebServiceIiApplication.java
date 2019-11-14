package com.developer.joseph.idat.example.webServiceII;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.developer.joseph.idat.example.webServiceII.models.Properties;

@SpringBootApplication
public class WebServiceIiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebServiceIiApplication.class, args);
	}

	//add class properties to all 
	@Bean
	public Properties getProperties() {
		return new  Properties();
	}
}
		