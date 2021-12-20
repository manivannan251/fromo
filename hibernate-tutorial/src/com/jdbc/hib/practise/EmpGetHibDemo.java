package com.jdbc.hib.practise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmpGetHibDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sf = new Configuration().configure("hibernate.cfg2.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = sf.getCurrentSession();

		session.beginTransaction();
		
		Employee e1 = session.get(Employee.class, 1);
		
		System.out.println("The value from db is ");
		System.out.println(e1);
		
		session.getTransaction().commit();

	}

}
