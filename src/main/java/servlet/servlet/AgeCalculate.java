package servlet.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalculateAgeServlet")
public class AgeCalculate extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("inp1");
		int yyyy = Integer.parseInt(req.getParameter("inp4"));
		
		Date d = new Date();
		int year = d.getYear() + 1900;
		
		int age = year - yyyy;
		
		resp.getWriter().println(name+" Your are "+age+" Years old");
	}
}
