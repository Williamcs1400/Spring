package com.william.springdemo;

import java.util.Random;

public class random implements FortuneService{

	private String[] data = {
			"Amanha ser� melhor que hoje",
			"N�o desista, o seu objetivo pode estar pr�ximo",
			"Voc� ir� vencer, se trabalhar",
			"Fa�a bondade e com bondade ser� recompensado"
	};
	
	Random random = new Random();
	int i = random.nextInt(data.length);
	
	@Override
	public String getFortune() {
		
		return data[i];
	}

}
