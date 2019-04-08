<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book an Available Room</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

 <!-- Navigation bar -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <div class="container">
      <a class="navbar-brand js-scroll-trigger" href="index.html">eHotels</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="explorehotels.html">Explore Hotels</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

 <div id="booking" class="section" style="margin-left: 35%; margin-right: 35%; padding-top: 100px">
		<div class="section-center">
			<div class="container">
				<div class="row">
					<div class="booking-form">
						<form id="bookPage" class="form" action="RoomBook"
							method="post">
							
                            <div class="form-group">
								<span class="form-label">Hotel Chain</span>
								<select class="form-control" required>
									<option value="" selected hidden>Select Hotel Chain</option>
									<option>Radisson Blu</option>
									<option>The Marriot</option>
                                    <option>The Holiday Inn</option>
                                    <option>Four Points</option>
                                    <option>Hyatt Hotels</option>
								</select>
								<span class="select-arrow"></span>
							</div>
                            
                            <div class="form-group">
								<span class="form-label">Hotel Name</span>
								<select class="form-control" required>
									<option value="" selected hidden>Select room type</option>
									<option>Radisson Blu Denver</option>
									<option>The Marriot Pittsburgh</option>
                                    <option>The Holiday Inn New York</option>
                                    <option>Four Points Los Angeles</option>
                                    <option>Hyatt Houston</option>
								</select>
								<span class="select-arrow"></span>
							</div>
                            
                            <div class="row no-margin">
								<div class="col-sm-6">
									<div class="form-group">
										<span class="form-label">Check In</span>
										<input class="form-control" type="date" required>
									</div>
								</div>
								<div class="col-sm-6">
									<div class="form-group">
										<span class="form-label">Check Out</span>
										<input class="form-control" type="date" required>
									</div>
								</div>
							</div>
							
							<div class="form-group">
								<span class="form-label">Room Type</span>
								<select class="form-control" required>
									<option value="" selected hidden>Select room type</option>
									<option>Single</option>
									<option>Double</option>
                                    <option>Queen</option>
                                    <option>King</option>
                                    <option>Presidential</option>
								</select>
								<span class="select-arrow"></span>
							</div>
                            
                            <div class="form-group">
								<span class="form-label">View</span>
								<select class="form-control" required>
									<option value="" selected hidden>Select a view</option>
									<option>Any</option>
									<option>Pool side</option>
                                    <option>City skyline</option>
                                    <option>Beach</option>
                                    <option>Street</option>
								</select>
								<span class="select-arrow"></span>
							</div>
                            
                            <div class="form-group">
								<span class="form-label">Amenities</span>
								<select class="form-control" required>
									<option value="" selected hidden>Select your desired amenities</option>
									<option>TV and Free Room Service</option>
									<option>TV and Fridge</option>
                                    <option>TV, Fridge, Free Room Service, Open Bar</option>
								</select>
								<span class="select-arrow"></span>
							</div>
                            
							<div class="form-group">
								<span class="form-label">Minimum Price</span>
								<input class="form-control" type="email" placeholder="Enter a minimum price">
							</div>
							<div class="form-group">
								<span class="form-label">Maximum Price</span>
								<input class="form-control" type="tel" placeholder="Enter a maximum price">
							</div>
                            <div class="form-group">
								<span class="form-label">Can Extend</span>
								<input class="form-control" type="tel" placeholder="Should the room have space for another bed?">
							</div>
							<div class="form-group">
								<button class="submit-btn">Search</button>
							</div>
                           
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

<!--This is the Bootstrap jQuery file-->
	<script src="bootstrap/js/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script src="bootstrap/js/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>

	<!--This is the Bootstrap JavaScript file-->
	<script src="bootstrap/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>