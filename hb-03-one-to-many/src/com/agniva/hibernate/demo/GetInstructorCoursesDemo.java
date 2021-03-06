package com.agniva.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.agniva.hibernate.demo.entity.Course;
import com.agniva.hibernate.demo.entity.Instructor;
import com.agniva.hibernate.demo.entity.InstructorDetail;
import com.agniva.hibernate.demo.entity.Student;

public class GetInstructorCoursesDemo {

	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
	
	
			//start a transaction
			session.beginTransaction();			
			
			//get instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			System.out.println("Instructor: " + tempInstructor);
			
			//get courses for instructor
			System.out.println("Courses: " +tempInstructor.getCourses());
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!");
			
		}
		finally {
			
			//add clean up code
			session.close();
			
			factory.close();
		}
		
	}

}
