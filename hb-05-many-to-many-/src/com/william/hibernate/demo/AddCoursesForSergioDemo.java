package com.william.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.william.hibernate.entity.Course;
import com.william.hibernate.entity.Instructor;
import com.william.hibernate.entity.InstructorDetail;
import com.william.hibernate.entity.Review;
import com.william.hibernate.entity.Student;

public class AddCoursesForSergioDemo {

	public static void main(String[] args) {
		
		//Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//Create session
		Session session = factory.getCurrentSession();
		
		try {	
			//Star a transaction
			session.beginTransaction();
			
			int studentId = 5;
			Student tempStudent = session.get(Student.class, studentId);
			
			Course tempCourse1 = new Course("Cabeçada ofensiva"); 
			Course tempCourse2 = new Course("Cabeçada defensiva");
			Course tempCourse3 = new Course("Salto");
			
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			tempCourse3.addStudent(tempStudent);
			
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
