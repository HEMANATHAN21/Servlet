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

@WebServlet("/adddataDB")
public class AddDbServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("inp1"));
		String name = req.getParameter("inp2");
		String email = req.getParameter("inp3");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:///studentdata?user=root&password=solohema");
			String query = "insert into emp values(?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setString(3, email);
			pst.execute();
			resp.getWriter().print("Data added Successfully in database ");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			resp.getWriter().print(e);
		}
	}
}
