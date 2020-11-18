
package miniflipkart.cart;

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

@WebServlet(urlPatterns = "/update-cart.cu")
public class UpdateCart extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String value = request.getParameter("value");
		String price = request.getParameter("price");
		String pid = request.getParameter("pid");
		String cartid = request.getParameter("cartid");
		String url = "jdbc:mysql://localhost:3306/miniflipkart";
		String user = "root";
		String password = "3998";
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);

			PreparedStatement ps1 = con
					.prepareStatement("Select quantity,totalprice from cartitems where cartid = ? and productid = ?");
			ps1.setString(1, cartid);
			ps1.setString(2, pid);
			ResultSet rs1 = ps1.executeQuery();
			rs1.next();
			int quantity = rs1.getInt(1);
			int totalprice = rs1.getInt(2);

			int v = Integer.parseInt(value);
			int p = Integer.parseInt(price);
			PreparedStatement ps2 = con.prepareStatement("Select amount from cart where id = ?");
			ps2.setString(1, cartid);
			ResultSet rs2 = ps2.executeQuery();
			rs2.next();
			int tamount = rs2.getInt(1);

			quantity += v;
			if (v < 0) {
				totalprice -= p;
				tamount -= p;
				
			} else {
				totalprice += p;
				tamount += p;
				
			}
			if (quantity > 10) {
				response.sendRedirect("/cart.cu");
			} else if (quantity == 0) {

				PreparedStatement ps5 = con
						.prepareStatement("Delete from cartitems where cartid = ? and productid = ?");
				ps5.setString(1, cartid);
				ps5.setString(2, pid);
				ps5.executeUpdate();
				
				PreparedStatement ps3 = con.prepareStatement("update cart set amount = ? where id = ?");
				ps3.setLong(1, tamount);
				ps3.setString(2, cartid);
				ps3.executeUpdate();
				PreparedStatement ps4 = con.prepareStatement("update cart set numberofitems = ? where id = ?");
				ps4.setLong(1, 0);
				ps4.setString(2, cartid);
				ps4.executeUpdate();

				response.sendRedirect("/cart.cu");

			} else {
				PreparedStatement ps7 = con
						.prepareStatement("update cartitems set totalprice = ? where cartid = ? and productid = ?");
				ps7.setLong(1, totalprice);
				ps7.setString(2, cartid);
				ps7.setString(3, pid);
				ps7.executeUpdate();
				PreparedStatement ps6 = con
						.prepareStatement("update cartitems set quantity = ? where cartid = ? and productid = ?");
				ps6.setLong(1, quantity);
				ps6.setString(2, cartid);
				ps6.setString(3, pid);
				ps6.executeUpdate();
				
				PreparedStatement ps3 = con.prepareStatement("update cart set amount = ? where id = ?");
				ps3.setLong(1, tamount);
				ps3.setString(2, cartid);
				ps3.executeUpdate();
				

				response.sendRedirect("/cart.cu");
			}

			

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}