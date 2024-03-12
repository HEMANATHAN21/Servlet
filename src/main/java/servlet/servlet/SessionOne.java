package servlet.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session1")
public class SessionOne extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String email = req.getParameter("inp1");
		String password = req.getParameter("inp2");
		
		HttpSession session = req.getSession();
		session.setAttribute("Uemail", email);
		session.setAttribute("Upassword", password);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/session2");
		dispatcher.include(req, resp);
	}

}
