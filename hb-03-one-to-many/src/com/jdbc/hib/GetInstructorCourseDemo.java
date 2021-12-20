package com.jdbc.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class GetInstructorCourseDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure()
							.addAnnotatedClass(Instructor.class)
							.addAnnotatedClass(InstructorDetail.class)
							.addAnnotatedClass(Course.class)
							.buildSessionFactory();
		
		Session session = sf.getCurrentSession();
		
		
		
		session.beginTransaction();
		
		Instructor ins = session.get(Instructor.class, 1);
		
		System.out.println("Instructor "+ins);
		
		System.out.println("Courses "+ins.getCourses());
		
		session.getTransaction().commit();

	}

}
