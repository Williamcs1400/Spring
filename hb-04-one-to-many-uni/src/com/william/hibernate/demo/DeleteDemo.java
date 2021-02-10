package com.william.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.william.hibernate.entity.Instructor;
import com.william.hibernate.entity.InstructorDetail;
import com.william.hibernate.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		
		//Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		//Create session
		Session session = factory.getCurrentSession();
		
		try {
			//Star a transaction
			session.beginTransaction();
			
			//Get instructor by primary key / id
			int theId = 2;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			if(tempInstructor != null) {
				System.out.println("Deleting: " + tempInstructor);
				session.delete(tempInstructor);
			}
			
			//Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Daleeee");
			
		}finally {
			factory.close();
		}
	}

}
