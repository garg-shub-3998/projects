
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

@WebServlet(urlPatterns = "/add-cart.cu")
public class AddCartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int quantity = 1;
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String bname = request.getParameter("bname");
		String pid = request.getParameter("pid");
		String customerid = (String) request.getSession().getAttribute("userid");
		String url = "jdbc:mysql://localhost:3306/miniflipkart";
		String user = "root";
		String password = "3998";
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);

			PreparedStatement ps1 = con.prepareStatement("Select id from cart where customerid = ?");
			ps1.setString(1, customerid);
			ResultSet rs1 = ps1.executeQuery();
			rs1.next();
			int cartid = rs1.getInt(1);

			PreparedStatement ps = con
					.prepareStatement("Select quantity,totalprice from cartitems where cartid = ? and productid = ? ");
			ps.setLong(1, cartid);
			ps.setNString(2, pid);
			ResultSet rs = ps.executeQuery();
			boolean st = rs.next();
			if (st) {
				quantity = rs.getInt(1) + 1;
				int totalprice = rs.getInt(2) + Integer.parseInt(price);

				PreparedStatement ps6 = con
						.prepareStatement("update cartitems set quantity = ? where cartid = ? and productid = ?");
				ps6.setLong(1, quantity);
				ps6.setLong(2, cartid);
				ps6.setString(3, pid);
				int rs6 = ps6.executeUpdate();
				PreparedStatement ps7 = con
						.prepareStatement("update cartitems set totalprice = ? where cartid = ? and productid = ?");
				ps7.setLong(1, totalprice);
				ps7.setLong(2, cartid);
				ps7.setString(3, pid);
				int rs7 = ps7.executeUpdate();

			} else {
				PreparedStatement ps2 = con.prepareStatement(
						"insert into cartitems ( cartid , productid , unitprice , quantity , totalprice) values(? , ? , ? , ? , ?)");
				ps2.setLong(1, cartid);
				ps2.setString(2, pid);
				ps2.setString(3, price);
				ps2.setLong(4, quantity);
				ps2.setString(5, price);
				int rs2 = ps2.executeUpdate();

			}

			PreparedStatement ps4 = con.prepareStatement("Select amount,numberofitems from cart where id = ?");
			ps4.setLong(1, cartid);
			ResultSet rs4 = ps4.executeQuery();
			rs4.next();
			int amount = rs4.getInt(1);
			int noi = rs4.getInt(2);

			amount = amount + Integer.parseInt(price);
			if(!st)
			noi++;

			PreparedStatement ps3 = con.prepareStatement("update cart set amount = ? where id = ?");
			ps3.setLong(1, amount);
			ps3.setLong(2, cartid);
			int rs3 = ps3.executeUpdate();

			PreparedStatement ps5 = con.prepareStatement("update cart set numberofitems = ? where id = ?");
			ps5.setLong(1, noi);
			ps5.setLong(2, cartid);
			int rs5 = ps5.executeUpdate();

			request.setAttribute("sucess", "product added susseddfullt");
			response.sendRedirect("/product.cu");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}