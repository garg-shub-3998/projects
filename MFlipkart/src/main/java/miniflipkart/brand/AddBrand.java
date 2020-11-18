
package miniflipkart.brand;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/add-brand.ad")
public class AddBrand extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/add-brand.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String newbrand = request.getParameter("newbrand");
		newbrand = newbrand.substring(0, 1).toUpperCase() + newbrand.substring(1).toLowerCase();
		String url = "jdbc:mysql://localhost:3306/miniflipkart";
		String user = "root";
		String password = "3998";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement ps1 = con.prepareStatement("Select name from brand where name = ?");
			ps1.setString(1, newbrand);
			ResultSet rs = ps1.executeQuery();
			Boolean st = rs.next();
			if (st) {
				request.setAttribute("errorMessage", "Already present");
				request.getRequestDispatcher("/WEB-INF/views/add-brand.jsp").forward(request, response);
			}
			PreparedStatement ps = con.prepareStatement("insert into brand (name) values(?)");

			ps.setString(1, newbrand);
			int nora = ps.executeUpdate();
			response.sendRedirect("/brand.ad");
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}