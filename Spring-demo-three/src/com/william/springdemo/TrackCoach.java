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
		return "Fa�a isso: " + fortuneService.getFortune();
	}
	
	public void startMethod() {
		System.out.println("TrackCoach: inside startMethod");
	}
	
	public void cleanMethod() {
		System.out.println("TrackCoach: inside cleanMethod");
	}

}
