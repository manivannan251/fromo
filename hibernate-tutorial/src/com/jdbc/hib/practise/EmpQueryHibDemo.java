package com.jdbc.hib.practise;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmpQueryHibDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg2.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = sf.getCurrentSession();

		session.beginTransaction();

		List<Employee> employees = session.createQuery("from Employee").getResultList();
		
		employees.forEach(System.out::println);
		
		session.getTransaction().commit();
	}

}
