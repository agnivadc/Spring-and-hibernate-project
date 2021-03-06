package com.agniva.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {


		//load the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve the bean from container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		//check if they are same
		boolean result = (theCoach==alphaCoach);
		
		//print the results
		
		System.out.println("\nPointing to same object : "+ result);
		
		System.out.println("\nMemory location for theCoach : "+ theCoach);
		
		System.out.println("\nMemory location for alphaCoach : "+ alphaCoach +"\n");
		
		//close the context
		context.close();
		
	}

}
