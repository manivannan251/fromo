package com.jdbc.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.hib.entity.Student;

public class TestPrimarKeyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = sf.getCurrentSession();

		Student stud1 = new Student("pc", "mk", "pcmk@com");
		Student stud2 = new Student("John", "Fox", "joe@com");
		Student stud3 = new Student("li", "mi", "lim@com");

		session.beginTransaction();

		session.save(stud1);
		session.save(stud2);
		session.save(stud3);

		session.getTransaction().commit();
		
		session = sf.getCurrentSession();
		//get a student details
		session.beginTransaction();
		
		Student retrievedStud = session.get(Student.class, stud1.getId());
		
		System.out.println(retrievedStud);
		
		session.getTransaction().commit();

	}

}
