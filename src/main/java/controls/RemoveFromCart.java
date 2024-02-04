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
import dto.User;
@WebServlet("/removemovie")

public class RemoveFromCart extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int mid = Integer.valueOf(req.getParameter("id"));
		HttpSession session=req.getSession();
		User u=(User) session.getAttribute("user");
		Dao dao=new Dao();
		
		try {
			dao.removeFromCart(mid, u.getUserid());
			
			req.setAttribute("cartmovies", dao.getUserCartMovies(u.getUserid()));
			RequestDispatcher r=req.getRequestDispatcher("cart.jsp");
			r.include(req, resp);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
