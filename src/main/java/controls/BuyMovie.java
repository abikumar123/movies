package controls;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dto.Movie;

@WebServlet("/buymovie")

public class BuyMovie extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		Dao dao = new Dao();

		try {
			Movie m = dao.findByMovieId(id);
			req.setAttribute("price", m.getMovieprice());
			req.setAttribute("movie", m);
			RequestDispatcher r = req.getRequestDispatcher("buymovie.jsp");
			r.include(req, resp);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

}
