package eHotels.entities;

public class Renting {

	private int rentingID;
	private int customerID;
	private int hotelRoomNumber;
	private int bookingID;
		
	public Renting() {
		
	}

	public int getRentingID() {
		return rentingID;
	}

	public void setRentingID(int rentingID) {
		this.rentingID = rentingID;
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

	public int getBookingID() {
		return bookingID;
	}

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}
	
	
}
