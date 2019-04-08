
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="eHotels.entities.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book a Room</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<%
		String customerFirstName = (String) request.getAttribute("customerFirstName");
	%>
	
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
	<div class="container">
		<a class="navbar-brand js-scroll-trigger" href="index.html">eHotels</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="explorehotels.html">Explore Hotels</a></li>
			</ul>
		</div>
	</div>
	</nav>
	
		<div style="padding-top: 100px;">
		<div class="container">
			<div id="login-row"
				class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
					<div id="login-box" class="col-md-12">
						<form id="booking-form" class="form" action="RoomBook"
							method="post">
							<h3 class="text-center text-info"> Welcome, <%= customerFirstName%></h3>
							
				<h4 class="text-center text-info">Here are the room(s) you booked</h4>
				<ul>
					<%
						Object obj1 = request.getAttribute("allBookedRooms");
						ArrayList<HotelRoom> roomList = null;
						if (obj1 instanceof ArrayList) {
							roomList = (ArrayList<HotelRoom>) obj1;
						}
						if (roomList != null) {
							for (HotelRoom room : roomList) {
								String roominfo = room.getRoomNumber() + "---" + room.getStatus();
					%>
					<li><%=roominfo%></li>
					<%
						}
						}
					%>
				</ul>
				<input type="hidden" name="customerFirstName" value="<%=customerFirstName%>" />
				<h4>Here are avaiable rooms</h4>

				<select name = "roomno">
					<%
						Object obj = request.getAttribute("allAvailableRooms");
						ArrayList<HotelRoom> roomList2 = null;
						if (obj instanceof ArrayList) {
							roomList2 = (ArrayList<HotelRoom>) obj;
						}
						if (roomList2 != null) {
							for (HotelRoom room : roomList2) {
								/* String roominfo = room.getRoom_no() + "---" + room.getRoom_status(); */
					%>					
						<option><%=room.getRoomNumber()%></option>

					<%
						}
						}
					%>
				</select>
				<button type="submit" onclick="return confirm('book?');">book</button>


						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

    <!--This is the Bootstrap jQuery file-->
<script src="bootstrap/js/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="bootstrap/js/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
   
<!--This is the Bootstrap JavaScript file-->
<script src="bootstrap/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>