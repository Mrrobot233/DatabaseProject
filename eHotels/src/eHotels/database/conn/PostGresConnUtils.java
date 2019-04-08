package eHotels.database.conn;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import eHotels.entities.*;

//In the example, she imported the HotelRoom entity. I might need to do the same.
  
public class PostGresConnUtils {
	
	Connection dataBaseConnection = null;
	PreparedStatement prepStatement = null;
	ResultSet resultSet = null;
	Statement statement = null;
	String sql;
  
	public void getConn(){//This retrieves a connection to my database.
		
		try {
			
			Class.forName("org.postgresql.Driver"); 
							
			dataBaseConnection = DriverManager.getConnection("jdbc:postgresql://web0.site.uottawa.ca:15432/jeriv070",
					"jeriv070", "Godofwar3.");
														
		}catch(Exception e) {
			System.out.print("error catched");
		}
					
	}
	
	public void closeDatabase() {//This closes the connection for the database.
		try {
			if(resultSet != null){
				resultSet.close();
			}
			if(prepStatement!=null){
				prepStatement.close();
			}
			if(statement!=null){
				statement.close();
			}
			if(dataBaseConnection!=null){
				dataBaseConnection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//Method 1
	public String getEmployeePasswordByUsername(String param) {//Might need to edit this in order to fit how data is arranged in my database.
		
		getConn();//You've always got to get the connection first.
		
		String password = "";
		
		try {
			
			prepStatement = dataBaseConnection.prepareStatement("SELECT \"Emp_Password\" FROM employee WHERE \"Emp_Login\"=?");
			
			prepStatement.setString(1, param);
			resultSet = prepStatement.executeQuery();
			
			while(resultSet.next()) {
				
				password = resultSet.getString(1);
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			
			closeDatabase();
		}
		
		return password;
	}
	
	//Method 2. This Works!!!
	public String[] getCustomerInfoByLogin(String customerLogin){//Definitely going to need to change the number of 
		
		getConn();//You've always got to get the connection first.
		
		String[] info = new String[2];//Will need to change the size of this.
		
		try {
			
			prepStatement = dataBaseConnection.prepareStatement("SELECT \"Cus_ID\", \"firstName\", \"Cus_Password\" FROM customer WHERE \"Cus_Login\"=?"); //I might include an except clause in the query to remove some columns.
			
			prepStatement.setString(1, customerLogin);
			resultSet = prepStatement.executeQuery();
			
			while(resultSet.next()) {
				
				info[0] = resultSet.getString(2);//Need to figure out what these indexes do.
				info[1] = resultSet.getString(3);//Need to figure out what these indexes do.
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeDatabase();
		}
		return info;
		
	}
	
	//Method 3
	public boolean insertNewCustomer(int customerID, String firstName, String lastName, String address, String customerLogin, String customerPassword) {//Will need to update this method to fit how data is presented in my database.
		
		getConn();//You've always got to get the connection first.
		
		try {
			
			statement = dataBaseConnection.createStatement();
			sql = "INSERT INTO customer(\"Cus_ID\", \"firstName\", \"lastName\", \"address\", \"Cus_Login\", \"Cus_Password\") VALUES ( '"+customerID+"', '"+firstName+"', '"+lastName+"', '"+address+"', '"+customerLogin+"', '"+customerPassword+"')";
				
			statement.executeUpdate(sql);
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			
			closeDatabase();
		}
		
	}
	
	public boolean insertNewEmployee(int employeeID, String firstName, String lastName, String address, String jobPosition, String employeeLogin, String employeePassword,
			int departmentID, boolean isManager){
		
		getConn();//You've always got to get the connection first.
		
		try {
			
			statement = dataBaseConnection.createStatement();
			sql = "INSERT INTO employee(\"SSN\", \"firstName\", \"lastName\", address, \"Position\", \"Emp_Login\", \"Emp_Password\", \"Dep_ID\", \"isManager\") VALUES ( "+employeeID+", '"+firstName+"', '"+lastName+"', '"+address+"', '"+jobPosition+"', '"+employeeLogin+"', '"+employeePassword+"', "+departmentID+", '"+isManager+"')";
				
			statement.executeUpdate(sql);
			return true;
			
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeDatabase();
		}
		
	}
	
	
	
	//Method 4
	public  ArrayList<HotelRoom> getAllAvailRooms(){
		
		getConn();
		
		ArrayList<HotelRoom> Rooms = new ArrayList<HotelRoom>();
		
		try {
			
			prepStatement = dataBaseConnection.prepareStatement("SELECT * FROM hotelRoom WHERE status='available'" );
			resultSet = prepStatement.executeQuery();
			
			while(resultSet.next()){
				
				int roomNumber = resultSet.getInt("accessKey");
				int amenitiesID = resultSet.getInt("amenities_ID");
				String roomSize = resultSet.getString("roomSize");
				String roomView = resultSet.getString("View_available");
				double roomPrice = resultSet.getDouble("Price");
				//int roomCustomerID = resultSet.getInt("customerID");// Might not need this. In the firstwebproject example, they didn't use it.
				int roomHotelID = resultSet.getInt("hotel_ID");
				String roomStatus = resultSet.getString("status");
				int roomDamageID = resultSet.getInt("damage_ID");
				HotelRoom room = new HotelRoom(roomNumber, amenitiesID, roomSize, roomView, roomPrice, roomHotelID, roomStatus, roomDamageID);
				//This is a room without a customerID.
				Rooms.add(room);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
        	closeDatabase();
        }
					
		return Rooms;
		
	}
	
	//Method 5
	public  ArrayList<HotelRoom> getBookedRooms(String customerID){
		
		getConn();
		
		ArrayList<HotelRoom> Rooms = new ArrayList<HotelRoom>();
		
		try {
			//Might want to rework this preparedStatement.
			prepStatement = dataBaseConnection.prepareStatement("SELECT * FROM hotelRoom WHERE status='booked' and \"Cus_ID\"='"+customerID+"'");
			resultSet = prepStatement.executeQuery();
			
			while(resultSet.next()){
				int roomNumber = resultSet.getInt("accessKey");
				int amenitiesID = resultSet.getInt("amenities_ID");
				String roomSize = resultSet.getString("roomSize");
				String roomView = resultSet.getString("View_available");
				double roomPrice = resultSet.getDouble("Price");
				//int roomCustomerID = resultSet.getInt("customerID");// Might not need this. In the firstwebproject example, they didn't use it.
				int roomHotelID = resultSet.getInt("hotel_ID");
				String roomStatus = resultSet.getString("status");
				int roomDamageID = resultSet.getInt("damage_ID");
				HotelRoom room = new HotelRoom(roomNumber, amenitiesID, roomSize, roomView, roomPrice, roomHotelID, roomStatus, roomDamageID);
				//This is a room without a customerID.
				Rooms.add(room);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDatabase();
        }
					
		return Rooms;
		
	}
	
	//Same as the method above but without the customerID parameter
	public  ArrayList<HotelRoom> getBookedRooms(){
		
		getConn();
		
		ArrayList<HotelRoom> Rooms = new ArrayList<HotelRoom>();
		
		try {
			//Might want to rework this preparedStatement.
			prepStatement = dataBaseConnection.prepareStatement("SELECT * FROM hotelRoom WHERE status='booked'");
			resultSet = prepStatement.executeQuery();
			
			while(resultSet.next()){
				int roomNumber = resultSet.getInt("accessKey");
				int amenitiesID = resultSet.getInt("amenities_ID");
				String roomSize = resultSet.getString("roomSize");
				String roomView = resultSet.getString("View_available");
				double roomPrice = resultSet.getDouble("Price");
				//int roomCustomerID = resultSet.getInt("customerID");// Might not need this. In the firstwebproject example, they didn't use it.
				int roomHotelID = resultSet.getInt("hotel_ID");
				String roomStatus = resultSet.getString("status");
				int roomDamageID = resultSet.getInt("damage_ID");
				HotelRoom room = new HotelRoom(roomNumber, amenitiesID, roomSize, roomView, roomPrice, roomHotelID, roomStatus, roomDamageID);
				//This is a room without a customerID.
				Rooms.add(room);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDatabase();
        }
					
		return Rooms;
		
	}
	
	//Method 12
	public String getCustomerPasswordByUsername(String param) {//Might need to edit this in order to fit how data is arranged in my database.
		
		getConn();//You've always got to get the connection first.
		
		String password = "";
		
		try {
			
			prepStatement = dataBaseConnection.prepareStatement("SELECT \"Cus_Password\" FROM customer WHERE \"Cus_Login\"= ?");
			prepStatement.setString(1, param);
			resultSet = prepStatement.executeQuery();
			
			while(resultSet.next()) {
				
				password = resultSet.getString(1);
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			
			closeDatabase();
		}
		
		return password;
	}
	
	//Method 13
	public String getCustomerFirstNameByUsername(String param) {//Might need to edit this in order to fit how data is arranged in my database.
		
		getConn();//You've always got to get the connection first.
		
		String firstName = "";
		
		try {
			
			prepStatement = dataBaseConnection.prepareStatement("SELECT \"firstName\" FROM customer WHERE \"Cus_Login\"=?");
			
			prepStatement.setString(1, param);
			resultSet = prepStatement.executeQuery();
			
			while(resultSet.next()) {
				
				firstName = resultSet.getString(1);
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			
			closeDatabase();
		}
		
		return firstName;
	}
	
	//Method 14
	public String[] getEmployeeInfoByLogin(String employeeLogin){//Definitely going to need to change the number of 
		
		getConn();//You've always got to get the connection first.
		
		String[] info = new String[2];//Will need to change the size of this.
		
		try {
			
			prepStatement = dataBaseConnection.prepareStatement("SELECT \"SSN\", \"firstName\", \"Emp_Password\" FROM employee WHERE \"Emp_Login\"=?"); //I might include an except clause in the query to remove some columns.
			
			prepStatement.setString(1, employeeLogin);
			resultSet = prepStatement.executeQuery();
			
			while(resultSet.next()) {
				
				info[0] = resultSet.getString(2);//Need to figure out what these indexes do.
				info[1] = resultSet.getString(3);//Need to figure out what these indexes do.
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeDatabase();
		}
		return info;
		
	}
	
	public String bookRoom(String custName, String roomno){
		getConn();
		String Cus_ID="";
		
        try{
        	
        	prepStatement = dataBaseConnection.prepareStatement("select \"Cus_ID\" from customer where \"firstName\"='"+custName+"'");
			resultSet = prepStatement.executeQuery();
			
			while(resultSet.next()){
				Cus_ID = resultSet.getString("Cus_ID");
			}
			
			
        	statement = dataBaseConnection.createStatement();
        	sql = "update hotelroom set \"Cus_ID\"='"+Cus_ID+"', status='booked' where accessKey='"+roomno+"'";
            statement.executeUpdate(sql);
            
            
            return Cus_ID;

        }catch(SQLException e){
            e.printStackTrace();
            return "";	 
        }finally {
        	closeDatabase();
        }
		      
    }
	

	
	
	
	/* Below is a list of methods that I need to implement which correspond to the necessary sql queries.
	 * 1) public String getEmployeePasswordByUsername(String param)
	 * This method gets the password based off of the input username, if it matches on that's in the database.
	 * Uses the PreparedStatement: "select emp_password from ehotels.employee where emp_login=?"
	 * 
	 * 2) public String[] getCustomerInfoByID(String param)
	 * This method gets the Customer's info.
	 * NOTE: In the same code, the table customer only has 3 columns: customer_ssn, customer_name and customer_pwd
	 * Uses the PreparedStatement: "select * from ehotels.customer where customer_id=?"
	 * 
	 * 3) public boolean insertNewCustomer(String[] param)
	 * This method creates a new customer.
	 * 
	 * 
	 * 4) public ArrayList<Room> getAllAvailRooms()
	 * This method gets the list of all available rooms without any queries set.
	 * 
	 * 
	 * 5) public  ArrayList<Room> getbookedRooms(String custSSN)
	 * This method gets the list of all booked rooms.
	 * 
	 * 
	 * 6) public String bookRoom(String custName, String roomno)
	 * This method books a room using the customer's name and the hotel room number
	 * 
	 * 7) public String[] getHotelInfo()
	 * This method gets the information about a hotel. This is to be used on the Hotel Description page. Or I could hardcode it.
	 * 
	 * 
	 * 8) public String[] getRoomInfo(String param)
	 * This should be used to display the room information after the user books a room.
	 * 
	 * 9) public String[] getCustomerName
	 * 
	 * 10) public String[] get HotelInfo
	 * 
	 * 11) public boolean updateNumberOfRoomsAvailable
	 * 
	 * 12) public String 
	 * 
	 */
	
	//I could create methods to delete some entries once I'm done.
	//Also might need to create an method which archives everything.
  
  
}