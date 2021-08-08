package com.agniva.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AgnivaAOPExpressions {
	
	//pointcut exp for all package
	@Pointcut("execution(* com.agniva.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	//pointcut for getter methods
	@Pointcut("execution(* com.agniva.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	//pointcut for setter methods
	@Pointcut("execution(* com.agniva.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	//create pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}
	

}
