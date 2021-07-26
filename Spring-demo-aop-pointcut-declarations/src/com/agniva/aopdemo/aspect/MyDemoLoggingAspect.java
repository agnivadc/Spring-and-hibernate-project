package com.agniva.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//this is where we add all our related advices for logging
	
	//lets start with an @Before advice
	
	//pointcut exp for all package
	@Pointcut("execution(* com.agniva.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	//pointcut for getter methods
	@Pointcut("execution(* com.agniva.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	//pointcut for setter methods
	@Pointcut("execution(* com.agniva.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	@Before("forDaoPackage() && !(getter() || setter())")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n =====> Executing @Before advice on addAccount");
	}
	

}
