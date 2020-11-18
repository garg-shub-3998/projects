
package miniflipkart.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login.all")
public class LogInServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String n = request.getParameter("name");
		String p = request.getParameter("password");

		String url = "jdbc:mysql://localhost:3306/miniflipkart";
		String user = "root";
		String password = "3998";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = con.prepareStatement(
					"select usertype,id from user where (username=? or email =? or phonenumber=?) and password=?");
			ps.setString(1, n);
			ps.setString(2, n);
			ps.setString(3, n);
			ps.setString(4, p);
			ResultSet rs = ps.executeQuery();
			boolean st = rs.next();
			if (st) {
				String usertype = rs.getString(1);
				int id = rs.getInt(2);
				String userid = Integer.toString(id);
				if (usertype.equals("admin")) {
					request.getSession().setAttribute("usertype", usertype);
					response.sendRedirect("/brand.ad");
				} else if (usertype.equals("vendor")) {
					request.getSession().setAttribute("usertype", usertype);
					request.getSession().setAttribute("userid", userid);
					response.sendRedirect("/product.ve");
				} else {
					request.getSession().setAttribute("usertype", usertype);
					request.getSession().setAttribute("userid", userid);
					response.sendRedirect("/product.cu");
				}
			} else {
				request.setAttribute("errorMessage", "Invalid Credential!");
				request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
