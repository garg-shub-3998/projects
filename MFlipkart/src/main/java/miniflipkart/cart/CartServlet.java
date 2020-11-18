
package miniflipkart.cart;

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

@WebServlet(urlPatterns = "/cart.cu")
public class CartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<ArrayList<String>> products = new ArrayList<ArrayList<String>>();

		String customerid = (String) request.getSession().getAttribute("userid");
		String url = "jdbc:mysql://localhost:3306/miniflipkart";
		String user = "root";
		String password = "3998";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = con.prepareStatement("Select id from cart where customerid = ?");
			ps.setString(1, customerid);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int cartid = rs.getInt(1);

			PreparedStatement ps2 = con.prepareStatement("Select p.id,p.name,p.price,b.name,c.quantity,c.cartid,c.totalprice from "
					+ "product as p join brand as b " + "on p.brandid = b.id " + "join cartitems as c "
					+ "on p.id = c.productid " + "where c.cartid = ?");
			ps2.setLong(1, cartid);
			ResultSet rs2 = ps2.executeQuery();
			while (rs2.next()) {
				ArrayList<String> sub = new ArrayList<String>();
				String id = Integer.toString(rs2.getInt(1));
				sub.add(id);
				String name = rs2.getString(2);
				sub.add(name);
				String price = Integer.toString(rs2.getInt(3));
				sub.add(price);
				sub.add(rs2.getString(4));
				sub.add(Integer.toString(rs2.getInt(5)));
				sub.add(Integer.toString(rs2.getInt(6)));
				sub.add(Integer.toString(rs2.getInt(7)));
				products.add(sub);

			}
			PreparedStatement ps3 = con.prepareStatement("Select amount from cart where id = ?");
			ps3.setLong(1,cartid);
			ResultSet rs3 = ps3.executeQuery();
			rs3.next();
			int carttotal = rs3.getInt(1);
			request.setAttribute("errorMessage", request.getAttribute("error"));
			request.setAttribute("carttotal", Integer.toString(carttotal));
			request.setAttribute("products", products);
			request.getRequestDispatcher("/WEB-INF/views/cart.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {

	}

}
