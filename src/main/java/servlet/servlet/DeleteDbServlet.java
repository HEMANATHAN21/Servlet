package servlet.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deletedatabd")
public class DeleteDbServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("inp1");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:///studentdata?user=root&password=solohema");
			String query = "delete from emp where name = ?";
			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, name);
	
			pst.execute();
			resp.getWriter().print("Data Deleted Successfully in database ");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			resp.getWriter().print(e);
		}
	}
}
