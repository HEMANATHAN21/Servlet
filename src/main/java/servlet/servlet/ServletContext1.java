package servlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletContext1 extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		ServletContext context = getServletContext();
		String db = context.getInitParameter("db_name");
		
		PrintWriter pw = res.getWriter();
		pw.print("I am in servlet context 1 DB name is : "+db);
	}
	

}
