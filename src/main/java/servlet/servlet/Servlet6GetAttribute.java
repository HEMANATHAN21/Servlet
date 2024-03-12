package servlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Servlet6GetAttribute extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String name = (String) req.getAttribute("inp1");
		int age = (int) req.getAttribute("inp2");
		String email = (String) req.getAttribute("inp3");
		
		PrintWriter pw = res.getWriter();
		pw.println(name);
		pw.println(age);
		pw.println(email);
		
	}

}
