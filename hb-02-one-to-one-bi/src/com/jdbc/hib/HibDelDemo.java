package com.jdbc.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class HibDelDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure()
							.addAnnotatedClass(Instructor.class)
							.addAnnotatedClass(InstructorDetail.class)
							.buildSessionFactory();
		
		Session session = sf.getCurrentSession();
		
		session.beginTransaction();
		
		
		
		Instructor ins = session.get(Instructor.class, 1);
		
		
		
		
		// This will also delete instructor detail
		session.delete(ins);
		
		session.getTransaction().commit();

	}

}
