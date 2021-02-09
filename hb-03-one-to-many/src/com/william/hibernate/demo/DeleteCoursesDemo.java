package com.william.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.william.hibernate.entity.Course;
import com.william.hibernate.entity.Instructor;
import com.william.hibernate.entity.InstructorDetail;

public class DeleteCoursesDemo {

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
			//Star a transaction
			session.beginTransaction();
			
			//get a course
			int theId = 11;
			Course tempCourse = session.get(Course.class, theId);
			
			//delete course
			session.delete(tempCourse);
			
			//Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Daleeee");
			
		}finally {
			session.close();
			
			factory.close();
		}
	}

}
