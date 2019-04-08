package eHotels.entities;

public class HotelRoom {
	
	//The availalbe room sizes.
	public static final String SINGLE = "S";
	public static final String DOUBLE = "D";
	public static final String KING = "K";
	public static final String QUEEN = "Q";
	public static final String PRESIDENTIAL = "P";
	
	
	
	private int roomNumber;
	private int amenitiesID; //Might consider turning this to an into an int with corresponding amenities options.
	private String roomSize;//Have 5 options for room sizes and the String corresponds to the roomSize
	private String view; //Might consider turning this to an into an int with corresponding views options.
	private double price;
	private int customerID;//The room will be considered empty if the custID = 0; Should be able to get this from the Customer object.
	private int hotelID;//Should be able to get this from the Hotel object.
	private boolean canExtend;//This should be set to true for all rooms except for Single.
	private String status;
	private int damageID;
	
	public HotelRoom(){
		
	}
	
	public HotelRoom(int roomNumber, int amenitiesID, String roomSize, String view, double price, int custID,
			int hotelID, boolean canExtend, String status, int damageID) {
		super();
		this.roomNumber = roomNumber;
		this.amenitiesID = amenitiesID;
		this.roomSize = roomSize;
		this.view = view;
		this.price = price;
		this.customerID = custID;
		this.hotelID = hotelID;
		this.canExtend = canExtend;
		this.status = status;
		this.damageID = damageID;
	}
	
	//Constructor to create a room without the CustomerID
	public HotelRoom(int roomNumber, int amenitiesID, String roomSize, String view, double price,
			int hotelID, boolean canExtend, String status, int damageID) {
		super();
		this.roomNumber = roomNumber;
		this.amenitiesID = amenitiesID;
		this.roomSize = roomSize;
		this.view = view;
		this.price = price;
		this.hotelID = hotelID;
		this.canExtend = canExtend;
		this.status = status;
		this.damageID = damageID;
	}
	
	//Constructor to create a room without the CustomerID or canExtend
		public HotelRoom(int roomNumber, int amenitiesID, String roomSize, String view, double price,
				int hotelID, String status, int damageID) {
			super();
			this.roomNumber = roomNumber;
			this.amenitiesID = amenitiesID;
			this.roomSize = roomSize;
			this.view = view;
			this.price = price;
			this.hotelID = hotelID;
			this.status = status;
			this.damageID = damageID;
		}



	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getAmenitiesID() {
		return amenitiesID;
	}

	public void setAmenitiesID(int amenitiesID) {
		this.amenitiesID = amenitiesID;
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

	public int getCustomerID() {
		return customerID;
	}

	public void setCustID(int customerID) {
		this.customerID = customerID;
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

	public int getDamageID() {
		return damageID;
	}

	public void setDamageID(int damageID) {
		this.damageID = damageID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}



	
	

}
