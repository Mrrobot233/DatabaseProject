package eHotels.entities;//This corresponds to an Employee relation.

public class Employee {
	
	private int employeeID;
	private String firstName;
	private String lastName;
	private String employeeLogin;
	private String employeePassword;
	private int departmentID; //This will need to be drawn from the Department class.
	private int managerID; //This will need to be drawn from the Department class.
	private String postion; //So far I'm not seeing the use of this attribute within the code. Might delete it in the end.

	
	public int getEmployeeID() {
		return employeeID;
	}


	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmployeeLogin() {
		return employeeLogin;
	}


	public void setEmployeeLogin(String employeeLogin) {
		this.employeeLogin = employeeLogin;
	}


	public String getEmployeePassword() {
		return employeePassword;
	}


	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}


	public int getDepartmentID() {
		return departmentID;
	}


	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}


	public int getManagerID() {
		return managerID;
	}


	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}


	public String getPostion() {
		return postion;
	}


	public void setPostion(String postion) {
		this.postion = postion;
	}


	public Employee() {//Empty constructor. I can create a constructor that intialises all the values but I feel like it's better to use the setters for that.
		
	}



}
