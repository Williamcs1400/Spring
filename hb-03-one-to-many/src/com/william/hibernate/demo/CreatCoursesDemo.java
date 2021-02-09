package com.william.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.william.hibernate.entity.Course;
import com.william.hibernate.entity.Instructor;
import com.william.hibernate.entity.InstructorDetail;

public class CreatCoursesDemo {

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
			
			//get the instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			//create some courses
			Course tempCourse1 =  new Course("Embaixadinha");
			Course tempCourse2 =  new Course("Lençou");
			Course tempCourse3 =  new Course("Bater falta");
			
			//add courses to instructor
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			tempInstructor.add(tempCourse3);
			
			//save the courses
			session.save(tempCourse1);
			session.save(tempCourse2);
			session.save(tempCourse3);
			
			//Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Daleeee");
			
		}finally {
			session.close();
			
			factory.close();
		}
	}

}
