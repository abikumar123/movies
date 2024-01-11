package controls;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.Dao;
import dto.Movie;
@WebServlet("/editmovie")
public class EditMovie extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer movieid=Integer.parseInt(req.getParameter("id"));
		Dao dao=new Dao();
		
		try {
			Movie movie=dao.findByMovieId(movieid);
			
			req.setAttribute("movie", movie);
			RequestDispatcher r=req.getRequestDispatcher("editmovie.jsp");
			
			r.include(req, resp);
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
