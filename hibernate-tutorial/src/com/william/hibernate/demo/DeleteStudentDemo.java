package com.william.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.william.hibernate.entity.Student;

public class DeleteStudentDemo {

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
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, 4);
			
			session.createQuery("delete from Student where id='6'").executeUpdate();
			
			//Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Daleeee");
			
		}finally {
			factory.close();
		}
	}

}
