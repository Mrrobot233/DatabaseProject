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
							
			dataBaseConnection = DriverManager.getConnection("jdbc:postgresql://web0.site.uottawa.ca:15432/eajae073",
					"eajae073", "EA_Sports7");
														
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
	
	public String getEmployeePasswordByUsername(String param) {//Might need to edit this in order to fit how data is arranged in my database.
		
		getConn();//You've always got to get the connection first.
		
		String password = "";
		
		try {
			
			prepStatement = dataBaseConnection.prepareStatement("select emp_password from ehotels.employee where emp_login=?");
			
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
	
	public String[] getCustomerInfoByID(String param){//Definitely going to need to change the number of 
		
		getConn();//You've always got to get the connection first.
		
		String[] info = new String[2];//Will need to change the size of this.
		
		try {
			
			prepStatement = dataBaseConnection.prepareStatement("select * from eHotels.customer where customerID=?"); //I might include an except clause in the query to remove some columns.
			
			prepStatement.setString(1, param);
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
	
	public boolean insertNewCustomer(String[] param) {//Will need to update this method to fit how data is presented in my database.
		
		getConn();//You've always got to get the connection first.
		
		try {
			
			statement = dataBaseConnection.createStatement();
			sql = "insert into ehotels.customer values('"+param[0]+"','"+param[1]+"','"+param[2]+"')";//Will need to update this according to the data I've got in the database.
			
			System.out.print(sql);
			
			statement.executeUpdate(sql);
			
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			
			closeDatabase();
		}
		
	}
	
	public  ArrayList<HotelRoom> getAllAvailRooms(){
		
		getConn();
		
		ArrayList<HotelRoom> Rooms = new ArrayList<HotelRoom>();
		
		try {
			
			prepStatement = dataBaseConnection.prepareStatement("select * from ehotels.hotelroom where room_status='T'" );
			resultSet = prepStatement.executeQuery();
			
			while(resultSet.next()){
				
				String room_no = resultSet.getString("room_no");
				String room_status = resultSet.getString("room_status");
				HotelRoom room = new HotelRoom();
				room.setRoomNumber(Integer.parseInt(room_no));//Might need to create a constraint there to prevent non integer values being used.
				Rooms.add(room);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
        	closeDatabase();
        }
					
		return Rooms;
		
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
	 * 
	 */
	
	//I could create methods to delete some entries once I'm done.
	//Also might need to create an method which archives everything.
  
  
}