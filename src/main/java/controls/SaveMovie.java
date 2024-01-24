package controls;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.Dao;
import dto.Movie;

@WebServlet("/savemovie")
@MultipartConfig(maxFileSize = 10 *1024*1024)

public class SaveMovie extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int movieid=Integer.parseInt(req.getParameter("movieid"));
		String moviename=req.getParameter("moviename");
		Double movieprice=Double.parseDouble(req.getParameter("movieprice"));
		Double movierating =Double.parseDouble(req.getParameter("movierating"));
		String moviegenre =req.getParameter("moviegenre");
		String movielanguage=req.getParameter("movielanguage");
		Part imagepart=req.getPart("movieimage");
		String moviedescription=req.getParameter("moviedescription");
		
		Movie movie=new Movie();
		
		movie.setMovieiid(movieid);
		movie.setMoivename(moviename);
		movie.setMovieprice(movieprice);
		movie.setMovierating(movierating);
		movie.setMoviegenre(moviegenre);
		movie.setMovielanguage(movielanguage);
		movie.setMovieimage(imagepart.getInputStream().readAllBytes());
		movie.setMovieDescription(moviedescription);
		
		
		Dao dao=new Dao();
		try {
			
			HttpSession session=req.getSession(false);
			String aname=(String) session.getAttribute("adminname");
			if(aname!=null) {
			dao.saveMovie(movie);
			req.setAttribute("movies", dao.getallmovies());
			RequestDispatcher r=req.getRequestDispatcher("AHome.jsp");
			r.include(req, resp);
			}else {
				req.setAttribute("message","login required");
				RequestDispatcher r=req.getRequestDispatcher("alogin.jsp");
				r.include(req, resp);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	

}
