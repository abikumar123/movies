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

@WebServlet("/buymovie")

public class BuyMovie extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Dao dao = new Dao();
		int id = Integer.parseInt(req.getParameter("id"));

		HttpSession s = req.getSession();
		try {
			Movie m = dao.findByMovieId(id);
			s.setAttribute("movie", m);
		
			RequestDispatcher r = req.getRequestDispatcher("buymovie.jsp");
			r.include(req, resp);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
