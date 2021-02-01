package com.william.springdemo;

public class TrackCoach implements Coach {
	
	 private FortuneService fortuneService;
	 
	 public TrackCoach() {
		 
	 }
	 
	 public TrackCoach(FortuneService theFortuneService) {
		 fortuneService = theFortuneService;
	 }

	@Override
	public String getDailyWorkout() {
		return "Corra 5km";
	}

	@Override
	public String getDailyFortune() {
		return "Faça isso: " + fortuneService.getFortune();
	}

}
