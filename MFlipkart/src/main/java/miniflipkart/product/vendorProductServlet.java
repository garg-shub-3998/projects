
package miniflipkart.product;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/product.ve")
public class vendorProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<ArrayList<String>> products = new ArrayList<ArrayList<String>>();

		String vendorid = (String) request.getSession().getAttribute("userid");
		String url = "jdbc:mysql://localhost:3306/miniflipkart";
		String user = "root";
		String password = "3998";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = con.prepareStatement(
					"Select p.name,price,b.name from product as p join brand as b on p.brandid = b.id where p.vendorid = ?");
			ps.setString(1, vendorid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ArrayList<String> sub = new ArrayList<String>();
				sub.add(rs.getString(1));
				String price = Integer.toString(rs.getInt(2));
				sub.add(price);
				sub.add(rs.getString(3));
				products.add(sub);
			}
			request.setAttribute("products", products);
			request.getRequestDispatcher("/WEB-INF/views/vendor-product.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
