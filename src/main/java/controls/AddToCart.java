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
@WebServlet("/addcart")

public class AddToCart extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer mid=Integer.parseInt(req.getParameter("id"));
		HttpSession session=req.getSession();
		User u=(User) session.getAttribute("user");
		int uid=u.getUserid();
		Dao dao=new Dao();
		
		try {
			if(dao.checkUserCart(mid, uid)) {
			if(dao.addToCart(mid, uid)>0) {
				req.setAttribute("cartmessage", "movie is added to the cart");
				RequestDispatcher r=req.getRequestDispatcher("UHome.jsp");
				r.include(req, resp);
				
			}
			}else {
				req.setAttribute("cartmessage", "this movie is already added to the cart");
				RequestDispatcher r=req.getRequestDispatcher("UHome.jsp");
				r.include(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
