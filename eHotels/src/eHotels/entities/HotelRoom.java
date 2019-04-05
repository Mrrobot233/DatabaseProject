package eHotels.entities;

public class HotelRoom {
	
	//The availalbe room sizes.
	public static final String SINGLE = "S";
	public static final String DOUBLE = "D";
	public static final String KING = "K";
	public static final String QUEEN = "Q";
	public static final String PRESIDENTIAL = "P";
	
	
	
	private int roomNumber;
	private String amenities; //Might consider turning this to an into an int with corresponding amenities options.
	private String roomSize;//Have 5 options for room sizes and the String corresponds to the roomSize
	private String view; //Might consider turning this to an into an int with corresponding views options.
	private double price;
	private int custID;//The room will be considered empty if the custID = 0; Should be able to get this from the Customer object.
	private int hotelID;//Should be able to get this from the Hotel object.
	private boolean canExtend;//This should be set to true for all rooms except for Single.
	private String status;
	private boolean damaged;//True when something in the room is damaged. False otherwise.
	private String damageDescription; //A short description of the damage to the room.
	
	public HotelRoom(){
		
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getAmenities() {
		return amenities;
	}

	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}

	public String getRoomSize() {
		return roomSize;
	}

	public void setRoomSize(String roomSize) {
		this.roomSize = roomSize;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public int getHotelID() {
		return hotelID;
	}

	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}

	public boolean isCanExtend() {
		return canExtend;
	}

	public void setCanExtend(boolean canExtend) {
		this.canExtend = canExtend;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isDamaged() {
		return damaged;
	}

	public void setDamaged(boolean damaged) {
		this.damaged = damaged;
	}

	public String getDamageDescription() {
		return damageDescription;
	}

	public void setDamageDescription(String damageDescription) {
		this.damageDescription = damageDescription;
	}

	
	

}