
package miniflipkart.brand;

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

@WebServlet(urlPatterns = "/delete-brand.ad")
public class DeleteBrand extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String brand = request.getParameter("brand");
		brand = brand.substring(0, 1).toUpperCase() + brand.substring(1).toLowerCase();
		String url = "jdbc:mysql://localhost:3306/miniflipkart";
		String user = "root";
		String password = "3998";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement ps1 = con.prepareStatement("select * from product as p join brand as b on b.id = p.brandid where b.name = ?");
			ps1.setString(1, brand);
			ResultSet rs1 = ps1.executeQuery();
			boolean st = rs1.next();
			if(st) {
//			response.sendError(1, "Cannot delete it its products are available");
			response.sendRedirect("/brand.ad");
			}else {
				PreparedStatement ps = con.prepareStatement("delete from brand where name = ?");
				ps.setString(1, brand);
				int nora = ps.executeUpdate();
				response.sendRedirect("/brand.ad");	
			}
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}