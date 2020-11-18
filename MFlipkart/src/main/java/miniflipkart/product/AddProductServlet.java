
package miniflipkart.product;

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

@WebServlet(urlPatterns = "/add-product.ve")
public class AddProductServlet extends HttpServlet {

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
			request.setAttribute("brands", brands);
			request.getRequestDispatcher("/WEB-INF/views/add-product.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String product = request.getParameter("product");
		product = product.substring(0, 1).toUpperCase() + product.substring(1).toLowerCase();
		String price = request.getParameter("price");
		String brand = request.getParameter("brand");
		brand = brand.substring(0, 1).toUpperCase() + brand.substring(1).toLowerCase();
		String url = "jdbc:mysql://localhost:3306/miniflipkart";
		String user = "root";
		String password = "3998";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement ps1 = con.prepareStatement("Select id from brand where name = ?");
			ps1.setString(1, brand);
			ResultSet rs1 = ps1.executeQuery();
			rs1.next();
			String bid = rs1.getString(1);
			String vid = (String) request.getSession().getAttribute("userid");
			PreparedStatement ps2 = con.prepareStatement(
					"Select * from product where name = ? and price = ? and brandid = ? and vendorid = ?");
			ps2.setString(1, product);
			ps2.setString(2, price);
			ps2.setString(3, bid);
			ps2.setString(4, vid);
			ResultSet rs2 = ps2.executeQuery();
			boolean st = rs2.next();
			if (st) {
				request.setAttribute("erronMessage", "Already Present");
				request.getRequestDispatcher("/WEB-INF/views/add-product.jsp").forward(request, response);
			} else {
				PreparedStatement ps3 = con
						.prepareStatement("insert into product (name,price,brandid,vendorid) values(? , ? , ? , ?)");
				ps3.setString(1, product);
				ps3.setString(2, price);
				ps3.setString(3, bid);
				ps3.setString(4, vid);
				int nora = ps3.executeUpdate();
				response.sendRedirect("/product.ve");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}