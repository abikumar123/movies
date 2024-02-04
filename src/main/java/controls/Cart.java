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

@WebServlet("/MovieCart")

public class Cart extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 HttpSession session=req.getSession();
		 User u=(User) session.getAttribute("user");
		 Dao dao=new Dao();
		 
		 
		 try {
			req.setAttribute("cartmovies", dao.getUserCartMovies(u.getUserid()));
			RequestDispatcher r=req.getRequestDispatcher("cart.jsp");
			r.include(req, resp);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		 
		 
	}

}
