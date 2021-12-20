package com.jdbc.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class DeleteCourseDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure()
							.addAnnotatedClass(Instructor.class)
							.addAnnotatedClass(InstructorDetail.class)
							.addAnnotatedClass(Course.class)
							.buildSessionFactory();
		
		Session session = sf.getCurrentSession();
		
		
		
		session.beginTransaction();
		
		Course course = session.get(Course.class, 10);
		
		session.delete(course);
		session.getTransaction().commit();

	}

}
