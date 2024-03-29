package controls;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
import dto.Movie;
@WebServlet("/movieedit")

public class MovieEdit extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		
		Dao dao=new Dao();
		
		try {
			
			HttpSession session =req.getSession();
			String aname=(String) session.getAttribute("adminname");
			
			if(aname!=null) {
				Movie movie=dao.findByMovieId(id);
				req.setAttribute("movie", movie);
				RequestDispatcher r=req.getRequestDispatcher("editmovies.jsp");
				r.include(req, resp);
			}else {
				req.setAttribute("message", "access denied login required");
				RequestDispatcher r=req.getRequestDispatcher("alogin.jsp");
				r.include(req, resp);
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
