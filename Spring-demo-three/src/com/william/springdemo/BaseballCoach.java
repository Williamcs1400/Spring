package com.william.springdemo;

public class BaseballCoach implements Coach{
	
	private FortuneService fortuneService;
	
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		
		return "Passe 30 minutos treinando batida";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
