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
@WebServlet("/deleteusermovie")

public class DeleteUserMovie extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int mid=Integer.parseInt(req.getParameter("mid"));
		
		HttpSession session=req.getSession();
		
		User u=(User) session.getAttribute("user");
		int uid=u.getUserid();
		Dao dao=new Dao();
		try {
			dao.deleteUserMovie(mid, uid);
			
			RequestDispatcher r=req.getRequestDispatcher("UHome.jsp");
			r.include(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
