package com.william.springdemo;

public class DoubfulFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "O que será que vai acontecer hoje?";
	}

}
