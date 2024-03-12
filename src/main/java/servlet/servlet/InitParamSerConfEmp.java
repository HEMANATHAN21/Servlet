package servlet.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class InitParamSerConfEmp extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		ServletConfig config = getServletConfig();
		String emp = config.getInitParameter("emp_name");
		res.getWriter().print("emp Name Is : "+emp);
		
	}
	

}
