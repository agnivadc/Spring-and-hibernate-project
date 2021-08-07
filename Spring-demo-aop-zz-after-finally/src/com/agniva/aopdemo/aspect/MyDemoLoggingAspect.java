package com.agniva.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.agniva.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@After("execution(* com.agniva.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		//print out which method we are advicing on
				String method = theJoinPoint.getSignature().toShortString();
				System.out.println("\n====> Executing @After Finally on method: " + method);
				
	}
	
	@AfterThrowing(
			pointcut="execution(* com.agniva.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingAccountAdvice(
			JoinPoint theJoinPoint, Throwable theExc) {
		
		//print out which method we are advicing on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n====> Executing @AfterThrowing on method: " + method);
		
		//log the exception
		System.out.println("\n====> The exception is: " + theExc);
	}

	//add a new advice for @AfterReturning on findAccounts method
	
	@AfterReturning(
			pointcut="execution(* com.agniva.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		if(!result.isEmpty()) {
			
			Account temp = result.get(0);
			
			temp.setName("Daffy Duck");
		}
	}
	
	@Before("com.agniva.aopdemo.aspect.AgnivaAOPExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		System.out.println("\n =====> Executing @Before advice on addAccount");
	
	//display the method signature
	MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
	
	System.out.println("Method: " +methodSig);
		
	//display method arguments
	
	//get args
	Object[] args = theJoinPoint.getArgs();
	
	//loop thru args
	for(Object tempArg : args) {
		
		System.out.println(tempArg);
		
		if(tempArg instanceof Account) {
			//downcase and print Account specific stuff
			
			Account theAccount = (Account) tempArg;
			
			System.out.println("account name: " + theAccount.getName());
			System.out.println("account level: " + theAccount.getLevel());
		}
	}
	
	}
}
