package com.agniva.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println("TennisCoach: inside default constructor");
	}
	
	//define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("Inside startup method");
	}
	
	@PreDestroy
	//define my init method
		public void doMyCleanupStuff() {
			System.out.println("Inside cleanup method");
		}
		
		
	/*
	@Autowired
	public TennisCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}*/

	//define a setter method
	
	/*@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("TennisCoach: inside setFortuneService method");
		this.fortuneService = fortuneService;
	}*/

	@Override
	public String getDailyWorkout() {
		
		return "Practice ypur backhand volley!";
	}

	@Override
	public String getDailyFortune() {

		return fortuneService.getFortune();
	}

}
