package com.william.springdemo;

public class SoccerCoach implements Coach {

	private FortuneService fortuneService;
	
	public SoccerCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Treine finaliza��o hoje";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
