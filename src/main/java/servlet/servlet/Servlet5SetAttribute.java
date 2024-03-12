package servlet.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

public class Servlet5SetAttribute extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String name = req.getParameter("inp1");
		req.setAttribute("inp1", name);
		
		int age = Integer.parseInt(req.getParameter("inp2"));
		req.setAttribute("inp2", age);
		
		String email = req.getParameter("inp3");
		req.setAttribute("inp3", email);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("setGetAttribute2");
		dispatcher.include(req, res);
		
	}

}
