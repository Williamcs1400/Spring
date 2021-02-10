package com.william.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.william.hibernate.entity.Course;
import com.william.hibernate.entity.Instructor;
import com.william.hibernate.entity.InstructorDetail;
import com.william.hibernate.entity.Review;

public class GetCoursesAndReviewDemo {

	public static void main(String[] args) {
		
		//Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		//Create session
		Session session = factory.getCurrentSession();
		
		try {	
			//Star a transaction
			session.beginTransaction();
			
			//get the course
			int theId = 10;
			Course tempCourse = session.get(Course.class, theId);
			
			//print the course
			System.out.println(tempCourse);
			
			//print the course review
			System.out.println(tempCourse.getReview());
			
			//Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Daleeee");
			
		}finally {
			session.close();
			
			factory.close();
		}
	}

}
