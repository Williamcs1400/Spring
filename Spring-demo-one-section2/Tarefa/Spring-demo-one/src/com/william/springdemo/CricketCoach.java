package com.william.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	
	//Novos campos
	private String emailAnddress;
	private String team;

	
	public CricketCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
		
	}

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inserir com metodo setter - setFortuneService");
		this.fortuneService = fortuneService;
	}

	public String getEmailAnddress() {
		return emailAnddress;
	}

	public void setEmailAnddress(String emailAnddress) {
		System.out.println("CricketCoach: inserir com metodo setter - setEmailAnddress");
		this.emailAnddress = emailAnddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: inserir com metodo setter - setTeam");
		this.team = team;
	}

	@Override
	public String getDailyWorkout() {
		return "Pratique com a raquete durante 20 minutos";
	}

	@Override
	public String getDailyFortune() {
		return "Vai se dar mal hoje";
	}

}
