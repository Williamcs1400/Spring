package com.william.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Hoje � seu dia de sorte... ou n�o";
	}

}
