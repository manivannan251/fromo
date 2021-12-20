package com.jdbc.hib;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdBc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/hb_student_tracker";
		String user = "root";
		String pass = "1234";
		
		try {
			System.out.println("Connecting to database");
			Connection con = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection successful");
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
