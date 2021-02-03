package com.william.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("readFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println("TennisCoach: constructor default");
	}
	
	/*@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println("TennisCoach: Set injection");
		fortuneService = theFortuneService;
	}*/
	
	/*@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}*/

	@Override
	public String getDailyWorkout() {
		return "Pratique com a parede durante 2 horas";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
