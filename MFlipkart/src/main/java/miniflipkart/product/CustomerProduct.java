
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

@WebServlet(urlPatterns = "/product.cu")
public class CustomerProduct extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<ArrayList<String>> products = new ArrayList<ArrayList<String>>();

		String customerid = (String) request.getSession().getAttribute("userid");
		String url = "jdbc:mysql://localhost:3306/miniflipkart";
		String user = "root";
		String password = "3998";
		int cartitems = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = con.prepareStatement(
					"Select p.id,p.price,p.name,b.name from product as p join brand as b on p.brandid = b.id");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ArrayList<String> sub = new ArrayList<String>();
				String name = rs.getString(3);
				sub.add(name);
				String price = Integer.toString(rs.getInt(2));
				sub.add(price);
				sub.add(rs.getString(4));
				String id = Integer.toString(rs.getInt(1));
				sub.add(id);
				products.add(sub);

			}
			PreparedStatement ps1 = con.prepareStatement("Select numberofitems from cart where customerid = ?");
			ps1.setString(1, customerid);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next()) {
				cartitems = rs1.getInt(1);
			}
			if (cartitems > 0) {
				request.setAttribute("cartcount", cartitems);
			}
			String sucess = (String) request.getAttribute("sucess");
			request.setAttribute("sucess", sucess);
			request.setAttribute("products", products);
			request.getRequestDispatcher("/WEB-INF/views/customer-product.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
