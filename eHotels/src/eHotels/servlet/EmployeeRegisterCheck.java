package eHotels.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eHotels.database.conn.*;
import eHotels.entities.*;

/**
 * Servlet implementation class EmployeeRegisterCheck
 */
@WebServlet("/EmployeeRegisterCheck")
public class EmployeeRegisterCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeRegisterCheck() {
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
		
		String stringEmployeeID = request.getParameter("employeeID");
		int employeeID = Integer.parseInt(stringEmployeeID);
		String stringDepartmentID = request.getParameter("departmentID");
		int departmentID = Integer.parseInt(stringDepartmentID);
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String jobPosition = request.getParameter("jobPostion");
		String address = request.getParameter("address");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String stringIsManager = request.getParameter("isManager");
		boolean isManager = true;
		
		if(stringIsManager.equals("Yes")) {
			isManager = true;
		} else if(stringIsManager.equals("No")) {
			isManager = false;
		}
		
		PostGresConnUtils connection = new PostGresConnUtils();
		boolean insertSuccess = connection.insertNewEmployee(employeeID, firstName, lastName, address, jobPosition, username, password, departmentID, isManager);
		
		if(insertSuccess) {
			response.sendRedirect("EmployeeLogin.jsp");
			return;
		}
		
		response.sendRedirect("loginFailure.jsp");
		
		
		
	}

}
