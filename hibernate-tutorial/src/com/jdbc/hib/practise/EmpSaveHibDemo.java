package com.jdbc.hib.practise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmpSaveHibDemo {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg2.xml")
								.addAnnotatedClass(Employee.class).buildSessionFactory();
		
		Session session = sf.getCurrentSession();
		
		session.beginTransaction();
		
		Employee emp1 = new Employee("Dw", "Johnson", "Red Notice");
		Employee emp2 = new Employee("Ryan", "Reynolds", "Red Notice");
		Employee emp3 = new Employee("Gal", "Gadot", "Red Notice");
		
		session.save(emp1);
		session.save(emp2);
		session.save(emp3);
		
		session.getTransaction().commit();

	}

}
