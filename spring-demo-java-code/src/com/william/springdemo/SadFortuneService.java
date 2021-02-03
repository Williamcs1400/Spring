package com.william.springdemo;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Hoje será triste";
	}

}
