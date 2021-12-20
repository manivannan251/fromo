package com.jdbc.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class CreateCourseDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure()
							.addAnnotatedClass(Instructor.class)
							.addAnnotatedClass(InstructorDetail.class)
							.addAnnotatedClass(Course.class)
							.buildSessionFactory();
		
		Session session = sf.getCurrentSession();
		
		
		
		session.beginTransaction();
		
		Instructor ins = session.get(Instructor.class, 1);
		
		Course course1 = new Course("Air Guitar");
		
		Course course2 = new Course("Play Violin");
		
		ins.add(course1);
		ins.add(course2);
		
		session.save(course1);
		session.save(course2);
		
		session.getTransaction().commit();

	}

}
