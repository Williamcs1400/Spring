package com.william.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Hoje é seu dia de sorte... ou não";
	}

}
