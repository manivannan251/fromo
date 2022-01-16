package com.jdbc.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.hib.entity.Student;

public class HibDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure()
							.addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = sf.getCurrentSession();	
		
		Student stud = new Student("Killer", "Whale", "abc@com");
		
		session.beginTransaction();
		
		session.save(stud);
		
		session.getTransaction().commit();

	}

}
