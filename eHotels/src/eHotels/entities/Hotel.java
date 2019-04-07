package eHotels.entities;

import java.util.ArrayList;

public class Hotel {
	
	private int hotelID;
	private String hotelName;
	private int hotelChainID;
	private String address;
	private String email;
	private int phoneNumber;
	private int rating;
	private int numberOfRooms;//This is a fixed value
	private int numberOfRoomsAvailable;//This will need to be updated constantly.
	private int managerID;
	private ArrayList<HotelRoom> rooms = new ArrayList<>();
	
	
	public Hotel() {
		
	}


	public int getHotelID() {
		return hotelID;
	}


	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}



	public int getHotelChainID() {
		return hotelChainID;
	}


	public void setHotelChainID(int hotelChainID) {
		this.hotelChainID = hotelChainID;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public int getNumberOfRooms() {
		return numberOfRooms;
	}


	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}


	public int getNumberOfRoomsAvailable() {
		return numberOfRoomsAvailable;
	}


	public void setNumberOfRoomsAvailable(int numberOfRoomsAvailable) {
		this.numberOfRoomsAvailable = numberOfRoomsAvailable;
	}

	public int getManagerID() {
		return managerID;
	}


	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}


	public ArrayList<HotelRoom> getRooms() {
		return rooms;
	}


	public void setRooms(ArrayList<HotelRoom> rooms) {
		this.rooms = rooms;
	}


	public String getHotelName() {
		return hotelName;
	}


	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}




	

	
	
		

}
