package com.rentaride.Registerlogin.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "formRequest")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "Full Name")
	private String fullname;

	@Column(name = "Phone number")
	private String phonenumber;

	@Column(name = "Address")
	private String address;

	@Column(name = "DLnumber")
	private String dLnumber;

	@Column(name = "TotalDays")
	private String totalDays;

	

	public User(long id, String fullname, String phonenumber, String address, String dLnumber, String totalDays) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.phonenumber = phonenumber;
		this.address = address;
		this.dLnumber = dLnumber;
		this.totalDays = totalDays;
	}


	public User() {

	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public String getPhonenumber() {
		return phonenumber;
	}


	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getDLnumber() {
		return dLnumber;
	}


	public void setDLnumber(String dLnumber) {
		this.dLnumber = dLnumber;
	}


	public String getTotalDays() {
		return totalDays;
	}


	public void setTotalDays(String totalDays) {
		this.totalDays = totalDays;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", fullname=" + fullname + ", phonenumber=" + phonenumber + ", address=" + address
				+ ", DLnumber=" + dLnumber + ", TotalDays=" + totalDays + "]";
	}
	
	

	
}
