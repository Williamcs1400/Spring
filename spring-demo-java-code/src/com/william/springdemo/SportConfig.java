package com.william.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.william.springdemo")
//@PropertySource("classpath:sport.properties") nao disponivel nessa versao
public class SportConfig {

	@Bean
	public FortuneService doubfulFortuneService() {
		return new DoubfulFortuneService();
	}
	
	@Bean
	public Coach soccerCoach() {
		return new SoccerCoach(doubfulFortuneService());
	}
	
}
