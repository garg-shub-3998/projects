
package miniflipkart.signup;

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

@WebServlet(urlPatterns = "/signup.all")
public class SignUpServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			// -----------------------------------------------------------------------------------------------------------//
			String url = "jdbc:mysql://localhost:3306/miniflipkart";
			String u = "root";
			String p = "3998";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, u, p);
			// -----------------------------------------------------------------------------------------------------------//

			String usertype = request.getParameter("usertype");
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String age = request.getParameter("age");
			String gender = request.getParameter("gender");
			String password = request.getParameter("password");
			String housenumber = request.getParameter("housenumber");
			String locality = request.getParameter("locality");
			String state = request.getParameter("state");
			String country = request.getParameter("country");
			String pincode = request.getParameter("pincode");
			String username = request.getParameter("username");
			String email = request.getParameter("email");

			String phonenumber = request.getParameter("phonenumber");

			request.setAttribute("username", username);
			request.setAttribute("firstname", firstname);
			request.setAttribute("lastname", lastname);
			request.setAttribute("age", age);
			request.setAttribute("gender", gender);
			request.setAttribute("housenumber", housenumber);
			request.setAttribute("locality", locality);
			request.setAttribute("state", state);
			request.setAttribute("country", country);
			request.setAttribute("pincode", pincode);
			request.setAttribute("email", email);
			request.setAttribute("phonenumber", phonenumber);
			request.setAttribute("usertype", usertype);
			email = email.toLowerCase();
			// --------------checking for duplicacy
			// -------------------------------------------------------------------//

			PreparedStatement ps2 = con.prepareStatement("select username from user where username = ?");
			ps2.setString(1, username);
			ResultSet rs2 = ps2.executeQuery();
			boolean st2 = rs2.next();
			if (st2) {
				request.setAttribute("usernameMessage", "Username already in use!!  Select different Username");
				request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
			}

			PreparedStatement ps1 = con.prepareStatement("select email from user where email = ?");
			ps1.setString(1, email);
			ResultSet rs1 = ps1.executeQuery();
			boolean st1 = rs1.next();
			if (st1) {
				request.setAttribute("emailMessage", "Email already in use!!  Select different Email");
				request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
			}

			PreparedStatement ps3 = con.prepareStatement("select phonenumber from user where phonenumber = ?");
			ps3.setString(1, phonenumber);
			ResultSet rs3 = ps3.executeQuery();
			boolean st3 = rs3.next();
			if (st3) {
				request.setAttribute("phonenumberMessage",
						"Phone Number already in use!!  Select different Phone Number");
				request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
			}

			// ----------------adding user and address to database
			// -----------------------------------------------//

			PreparedStatement ps4 = con.prepareStatement(
					"insert into user (username,email,phonenumber,firstname,lastname,age,gender,password,usertype) "
							+ "values ( ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			ps4.setString(1, username);
			ps4.setString(2, email);
			ps4.setString(3, phonenumber);
			ps4.setString(4, firstname);
			ps4.setString(5, lastname);
			ps4.setString(6, age);
			ps4.setString(7, gender);
			ps4.setString(8, password);
			ps4.setString(9, usertype);
			int rs4 = ps4.executeUpdate();

			PreparedStatement ps7 = con.prepareStatement("select id from user where username = ?");
			ps7.setString(1, username);
			ResultSet rs7 = ps7.executeQuery();
			rs7.next();

			int userid = rs7.getInt(1);
			int addressid;

			if (usertype.equals("customer")) {
				PreparedStatement ps10 = con.prepareStatement("insert into cart(customerid) values ( ? )");
				ps10.setLong(1, userid);
				ps10.executeUpdate();
			}

			PreparedStatement ps5 = con.prepareStatement(
					"select id from address where housenumber = ? and locality = ? and state = ? and country = ? and pincode = ?");
			ps5.setString(1, housenumber);
			ps5.setString(2, locality);
			ps5.setString(3, state);
			ps5.setString(4, country);
			ps5.setString(5, pincode);
			ResultSet rs5 = ps5.executeQuery();
			boolean st = rs5.next();
			if (st) {
				addressid = rs5.getInt(1);
			} else {
				PreparedStatement ps6 = con
						.prepareStatement("insert into address (housenumber,locality,state,country,pincode) "
								+ "values ( ? , ? , ? , ? , ? )");
				ps6.setString(1, housenumber);
				ps6.setString(2, locality);
				ps6.setString(3, state);
				ps6.setString(4, country);
				ps6.setString(5, pincode);
				int rs6 = ps6.executeUpdate();
				PreparedStatement ps8 = con.prepareStatement(
						"select id from address where housenumber = ? and locality = ? and state = ? and country = ? and pincode = ?");
				ps8.setString(1, housenumber);
				ps8.setString(2, locality);
				ps8.setString(3, state);
				ps8.setString(4, country);
				ps8.setString(5, pincode);
				ResultSet rs8 = ps8.executeQuery();
				rs8.next();
				addressid = rs8.getInt(1);
			}

			if (usertype.equals("vendor")) {
				PreparedStatement ps9 = con
						.prepareStatement("insert into vendoraddress (vendorid,addressid) values ( ? , ?)");
				ps9.setInt(1, userid);
				ps9.setInt(2, addressid);
				int rs9 = ps9.executeUpdate();
			} else {
				PreparedStatement ps9 = con
						.prepareStatement("insert into customeraddress (customerid,addressid) values ( ? , ?)");
				ps9.setInt(1, userid);
				ps9.setInt(2, addressid);
				int rs9 = ps9.executeUpdate();
			}
			request.setAttribute("Message", "Sign Up Successfull");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
