package test;

import java.sql.*;

public class FirstExercise {

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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
