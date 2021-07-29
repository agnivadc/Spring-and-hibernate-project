package com.agniva.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	//this is where we add all our related advices for logging
	
	//lets start with an @Before advice
	
	@Before("com.agniva.aopdemo.aspect.AgnivaAOPExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n =====> Executing @Before advice on addAccount");
	}

}
