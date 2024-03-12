package servlet.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServLifeCycle1")
public class ServLifeCycle1 extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("From service phase..");
		String name = req.getParameter("inp1");
		req.setAttribute("name", name);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/ServLifeCycle2");
		dispatcher.include(req, resp);
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("From inti phase..");
	}
	
	@Override
	public void destroy() {
		System.out.println("From destroy phase..");
	}
}
