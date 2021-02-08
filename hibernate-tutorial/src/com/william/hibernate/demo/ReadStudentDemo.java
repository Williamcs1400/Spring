package com.william.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.william.hibernate.entity.Student;

public class ReadStudentDemo {

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
			Student tempStudent = new Student("Neymar", "Junior", "ney@mjunior");
			
			//Star a transaction
			session.beginTransaction();
			
			//Save the student object
			System.out.println("Saving the student...");
			session.save(tempStudent);
			
			//Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Saved student. Generated id: " + tempStudent.getId());
			
			//Now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//Retrieve student based on the id: primary key
			System.out.println("\n Getting student with id " + tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get complete: " + myStudent);
			
			//Commit the transaction
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}
	}

}
