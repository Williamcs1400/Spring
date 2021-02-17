package com.william.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	//setup Logger 
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	//setup pointcut declarations
	@Pointcut("execution(* com.william.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.william.springdemo.controller.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.william.springdemo.controller.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	//add @Before advice
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("==========>> in @Before: Calling methdo: " + theMethod);
		
		Object[] args = theJoinPoint.getArgs();
		
		for(Object tempArg :  args) {
			myLogger.info("=======>> argument: " + tempArg);
		}
	}
	
	//add @AfterReturning advice
	@AfterReturning(pointcut="forAppFlow()", returning="theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("==========>> in @AfterReturning: from method: " + theMethod);
		
		myLogger.info("=======>> result: " + theResult);
		
	}
	
}
