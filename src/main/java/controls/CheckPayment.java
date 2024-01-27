package controls;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
import dto.User;

@WebServlet("/checkpay")

public class CheckPayment extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		Movie m = (Movie) session.getAttribute("movie");
		User u =  (User) session.getAttribute("user");

		Double price = Double.valueOf(req.getParameter("Uprice"));
		
		Dao dao=new Dao();

		if (price == m.getMovieprice()) {
			
			try {
				Connection conn=dao.getConnection();
				PreparedStatement p=conn.prepareStatement("insert into buymovie values(?,?)");
				p.setInt(1, m.getMovieid());
				p.setInt(2, u.getUserid());
				p.executeUpdate();
				conn.close();
				
				req.setAttribute("message", "congrats you have brought the movie ");
				RequestDispatcher r = req.getRequestDispatcher("usermovies.jsp");
				r.include(req, resp);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			req.setAttribute("message", " price is mismatch,try again");

			RequestDispatcher r = req.getRequestDispatcher("buymovie.jsp");
			r.include(req, resp);
		}
	}

}
