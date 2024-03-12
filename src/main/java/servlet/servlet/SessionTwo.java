package servlet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session2")
public class SessionTwo extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session = req.getSession();
		
		String email = (String) session.getAttribute("Uemail");
		String password = (String) session.getAttribute("Upassword");
		
		if(!email.isBlank() && !password.isBlank())
		{
			resp.getWriter().print("LoginSuccessFul");
			req.getRequestDispatcher("SessionsHome.jsp").forward(req, resp);
			
		}
		else
		{
			resp.getWriter().print("LoginFailed");
			req.getRequestDispatcher("SessionsLogin.jsp").forward(req, resp);
		}
	}

}
