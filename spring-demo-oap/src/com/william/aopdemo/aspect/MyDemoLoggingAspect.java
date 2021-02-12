package com.william.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//pode usar coringas como * para tipo e retorno e .. para parametros
	@Before("execution(public void com.william.aopdemo.dao.AccountDAO.addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=============> Executing @Before advice on addAccount()");
	}
	
}
