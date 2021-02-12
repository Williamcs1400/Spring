package com.william.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.william.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public List<Account> findAccounts(boolean tripWire){
		
		if(tripWire) {
			throw new RuntimeException("No soup for you");
		}
		
		List<Account> myAccounts = new ArrayList<>();
		
		Account temp1 = new Account("William", "Coelho");
		Account temp2 = new Account("Neymar", "Júnior");
		Account temp3 = new Account("Lionel", "Messi");
		
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
		
	}
	
	public void addAccount() {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT"); 
	}

	public String getName() {
		System.out.println(getClass() + ": in get name"); 
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in set name"); 
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in get service code"); 
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in set service code"); 
		this.serviceCode = serviceCode;
	}
}
