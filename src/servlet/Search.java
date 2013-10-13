package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbaccess.Dao;

public class Search extends HttpServlet {
   private static final long serialVersionUID = 1L;

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	   if(isDelete(request)){
		   
		   delete(request);  
       }
	   setSearchResults(request);
      request.getRequestDispatcher("WEB-INF/jsp/search.jsp").forward(request, response);
   }


   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String searchString = request.getParameter("searchString");
      response.sendRedirect("Search?searchString="+searchString);
   }

   private void setSearchResults(HttpServletRequest request) {

      String searchString = request.getParameter("searchString");
      Dao dao = new Dao();

      try {
         if(searchString == null || searchString.equals("")) {
            request.setAttribute("searchResults", dao.findAll());
         }
         else {
            request.setAttribute("searchResults", dao.search(searchString));
         }
      } catch(SQLException e) {
         throw new RuntimeException(e);
      } 
   }
   private void delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
	 
	      try {
		new Dao().deleteItem(id);
	} catch (SQLException e) {
			e.printStackTrace();
	}
	}

	private boolean isDelete(HttpServletRequest request) {
		return request.getParameter("do") != null 
					&& request.getParameter("id") != null
					&& request.getParameter("do").equals("delete");
	}

}