package miniflipkart.order;

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

/**
 * Servlet implementation class ListOrderServlet
 */

@WebServlet(urlPatterns = "/list-order.cu")
public class ListOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<ArrayList<String>> items = new ArrayList<ArrayList<String>>();

		String orderid = request.getParameter("orderid");
		String url = "jdbc:mysql://localhost:3306/miniflipkart";
		String user = "root";
		String password = "3998";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			

			PreparedStatement ps2 = con
					.prepareStatement("Select p.name,o.unitprice,o.quantity,o.totalprice from" + 
							" product as p join orderitems as o" + 
							" on p.id = o.productid" + 
							" where o.orderid = ?");
			ps2.setString(1, orderid);
			ResultSet rs2 = ps2.executeQuery();
			while (rs2.next()) {
				ArrayList<String> sub = new ArrayList<String>();
				sub.add(rs2.getString(1));
				sub.add(Integer.toString(rs2.getInt(2)));
				sub.add(Integer.toString(rs2.getInt(3)));
				sub.add(Integer.toString(rs2.getInt(4)));
				items.add(sub);

			}
			
			request.setAttribute("items", items);
			request.getRequestDispatcher("/WEB-INF/views/list-order.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
