package Databse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Insertdemo {

	public static void main(String[] args) throws Exception {

	        // Database URL, username, and password
	        String jdbcURL = "jdbc:mysql://localhost:3306/STORE"; // Replace with your DB URL
	        String username = "root"; // Replace with your username
	        String password = "password"; // Replace with your password

	        // SQL INSERT query
	        String sql = "INSERT INTO employee (empcode, empname, empage, esalary) VALUES (?, ?, ?, ?)";

	        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
	             PreparedStatement statement = connection.prepareStatement(sql)) {

	            // Insert data
	            Object[][] employees = {
	                {101, "Jenny", 25, 10000},
	                {102, "Jacky", 30, 20000},
	                {103, "Joe", 20, 40000},
	                {104, "John", 40, 80000},
	                {105, "Shameer", 25, 90000}
	            };

	            for (Object[] emp : employees) {
	                statement.setInt(1, (int) emp[0]); // empcode
	                statement.setString(2, (String) emp[1]); // empname
	                statement.setInt(3, (int) emp[2]); // empage
	                statement.setInt(4, (int) emp[3]); // esalary
	                statement.executeUpdate();
	            }

	            System.out.println("Data inserted successfully!");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
		System.out.println("sucess");
	}

}
