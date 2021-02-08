package com.william.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.william.hibernate.entity.Student;

public class CreatStudentDemo {

	public static void main(String[] args) {
		
		//Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//Create session
		Session session = factory.getCurrentSession();
		
		try {	
			//Create student object
			System.out.println("Creation new student objetct...");
			Student tempStudent = new Student("Lionel", "Messi", "leo@messi");
			
			//Star a transaction
			session.beginTransaction();
			
			//Save the student object
			System.out.println("Saving the student...");
			session.save(tempStudent);
			
			//Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Daleeee");
			
		}finally {
			factory.close();
		}
	}

}
