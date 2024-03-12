package servlet.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JspOne")
public class JspOne extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String name = req.getParameter("inp1");
		req.setAttribute("Uname", name);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Home.jsp");
		dispatcher.include(req, resp);
	}

}
