package com.FinalProject.Entity;

/*create table userdetails(sno int auto_increment primary key ,firstname varchar(40),
lastname varchar(45),email varchar(45),username varchar(30),password varchar(45),
sq1 varchar(50),sq2 varchar(50),sq3 varchar(50));*/

public class UserDetails {
	
	
	private String firstname;
	private String lastname;
	private String email;
	private String username;
	private String password;
	private String sq1;
	private String sq2;
	private String sq3;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSq1() {
		return sq1;
	}
	public void setSq1(String sq1) {
		this.sq1 = sq1;
	}
	public String getSq2() {
		return sq2;
	}
	public void setSq2(String sq2) {
		this.sq2 = sq2;
	}
	public String getSq3() {
		return sq3;
	}
	public void setSq3(String sq3) {
		this.sq3 = sq3;
	}
	public UserDetails(String firstname, String lastname, String email, String username, String password, String sq1,
			String sq2, String sq3) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.password = password;
		this.sq1 = sq1;
		this.sq2 = sq2;
		this.sq3 = sq3;
	}
	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

