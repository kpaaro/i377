package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbaccess.Dao;
import dbaccess.SetupDao;

/**
 * Servlet implementation class Admin
 */
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("do") != null){
			String method = request.getParameter("do");
			
			if(method.equals("clear_data")){
				clear();
			} else if(method.equals("insert_data")){
				insert();
			}
			
			response.sendRedirect("Search");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	private void clear(){
		try {
			new Dao().deleteAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void insert(){
		new SetupDao().addTestData();
	}

}