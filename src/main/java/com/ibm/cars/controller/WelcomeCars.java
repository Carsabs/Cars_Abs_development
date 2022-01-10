package com.ibm.cars.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeCars {
	
	@GetMapping("welcome")
	public ResponseEntity<String> welcomeMessage(){
		return ResponseEntity.ok("Hello CarsaBAs");
	} 

}
