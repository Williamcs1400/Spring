package com.william.springdemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("readFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println("TennisCoach: constructor default");
	}
	
	@PostConstruct
	public void start() {
		String data = "";
		try {
			 int aux = 0;
			 File myFile = new File("file.txt");
			 Scanner sc = new Scanner(myFile);
			 while(sc.hasNextLine()) {
				 data = sc.nextLine();
			 }
		 }catch (FileNotFoundException e) {
		      System.out.println("Erro em ler");
		      e.printStackTrace();
		 }
		System.out.println(data);
		
	}
	
	@PreDestroy
	public void Stop() {
		System.out.println("TennisCoach: stop");
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
