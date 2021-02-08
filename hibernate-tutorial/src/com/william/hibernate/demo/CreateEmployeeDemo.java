package com.william.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.william.hibernate.entity.Employee;
import com.william.hibernate.entity.Student;

public class CreateEmployeeDemo {

	public static void main(String[] args) {
		
		//Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		//Create session
		Session session = factory.getCurrentSession();
		
		try {	
			//Create student object
			System.out.println("Creation new Employee objetct...");
			Employee tempEmployee = new Employee("Neymar", "Júnior", "PSG");
			
			//Star a transaction
			session.beginTransaction();
			
			//Save the student object
			System.out.println("Saving the employee...");
			session.save(tempEmployee);
			
			//Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Daleeee");
			
		}finally {
			factory.close();
		}

	}

}
