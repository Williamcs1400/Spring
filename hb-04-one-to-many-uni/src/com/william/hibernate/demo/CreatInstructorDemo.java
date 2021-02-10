package com.william.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.william.hibernate.entity.Course;
import com.william.hibernate.entity.Instructor;
import com.william.hibernate.entity.InstructorDetail;

public class CreatInstructorDemo {

	public static void main(String[] args) {
		
		//Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		//Create session
		Session session = factory.getCurrentSession();
		
		try {	
			//Create the objects
			Instructor tempInstructor = new Instructor("Neymar", "Junior", "ney@jr.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("www.ney.com.br", "soccer");
			
			//Associate the objetcs
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//Star a transaction
			session.beginTransaction();
			
			//Save the instructor
			session.save(tempInstructor);
			
			//Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Daleeee");
			
		}finally {
			session.close();
			
			factory.close();
		}
	}

}
