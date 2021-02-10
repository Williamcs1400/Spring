package com.william.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.william.hibernate.entity.Course;
import com.william.hibernate.entity.Instructor;
import com.william.hibernate.entity.InstructorDetail;
import com.william.hibernate.entity.Review;
import com.william.hibernate.entity.Student;

public class CreatCoursesAndStudentsDemo {

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
			
			//create a course
			Course tempCourse = new Course("Passe em pressão");
			
			//save the course
			session.save(tempCourse);
			
			//create the Students
			Student tempStudent1 = new Student("Sergio", "Ramos", "sergio@ramos.com");
			Student tempStudent2 = new Student("Thiago", "Silva", "thiago@silva.com");
			
			//add Students to the course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			//save the students
			session.save(tempStudent1);
			session.save(tempStudent2);
			
			//Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Daleeee");
			
		}finally {
			session.close();
			
			factory.close();
		}
	}

}
