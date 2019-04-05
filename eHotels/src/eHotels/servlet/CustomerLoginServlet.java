package eHotels.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotels.database.conn.*;
import eHotels.entities.*;

//Might use that. This was in the SampleWebApp example
//@WebServlet(urlPatterns = { "/customerlogin" })
public class CustomerLoginServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);//firstwebproject. Might consider using SampleWebApp's
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String customerUserName = request.getParameter("customerlogin");
		String customerPassword = request.getParameter("customerpassword");
		
	}
	

}
