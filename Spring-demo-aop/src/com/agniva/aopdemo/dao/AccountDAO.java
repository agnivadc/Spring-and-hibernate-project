package com.agniva.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.agniva.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account theAccount) {
		
		System.out.println(getClass() + ": Doing my DB Work: Adding an account");
	}
	
}
