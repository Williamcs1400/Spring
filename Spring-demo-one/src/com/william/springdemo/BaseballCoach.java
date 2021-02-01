package com.william.springdemo;

public class BaseballCoach implements Coach{
	
	@Override
	public String getDailyWorkout() {
		
		return "Passe 30 minutos treinando batida";
	}
}
