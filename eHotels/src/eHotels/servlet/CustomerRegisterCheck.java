package eHotels.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eHotels.database.conn.PostGresConnUtils;

/**
 * Servlet implementation class CustomerRegisterCheck
 */
@WebServlet("/CustomerRegisterCheck")
public class CustomerRegisterCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerRegisterCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String stringCustomerID = request.getParameter("customerID");
		int customerID = Integer.parseInt(stringCustomerID);
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String address = request.getParameter("address");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		
		PostGresConnUtils connection = new PostGresConnUtils();
		boolean insertSuccess = connection.insertNewCustomer(customerID, firstName, lastName, address, username, password);
		
		if(insertSuccess) {
			response.sendRedirect("CustomerLogin.jsp");
			return;
		}
		
		response.sendRedirect("loginFailure.jsp");
		
		
	}

}
