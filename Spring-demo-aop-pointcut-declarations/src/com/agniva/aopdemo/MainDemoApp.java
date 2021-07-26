package com.agniva.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.agniva.aopdemo.dao.AccountDAO;
import com.agniva.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		//read the spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//call the business method
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount);
		
		//call the accountdao getter/setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
				
		//get the membership bea from spring container
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		//call the membership business method
		theMembershipDAO.addAccount();
		
		//close the context
		context.close();
		
	}

}
