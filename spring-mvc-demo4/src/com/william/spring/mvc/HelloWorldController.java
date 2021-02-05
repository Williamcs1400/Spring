package com.william.spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//Novo metodo controlador para ler dados do formulario e add eles no model
	
	@RequestMapping("/processFormVersionTwo")
	public String letsGo(HttpServletRequest request, Model model) {
		
		//le parametro do formulario html
		String theName = request.getParameter("studentName");
		
		//deixa os dados em maiusculo
		theName = theName.toUpperCase();
		
		//cria a mensagem
		String result = "Opa, " + theName;
		
		//add mensagem no model
		model.addAttribute("message", result);	
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
		
		//deixa os dados em maiusculo
		theName = theName.toUpperCase();
		
		//cria a mensagem
		String result = "Eai, " + theName;
		
		//add mensagem no model
		model.addAttribute("message", result);	
		
		return "helloworld";
				
	}
	
	
}
