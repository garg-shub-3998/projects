
 
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

@WebServlet(urlPatterns = "/order.cu")
public class OrderServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<ArrayList<String>> orders = new ArrayList<ArrayList<String>>();

		String customerid = (String) request.getSession().getAttribute("userid");
		String url = "jdbc:mysql://localhost:3306/miniflipkart";
		String user = "root";
		String password = "3998";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			

			PreparedStatement ps2 = con.prepareStatement("Select id,amount,paymenttype from miniflipkart.order where customerid = ?" );
			ps2.setString(1, customerid);
			ResultSet rs2 = ps2.executeQuery();
			while (rs2.next()) {
				ArrayList<String> sub = new ArrayList<String>();
				sub.add(Integer.toString(rs2.getInt(1)));
				sub.add(Integer.toString(rs2.getInt(2)));
				sub.add(rs2.getString(3));
				orders.add(sub);

			}
			
			request.setAttribute("orders", orders);
			request.getRequestDispatcher("/WEB-INF/views/order.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {

	}

}
