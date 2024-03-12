package servlet.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie1")
public class CookieOne extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String email = req.getParameter("inp1");
		String password = req.getParameter("inp2");
		
		Cookie c1 = new Cookie("u_email", email);
		Cookie c2 = new Cookie("u_password", password);
		
		resp.addCookie(c1);
		resp.addCookie(c2);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cookie2");
		dispatcher.include(req, resp);
	}

}
