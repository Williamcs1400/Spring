package com.william.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.william.hibernate.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		//Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//Create session
		Session session = factory.getCurrentSession();
		
		try {	
			
			int StudentId = 1;
			
			//Create student object
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, StudentId);
			
			myStudent.setFirstName("Willinha");
			
			//Commit transaction
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}
	}

}
