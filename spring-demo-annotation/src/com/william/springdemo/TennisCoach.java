package com.william.springdemo;

import org.springframework.stereotype.Component;

@Component("Jose")
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Pratique com a parede durante 2 horas";
	}

}
