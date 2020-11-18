
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

@WebServlet(urlPatterns = "/checkout.cu")
public class CheckoutServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String customerid = (String) request.getSession().getAttribute("userid");
		String url = "jdbc:mysql://localhost:3306/miniflipkart";
		String user = "root";
		String password = "3998";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			
			PreparedStatement ps1 = con.prepareStatement("Select id,amount from cart where customerid = ?");
			ps1.setString(1,customerid);
			ResultSet rs1 = ps1.executeQuery();
			rs1.next();
			int cartid = rs1.getInt(1);
			int amount = rs1.getInt(2);
			
			request.setAttribute("amount",amount);
			request.getRequestDispatcher("WEB-INF/views/checkout.jsp").forward(request,response);
		
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String customerid = (String) request.getSession().getAttribute("userid");
		String url = "jdbc:mysql://localhost:3306/miniflipkart";
		String user = "root";
		String password = "3998";
		String ptype = request.getParameter("ptype");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			
			PreparedStatement ps1 = con.prepareStatement("Select id,amount from cart where customerid = ?");
			ps1.setString(1,customerid);
			ResultSet rs1 = ps1.executeQuery();
			rs1.next();
			int cartid = rs1.getInt(1);
			int amount = rs1.getInt(2);
			
			PreparedStatement ps2 = con.prepareStatement("insert into miniflipkart.order(customerid,amount,paymenttype) values ( ? , ? , ? )");
			ps2.setString(1, customerid);
			ps2.setLong(2, amount);
			ps2.setString(3, ptype);
			int rs2 = ps2.executeUpdate();
			
			PreparedStatement ps = con.prepareStatement("select max(id) from miniflipkart.order where customerid = ?");
			ps.setString(1, customerid);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int orderid = rs.getInt(1);
			
			PreparedStatement ps3 = con.prepareStatement("update cart set amount = 0 , numberofitems = 0 where id = ?");
			ps3.setLong(1, cartid);
			int rs3 = ps3.executeUpdate();
			
			PreparedStatement ps4 = con.prepareStatement("select productid,quantity,unitprice,totalprice from cartitems where cartid = ?");
			ps4.setLong(1,cartid);
			ResultSet rs4 = ps4.executeQuery();
			while(rs4.next()) {
				PreparedStatement ps5 = con.prepareStatement("insert into orderitems(orderid,productid,quantity,unitprice,totalprice) values ( ? , ? , ? , ? , ?)");
				ps5.setLong(1, orderid);
				ps5.setLong(2, rs4.getInt(1));
				ps5.setLong(3, rs4.getInt(2));
				ps5.setLong(4, rs4.getInt(3));
				ps5.setLong(5, rs4.getInt(4));
				int rs5 = ps5.executeUpdate();
				
			}
			
			PreparedStatement ps6 = con.prepareStatement("delete from cartitems where cartid = ?");
			ps6.setLong(1, cartid);
			int rs6 = ps6.executeUpdate();
			
			response.sendRedirect("/product.cu");
		}catch(Exception e ) {
			System.out.println(e);
		}
	}

}
