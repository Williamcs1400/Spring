package com.william.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.william.aopdemo.dao.AccountDAO;
import com.william.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		//read spring config config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		//call the business method
		theAccountDAO.addAccount();
		
		theAccountDAO.setName("ABC");
		theAccountDAO.setServiceCode("123");
		
		String n = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
		
		theMembershipDAO.addAccount();
		
		//close the context
		context.close();
	}
}
