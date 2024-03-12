package servlet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie2")
public class CookieTwo extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		Cookie[] cookies = req.getCookies();
		
		String email = null;
		String password = null;
		
		if(cookies.length > 0)
		{
			for (Cookie c : cookies) 
			{
				if(c.getValue().equals("hema@gmail.com"))
					email = c.getValue();
				else if(c.getValue().equals("12345"))
					password = c.getValue();
			}
		}
		else
			resp.getWriter().print("Cookies length is null..");
		
		if(email != null && password != null)
		{
			resp.getWriter().print("Login Successfull..");
		}
		else
			resp.getWriter().print("Login Failed");
		
	}

}
