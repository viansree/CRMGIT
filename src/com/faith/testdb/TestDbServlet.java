package com.faith.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Servlet Implementation class
 * 
 */

@WebServlet("/testdbservlet")
public class TestDbServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//Setup connection variable
		String driverClass="com.mysql.cj.jdbc.Driver";
		String jdbcUrl = "jdbc:mysql://localhost:3306/democrm?serverTimezone=UTC";
		String user="root";
		String password = "faith";

		
		//GEt Connection to database
		try {
			PrintWriter out= resp.getWriter();
			out.println("Connecting to database:"+ jdbcUrl +"\n");
			
			
			//Set Connecion String
			Class.forName(driverClass);
			Connection connection = DriverManager.getConnection(jdbcUrl,user,password);
			out.println("success!!!");
			
			
			//close Connection
			connection.close();
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
			throw new ServletException();
			
		}
		
	}
	
	
	

}