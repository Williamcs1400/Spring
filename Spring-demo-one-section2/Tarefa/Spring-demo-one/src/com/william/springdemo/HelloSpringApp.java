package com.william.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		//Carrega o arquivo de configuracao spring
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		//Recupera bean do spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
				
		//chama metodos os de been
		System.out.println(theCoach.getDailyWorkout());
		
		//Chama metodos para fortune
		System.out.println(theCoach.getDailyFortune());
		
		//fecha o context
		context.close();
				
	}

}
