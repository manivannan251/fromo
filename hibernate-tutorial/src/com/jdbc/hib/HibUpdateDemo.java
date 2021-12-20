package com.jdbc.hib;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.hib.entity.Student;

public class HibUpdateDemo {
	
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = sf.getCurrentSession();

		session.beginTransaction();

		Student student = session.get(Student.class, 1);

		student.setFirstName("Lilomol");
		
		student.setLastName("Jose");
		
		session.getTransaction().commit();
		
		


	}

}
