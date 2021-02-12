package com.william.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class WillAOPExpressions {
	
	@Pointcut("execution(* com.william.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	//pointcut for getters
	@Pointcut("execution(* com.william.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	//pointcut for setters
	@Pointcut("execution(* com.william.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	//pointcut for include package and exclude getters and setters
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}

}
