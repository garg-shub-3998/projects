
package miniflipkart.brand;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/brand.ad")
public class ListBrand extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "jdbc:mysql://localhost:3306/miniflipkart";
		String user = "root";
		String password = "3998";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = con.prepareStatement("select name from brand");
			ResultSet rs = ps.executeQuery();
			List<String> brands = new ArrayList<String>();
			while (rs.next()) {
				brands.add(rs.getString(1));
			}
//			response.
			request.setAttribute("brands", brands);
			request.getRequestDispatcher("/WEB-INF/views/brand.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
