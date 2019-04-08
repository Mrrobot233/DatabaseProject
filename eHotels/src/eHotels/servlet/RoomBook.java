package eHotels.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eHotels.database.conn.*;
import eHotels.entities.*;

/**
 * Servlet implementation class RoomBook
 */
@WebServlet("/RoomBook")
public class RoomBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomBook() {
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
		
		String custName = request.getParameter("custName");
		String roomno = request.getParameter("roomno");
		
		
		PostGresConnUtils connection = new PostGresConnUtils();
		
		String userSSN = connection.bookRoom(custName,roomno);
		
//		[0]:name,[1]:pwd
//		String[] pwdfromdb = con.getuserinforbycustSSN(userSSN);
//		
//		
//		
		if (userSSN.length()!=0) {			
			
			ArrayList<HotelRoom> bookedRooms = connection.getBookedRooms(userSSN);
			
			ArrayList<HotelRoom> allRooms = connection.getAllAvailRooms();
			
			
			request.setAttribute("CustName", custName);
			request.setAttribute("bookedRooms", bookedRooms);
			request.setAttribute("allRooms", allRooms);

			request.getRequestDispatcher("bookingPage.jsp").forward(request, response);
			return;	
		}
		response.sendRedirect("loginFailure.jsp");
		return;
	}
}