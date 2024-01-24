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
@WebServlet("/deletemovie")
public class DeleteMovie extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		Dao dao=new Dao();
		try {
			
			HttpSession session=req.getSession();
			String aname=(String)session.getAttribute("adminname");
			
			if(aname!=null) {
				dao.deleteMovie(id);
				req.setAttribute("movies", dao.getallmovies());
				RequestDispatcher r=req.getRequestDispatcher("AHome.jsp");
				r.include(req, resp);
			}
			else {
				req.setAttribute("message", "access denied,login required");
				RequestDispatcher r=req.getRequestDispatcher("alogin.jsp");
				r.include(req, resp);
			}
			
	
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
