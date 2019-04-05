package eHotels.entities;

public class Manager {
	
	private int managerID;
	private String firstName;
	private String lastName;
	private String managerLogin;
	private String managerPassword;
	private int departmentID; //This will need to be drawn from the Department class.
	
	public Manager() {
		
	}

	public int getManagerID() {
		return managerID;
	}

	public void setManagerID(int managerID) {
		this.managerID = managerID;
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

	public String getManagerLogin() {
		return managerLogin;
	}

	public void setManagerLogin(String managerLogin) {
		this.managerLogin = managerLogin;
	}

	public String getManagerPassword() {
		return managerPassword;
	}

	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}

	public int getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	
	

}
