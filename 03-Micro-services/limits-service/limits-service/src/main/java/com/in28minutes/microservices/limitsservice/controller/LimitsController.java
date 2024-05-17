package com.in28minutes.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.limitsservice.configuration.Configuration;
import com.in28minutes.microservices.limitsservice.controller.bean.Limits;

@RestController
public class LimitsController {
	
	@Autowired
	private Configuration configuration;

	@GetMapping("/limits")
	public Limits retriveLimits() {		
		
		return new Limits( configuration.getMinimum(), configuration.getMaximum() );
	}

}
