package com.william.springdemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.Files;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.Scanner;

@Component
public class ReadFortuneService implements FortuneService {

	private Random random = new Random();
	
	@Override
	public String getFortune() {
		
		//Tenta criar o arquivo
		 try {
		      File myFile = new File("file.txt");
		      if (myFile.createNewFile()) {
		        System.out.println("Arquivo Criado: " + myFile.getName());
		      } else {
		        System.out.println("Arquivo ja existe");
		      }
		    } catch (IOException e) {
		      System.out.println("Erro em criar o arquivo");
		      e.printStackTrace();
		    }
		 
		 //Escreve no arquivo
		 try {
		      FileWriter escreve = new FileWriter("file.txt");
		      escreve.write("Você é capaz\r\n"
		      		+ "Acredite no seu potencial\r\n"
		      		+ "Corra mais rápido e chegará primeiro");
		      escreve.close();
		      System.out.println("Sucesso em escrever");
		    } catch (IOException e) {
		      System.out.println("Erro em escrever");
		      e.printStackTrace();
		    }
		 
		//Verifica qtd de linhas do arquivo
		LineNumberReader lnr = null;	
		try {
			lnr = new LineNumberReader(new FileReader("file.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 try {
			lnr.skip(Long.MAX_VALUE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 int qtd = lnr.getLineNumber();
		 qtd++;
		 
		 //Pega um numero aleatorio
		 int index = random.nextInt(qtd);
		 
		 String data = "";
		
		 //Le o arquivo e seleciona a linha
		 try {
			 int aux = 0;
			 File myFile = new File("file.txt");
			 Scanner sc = new Scanner(myFile);
			 while(aux <= index) {
				 data = sc.nextLine();
				 aux++;
			 }
		 }catch (FileNotFoundException e) {
		      System.out.println("Erro em ler");
		      e.printStackTrace();
		 }
		 
		return data;
	}

}
