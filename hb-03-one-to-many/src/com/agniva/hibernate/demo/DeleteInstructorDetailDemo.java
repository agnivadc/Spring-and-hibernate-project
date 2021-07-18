package com.agniva.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.agniva.hibernate.demo.entity.Instructor;
import com.agniva.hibernate.demo.entity.InstructorDetail;
import com.agniva.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
	
			//start a transaction
			session.beginTransaction();			
			
			//get the instructor detail object
			int theId = 4;
			
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			//print the instructor detail
			System.out.println("InstructorDetail: " + tempInstructorDetail);
			
			//print the associated instructor
			System.out.println("Instructor: " + tempInstructorDetail.getInstructor());
			
			//now let's delete the instructor detail
			System.out.println("Deletion tempInstructorDetail:" + tempInstructorDetail);
			
			//remove the associated object reference
			//break bi-directional link
			
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			
			session.delete(tempInstructorDetail);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//handle connection leak issue
			session.close();
			
			factory.close();
		}
		
	}

}
