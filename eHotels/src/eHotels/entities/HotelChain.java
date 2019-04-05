package eHotels.entities;

import java.util.ArrayList;

public class HotelChain {

	private int hotelChainID;
	private String name;
	private String address; //Might break this down into Street, Zip Code etc. Might actually delete it all together.
	private int numberOfHotels;
	private int centralOfficeID;
	private String email;
	private int phoneNumber;
	private ArrayList<Hotel> hotels = new ArrayList<>();//Might need to use this. Might not.
	
	public HotelChain() {
		
	}

	public int getHotelChainID() {
		return hotelChainID;
	}

	public void setHotelChainID(int hotelChainID) {
		this.hotelChainID = hotelChainID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNumberOfHotels() {
		return numberOfHotels;
	}

	public void setberNumOfHotels(int numberOfHotels) {
		this.numberOfHotels = numberOfHotels;
	}

	public int getCentralOfficeID() {
		return centralOfficeID;
	}

	public void setCentralOfficeID(int centralOfficeID) {
		this.centralOfficeID = centralOfficeID;
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
	
	
	
	
}
