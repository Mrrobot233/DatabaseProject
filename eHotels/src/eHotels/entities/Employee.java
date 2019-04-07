package eHotels.entities;//This corresponds to an Employee relation.

public class Employee {
	
	private int employeeID;
	private String firstName;
	private String lastName;
	private String employeeLogin;
	private String employeePassword;
	private int departmentID; //This will need to be drawn from the Department class.
	private boolean isManager; //This will need to be drawn from the Department class.
	private String jobPostion; //So far I'm not seeing the use of this attribute within the code. Might delete it in the end.
	private String address;
	
	

	public Employee() {//Empty constructor. I can create a constructor that intialises all the values but I feel like it's better to use the setters for that.
		
	}
	
	
	
	public Employee(int employeeID, String firstName, String lastName, String employeeLogin, String employeePassword,
			int departmentID, boolean isManager, String jobPostion, String address) {
		super();
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeLogin = employeeLogin;
		this.employeePassword = employeePassword;
		this.departmentID = departmentID;
		this.isManager = isManager;
		this.jobPostion = jobPostion;
		this.address = address;
	}



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


	public String getJobPostion() {
		return jobPostion;
	}


	public void setJobPostion(String jobPostion) {
		this.jobPostion = jobPostion;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isManager() {
		return isManager;
	}

	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}






}
