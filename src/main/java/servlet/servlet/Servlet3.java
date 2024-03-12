package servlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Servlet3 implements Servlet 
{

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String name = req.getParameter("uname");
		String email = req.getParameter("uemail");
		
		PrintWriter pw = res.getWriter();
		pw.println("I am in Servlet 3");
		pw.println("Name Is : "+name);
		pw.println("Email Is : "+email);
		pw.print("----------------------------");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("d2");
		dispatcher.include(req, res);
		//dispatcher.forward(req, res);
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
