package com.william.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.william.hibernate.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//Create session
		Session session = factory.getCurrentSession();
		
		try {	
			//Star a transaction
			session.beginTransaction();
			
			//Query students
			List<Student> theStudents=  session.createQuery("from Student").getResultList();
			
			//Display the students
			displayStudents(theStudents);
			
			//Others
			theStudents = session.createQuery("from Student s where s.lastName='Messi'").getResultList();
			System.out.println("\n");
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where s.lastName='Messi' OR s.firstName='Neymar'").getResultList();
			System.out.println("\n");
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where s.email LIKE '%wills'").getResultList();
			System.out.println("\n");
			displayStudents(theStudents);
			
			//Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Daleeee");
			
		}finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent );
		}
	}

}
