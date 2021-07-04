package com.qmui.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegistServlet extends HttpServlet {

	public RegistServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charSet=utf-8");
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("name");
		String password=request.getParameter("password");
		PrintWriter out = response.getWriter();
		try {
		
			Class.forName("com.mysql.jdbc.Driver");
			
			java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/qmui","root","root");
			
			
			String sql="INSERT INTO `user`(username,password)VALUES ('"+username+"','"+password+"')";
			System.out.println(sql);
			
			Statement statement = con.createStatement();  
			int rs = statement.executeUpdate(sql);
			
			if(rs==1){
                System.out.println("×¢²á³É¹¦");
                out.println("1");
				}
            else{
                System.out.println("×¢²áÊ§°Ü");
                out.println("0");
            }
			
			con.close();
			
		} catch (  SQLException | ClassNotFoundException  e) {
			System.out.println("×¢²áÊ§°Ü");
			out.println("0");
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}


	public void init() throws ServletException {
		// Put your code here
	}

	

}