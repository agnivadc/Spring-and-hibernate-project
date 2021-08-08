package com.agniva.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.agniva.aopdemo.dao.AccountDAO;
import com.agniva.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	public static void main(String[] args) {

		//read the spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("\n Main program demo app...calling fortune service");
		
		boolean tripWire = true;
		String data = theFortuneService.getFortune(true);
		
		System.out.println("\nMy fortune is "+data);
		
		//close the context
		context.close();
		
	}

}
