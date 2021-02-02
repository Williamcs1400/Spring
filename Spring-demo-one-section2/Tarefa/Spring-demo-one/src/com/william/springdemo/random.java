package com.william.springdemo;

import java.util.Random;

public class random implements FortuneService{

	private String[] data = {
			"Amanha será melhor que hoje",
			"Não desista, o seu objetivo pode estar próximo",
			"Você irá vencer, se trabalhar",
			"Faça bondade e com bondade será recompensado"
	};
	
	Random random = new Random();
	int i = random.nextInt(data.length);
	
	@Override
	public String getFortune() {
		
		return data[i];
	}

}
