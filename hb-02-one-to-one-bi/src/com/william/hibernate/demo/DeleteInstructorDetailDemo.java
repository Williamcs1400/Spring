package com.william.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.william.hibernate.entity.Instructor;
import com.william.hibernate.entity.InstructorDetail;
import com.william.hibernate.entity.Student;

public class DeleteInstructorDetailDemo {

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
			
			//get the instructor detail object
			int theId = 4;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			//print the instructor deail
			System.out.println("tempInstructorDetail: " + tempInstructorDetail);
			
			//print the associated instructor
			System.out.println("tempInstructorDetail.getInstructor(): " + tempInstructorDetail.getInstructor());
			
			//delete
			//break bi-directional link
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			
			session.delete(tempInstructorDetail);
			
			//Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Daleeee");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
			
			factory.close();
		}
	}

}
