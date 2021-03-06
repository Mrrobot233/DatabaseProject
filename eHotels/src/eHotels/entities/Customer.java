package eHotels.entities;

public class Customer {

	private int customerID;
	private String firstName;
	private String lastName;
	private String customerLogin;
	private String customerPassword;
	private String address;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCustomerLogin(String customerLogin) {
		this.customerLogin = customerLogin;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public Customer(){
		
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
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

	public String getCustomerLogin() {
		return customerLogin;
	}

	public void setCustLogin(String customerLogin) {
		this.customerLogin = customerLogin;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	
	

}
