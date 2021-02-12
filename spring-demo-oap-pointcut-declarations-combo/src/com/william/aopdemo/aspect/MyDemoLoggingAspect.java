package com.william.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	
	@Pointcut("execution(* com.william.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	//pointcut for getters
	@Pointcut("execution(* com.william.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	//pointcut for setters
	@Pointcut("execution(* com.william.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	//pointcut for include package and exclude getters and setters
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=============> Executing @Before advice on addAccount()");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n=============> Perform API Analytics");
	}
}
