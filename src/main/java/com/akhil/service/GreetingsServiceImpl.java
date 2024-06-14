package com.akhil.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
@Service
public class GreetingsServiceImpl implements IGreetingsService{

	@Override
	public String greeting() {
		int hours=LocalDateTime.now().getHour();
	
		if(hours<12) {
			return "Good Morning";
		}
		else if(hours<16) {
			return "Good Afternoon";
		}
		else if(hours<20){
			return "Good Evening";
		}
		else
			return "Good Night";
	}

}
