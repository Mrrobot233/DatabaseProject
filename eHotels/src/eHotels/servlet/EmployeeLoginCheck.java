package eHotels.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotels.database.conn.PostGresConnUtils;
import eHotels.entities.HotelRoom;

/**
 * Servlet implementation class EmployeeLoginCheck
 */
@WebServlet("/EmployeeLoginCheck")
public class EmployeeLoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeLoginCheck() {
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
		
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		PostGresConnUtils connection = new PostGresConnUtils();
		//[0]: Username, [1]: Password.
		String[] info = connection.getEmployeeInfoByLogin(username);
		if(password.equals(info[1])) {
			 
			ArrayList<HotelRoom> allAvailableRooms = connection.getAllAvailRooms();
			ArrayList<HotelRoom> allBookedRooms = connection.getBookedRooms(username);
			
			request.setAttribute("customerFirstName", info[0] );
			request.setAttribute("allAvailableRooms", allAvailableRooms);
			request.setAttribute("allBookedRooms", allBookedRooms);
			
			request.getRequestDispatcher("CreateRentingPage.jsp").forward(request, response);
			return;
		}
		 response.sendRedirect("loginFailure.jsp");
		 return;
	}

}
