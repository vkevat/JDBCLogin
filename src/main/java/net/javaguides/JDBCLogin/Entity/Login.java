package net.javaguides.JDBCLogin.Entity;

import java.sql.Date;

import javax.validation.constraints.NotBlank;

public class Login {

	private int id;
	private String firstName;
	private String lastName;
	private Date dob;
	private String emailID;
	private String password;
	private String new_password;
	
	
	public Login() {
	}
	
	public Login(String emailID, String password) {
		super();
		this.emailID = emailID;
		this.password = password;
	}



	public Login(int id, String firstName, String lastName, Date dob, String emailID, String password,
			String new_password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.emailID = emailID;
		this.password = password;
		this.new_password = new_password;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNew_password() {
		return new_password;
	}

	public void setNew_password(String new_password) {
		this.new_password = new_password;
	}
	
	
}
