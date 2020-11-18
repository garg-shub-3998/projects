
package miniflipkart.product;

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

@WebServlet(urlPatterns = "/delete-product.ve")
public class DeleteProductServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String bname = request.getParameter("bname");
		String url = "jdbc:mysql://localhost:3306/miniflipkart";
		String user = "root";
		String password = "3998";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			String vid = (String) request.getSession().getAttribute("userid");
			
			PreparedStatement ps1 = con.prepareStatement("Select id from brand where name = ?");
			ps1.setString(1, bname);
			ResultSet rs1 = ps1.executeQuery();
			rs1.next();
			String bid = rs1.getString(1);
			
			PreparedStatement ps2 = con.prepareStatement("select * from product as p join cartitems as c on p.id = c.productid where p.name = ? and p.vendorid = ? and p.brandid = ?");
			ps2.setString(1, name);
			ps2.setString(2, vid);
			ps2.setString(3, bid);
			ResultSet rs2 = ps2.executeQuery();
			boolean st = rs2.next();
			if(st) {
			response.sendRedirect("/product.ve");
			}else {
				PreparedStatement ps = con.prepareStatement(
						"delete from product where name = ? and price = ? and brandid = ? and vendorid = ?");
				ps.setString(1, name);
				ps.setString(2, price);
				ps.setString(3, bid);
				ps.setString(4, vid);
				int nora = ps.executeUpdate();
				response.sendRedirect("/product.ve");
			}
			
			
			
			
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}