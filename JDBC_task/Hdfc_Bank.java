package JDBC_Task;

import java.sql.*;
public class Hdfc_Bank {
	static final String DB_URL = "jdbc:mysql://localhost:3306/";
	static final String USER = "root";
	static final String PASS = "root";

	public static void main(String args[]){
	try {
		Connection con = DriverManager.getConnection(DB_URL,USER,PASS);
			Statement stmt = con.createStatement();
			{
				String sql = " create database HDFC_Bank";
				
				stmt.executeUpdate(sql);
				System.out.println("Database Created"); 
				
				
			}
	}
			catch(Exception e){
				System.out.println(e);
			}
			
}
}
