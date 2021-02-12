package com.william.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.william.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@AfterThrowing(pointcut="execution(* com.william.aopdemo.dao.AccountDAO.findAccounts(..))",
				   throwing="theExc")
	public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=============> Executing @AfterReturning method: " + method);
		
		System.out.println("\n=============> resullt exception is: " + theExc);
		
	}
	
	@AfterReturning(pointcut="execution(* com.william.aopdemo.dao.AccountDAO.findAccounts(..))",
					returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=============> Executing @AfterReturning method: " + method);
		
		System.out.println("\n=============> resullt is " + result);
		
		convertAccountNamesToUpperCase(result);
		
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		for(Account temp : result) {
			
			String theUpperName = temp.getName().toUpperCase();
			
			temp.setName(theUpperName);
		
		}
	}

	@Before("com.william.aopdemo.aspect.WillAOPExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n=============> Executing @Before advice on addAccount()");
		
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: " + methodSig);
		
		Object[] args = theJoinPoint.getArgs();
		
		for(Object tempArg: args) {
			System.out.println(tempArg);
		}
	}
}
