
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

@WebServlet(urlPatterns = "/delete-cart.cu")
public class DeleteCartServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pid = request.getParameter("pid");
		String cid = request.getParameter("cartid");
		String price = request.getParameter("price");
		String quantity = request.getParameter("quantity");
		String url = "jdbc:mysql://localhost:3306/miniflipkart";
		String user = "root";
		String password = "3998";
		int amount = Integer.parseInt(price) * Integer.parseInt(quantity);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement ps1 = con.prepareStatement("Delete from cartitems where cartid = ? and productid = ?");
			ps1.setString(1, cid);
			ps1.setString(2, pid);
			ps1.executeUpdate();
			PreparedStatement ps2 = con.prepareStatement("Select amount,numberofitems from cart where id = ?");
			ps2.setString(1, cid);
			ResultSet rs2 = ps2.executeQuery();
			rs2.next();
			int tamount = rs2.getInt(1);
			int noi = rs2.getInt(2);
			tamount -= amount;
			noi -= Integer.parseInt(quantity);
			PreparedStatement ps3 = con.prepareStatement("update cart set amount = ? where id = ?");
			ps3.setLong(1, tamount);
			ps3.setString(2, cid);
			ps3.executeUpdate();
			PreparedStatement ps4 = con.prepareStatement("update cart set numberofitems = ? where id = ?");
			ps4.setLong(1, noi);
			ps4.setString(2, cid);
			ps4.executeUpdate();
			response.sendRedirect("/cart.cu");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}