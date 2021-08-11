package JDBC_Task;

import java.sql.*;
import java.util.Scanner;

public class Hdfc_Bank1 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/hdfc_bank", "root", "root");
			Statement stmt = con.createStatement();
			Scanner input = new Scanner(System.in);
			Connect obj1 = new Connect();
			while (true) {

				System.out.println("-------------------------");
				System.out.println(" **Welcome to HDFC Bank**");
				System.out.println(" ------------------------ ");
				System.out.println(" Enter the Option ");
				System.out.println("1. Create Account ");
				System.out.println("2. Display Details ");
				System.out.println("3. Exit");
				int n = input.nextInt();
				switch (n) {
				case 1:
					System.out.println(" Please enter your name : ");
					String name = input.next();
					System.out.println(" Please enter your age : ");
					int age = input.nextInt();
					System.out.println(" ----------------------- ");
					System.out.println();

					// obj1.create(stmt);

					obj1.insert(stmt, name, age);
					break;
				case 2:
					obj1.display(stmt);
					break;
				case 3:
					System.exit(0);
				default:
					System.out.println("please choose valid option");
					break;
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

class Connect {
	String sql;

	void create(Statement stmt) throws SQLException {
		sql = "create table customer_details (Customer_id int auto_increment primary key, Name varchar(50) not null, Age int not null )";
		stmt.executeUpdate(sql);
		System.out.println("table Created .....");
	}

	void insert(Statement stmt, String name, int age) throws SQLException {
		if (age >= 18) {
			sql = "insert into customer_details(Name,Age) values (" + "'"
					+ name + "'" + "," + age + ")";
			System.out.println(sql);
			stmt.executeUpdate(sql);
		} else {
			System.out.println("Not Eligible");
		}
	}

	void display(Statement stmt) throws SQLException {
		sql = "Select * from customer_details";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next())
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " "
					+ rs.getInt(3));

		System.out.println("task completed ....");
	}

}