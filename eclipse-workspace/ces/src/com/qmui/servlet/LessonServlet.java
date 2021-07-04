package com.qmui.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.qmui.model.lesson;
import com.qmui.util.GsonUtil;

public class LessonServlet extends HttpServlet {

	public LessonServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			ArrayList<lesson> list = new ArrayList<lesson>();
			try {
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/qmui","root","root");
				Statement statement = con.createStatement();  
				ResultSet rs = statement.executeQuery("select * from lesson");
				while (rs.next()){
					lesson temp = new lesson();
					temp.setId(rs.getInt(1));
					temp.setLesson(rs.getString(2));
					temp.setTittle(rs.getString(3));
					temp.setUrl(rs.getString(4));
					list.add(temp);}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		String jsonString = GsonUtil.getGson().toJson(list);
		response.setContentType("text/html");
		System.out.println("*(****");
		PrintWriter out = response.getWriter();
		out.println(jsonString);
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void init() throws ServletException {
		// Put your code here
	}

}