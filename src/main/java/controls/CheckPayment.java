package controls;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Movie;
@WebServlet("/checkpay")

public class CheckPayment extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Movie m=(Movie) req.getAttribute("movie");
		System.out.println(m);
		Double price=Double.valueOf(req.getParameter("Uprice"));
		
		if(price==m.getMovieprice()) {
			req.setAttribute("message", "congrats you have brought the movie ");
			
			RequestDispatcher r=req.getRequestDispatcher("buymovie.jsp");
			r.include(req, resp);
		}
	}

}
