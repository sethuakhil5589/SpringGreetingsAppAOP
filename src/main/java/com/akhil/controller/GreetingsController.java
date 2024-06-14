package com.akhil.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.akhil.service.IGreetingsService;

@Controller
public class GreetingsController {


	
	@Autowired
	IGreetingsService service;
	
	@GetMapping("/gr")
	public String greetingMessage(Map<String, Object> model) {
		model.put("greet", service.greeting());
		return "greet";
	}
	
	@GetMapping("/greet")
	public Map<String,Object> greetingMessages() {
		Map<String, Object> map=new HashMap<>();
		
		String greet=service.greeting();
		map.put("greet", greet);
		return map;
		
	
	}
}
