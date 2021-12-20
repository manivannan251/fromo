package com.jdbc.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.hib.entity.Student;

public class HibUpdateQueryDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = sf.getCurrentSession();

		session.beginTransaction();
		
		Student student = session.get(Student.class, 1);
		
		session.delete(student);
		
		session.createQuery("delete from Student where id=2").executeUpdate();

		session.getTransaction().commit();
	}

}
