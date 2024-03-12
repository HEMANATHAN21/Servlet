package servlet.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletContext2 extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		ServletContext context = getServletContext();
		String db = context.getInitParameter("db_name");
		
		res.getWriter().print("I am in Servlet Context 2 DB name is : "+db);
	}
	

}
