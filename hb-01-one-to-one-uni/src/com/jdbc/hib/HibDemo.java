package com.jdbc.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class HibDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure()
							.addAnnotatedClass(Instructor.class)
							.addAnnotatedClass(InstructorDetail.class)
							.buildSessionFactory();
		
		Session session = sf.getCurrentSession();
		
		InstructorDetail id = new InstructorDetail("yt/cd", "codeHibDemo.java");
		
		Instructor ins = new Instructor("chad", "db", "cd@abc.com");
		
		ins.setInstructorDetail(id);
		
		session.beginTransaction();
		
		session.save(ins);
		
		session.getTransaction().commit();

	}

}
