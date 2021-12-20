package com.jdbc.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class HibBiDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure()
							.addAnnotatedClass(Instructor.class)
							.addAnnotatedClass(InstructorDetail.class)
							.buildSessionFactory();
		
		Session session = sf.getCurrentSession();	
		
		
		session.beginTransaction();
		
		InstructorDetail id = session.get(InstructorDetail.class, 2);
		
		Instructor ins = id.getInstructor();
		
		System.out.println(ins);
		
		session.getTransaction().commit();

	}

}
