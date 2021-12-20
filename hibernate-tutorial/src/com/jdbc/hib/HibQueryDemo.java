package com.jdbc.hib;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.hib.entity.Student;

public class HibQueryDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = sf.getCurrentSession();

		session.beginTransaction();

		//List<Student> students = session.createQuery("from Student").getResultList();
		
		//List<Student> students = session.createQuery("from Student where lastName='mi'").getResultList();
		
		List<Student> students = session.createQuery("from Student where lastName='mi' OR firstName='pc'").getResultList();

		students.forEach(System.out::println);
		
		session.getTransaction().commit();
		
		


	}

}
