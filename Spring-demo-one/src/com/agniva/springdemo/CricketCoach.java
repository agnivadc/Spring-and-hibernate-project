package com.agniva.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	
	//new fields of email and team
	private String emailAddress;
	private String team;
		
	public CricketCoach() {
		System.out.println("CricketCoach: Inside the default Constructor");
	}

	public CricketCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	//our setter method
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach : inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		System.out.println("CricketCoach : inside setter method - setEmailAddress");
	}

	public void setTeam(String team) {
		this.team = team;
		System.out.println("CricketCoach : inside setter method - setTeam");
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
	}

	@Override
	public String getDailyWorkout() {

		return "Practice 500 balls from the machine";
	}

	@Override
	public String getDailyFortune() {
		 
		return "Impossible is Nothing! : " + fortuneService.getFortune();
	}


}
