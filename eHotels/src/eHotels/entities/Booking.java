package eHotels.entities;

import java.util.Date;

public class Booking {
	
	private int bookingID;
	private int customerID;
	private int hotelRoomNumber;
	private Date startDate;
	private Date endDate;

	public Booking() {
		

	}

	public int getBookingID() {
		return bookingID;
	}

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getHotelRoomNumber() {
		return hotelRoomNumber;
	}

	public void setHotelRoomNumber(int hotelRoomNumber) {
		this.hotelRoomNumber = hotelRoomNumber;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	
}
