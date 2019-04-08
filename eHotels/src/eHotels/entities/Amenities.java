package eHotels.entities;

public class Amenities {
	
	private int amenitesID;
	private boolean tV;
	private boolean airConditioning;
	private boolean fridge;
	private boolean roomService;
	
	
	
	public Amenities() {
		
	}
	
	public int getAmenitesID() {
		return amenitesID;
	}
	public void setAmenitesID(int amenitesID) {
		this.amenitesID = amenitesID;
	}
	public boolean istV() {
		return tV;
	}
	public void settV(boolean tV) {
		this.tV = tV;
	}
	public boolean isAirConditioning() {
		return airConditioning;
	}
	public void setAirConditioning(boolean airConditioning) {
		this.airConditioning = airConditioning;
	}
	public boolean isFridge() {
		return fridge;
	}
	public void setFridge(boolean fridge) {
		this.fridge = fridge;
	}
	public boolean isRoomService() {
		return roomService;
	}
	public void setRoomService(boolean roomService) {
		this.roomService = roomService;
	}
	
	

}
