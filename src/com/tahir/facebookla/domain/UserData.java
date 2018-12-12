package com.tahir.facebookla.domain;

public class UserData {
	
	private int id;
	private String fName;
	private String surname;
	private String emailId;
	private String password;
	private String gender;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "UserData [id=" + id + ", fName=" + fName + ", surname=" + surname + ", emailId=" + emailId
				+ ", password=" + password + ", gender=" + gender + "]";
	}
	

}
