package com.william.springdemo;

public class DoubfulFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "O que ser� que vai acontecer hoje?";
	}

}
