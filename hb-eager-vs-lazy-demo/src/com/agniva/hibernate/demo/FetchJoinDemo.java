package com.agniva.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.agniva.hibernate.demo.entity.Course;
import com.agniva.hibernate.demo.entity.Instructor;
import com.agniva.hibernate.demo.entity.InstructorDetail;
import com.agniva.hibernate.demo.entity.Student;

public class FetchJoinDemo {

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
			
			Query<Instructor> query = 
					session.createQuery("Select i from Instructor i "
							+ "JOIN FETCH i.courses "
							+ "where i.id=:theInstructorId", Instructor.class);
					
			//set parameter on query
			query.setParameter("theInstructorId", theId);
			
			//execute query and get instructor
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println("agniva: Instructor: " + tempInstructor);
				
			//commit transaction
			session.getTransaction().commit();
			
			//close the session
			session.close();
			
			//get courses for instructor
			System.out.println("agniva: Courses: " +tempInstructor.getCourses());

			
			System.out.println("agniva: Done!!");
			
		}
		finally {
			
			//add clean up code
			session.close();
			
			factory.close();
		}
		
	}

}
