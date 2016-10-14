package com.whatsupdoc.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name="Doctor")
public class Doctor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "doctorID", unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int doctorID;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	@Column(name="mobileNumber")
	private String mobileNumber;
	@Column(name="phoneNumber")
	private String phoneNumber;
	@Column(name="gender")
	private String gender;
	@Column(name="qualification")
	private String qualification;
	@Column(name="imageLocationURL")
	private String imageLocationURL;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "addressID")
	private Address address;
	
	public Doctor(){
		
	}
	
	public Doctor(Doctor doctor){
		this.doctorID = doctor.doctorID;
		this.name = doctor.name;
		this.email = doctor.email;
		this.mobileNumber = doctor.mobileNumber;
		this.phoneNumber = doctor.phoneNumber;
		this.qualification = doctor.qualification;
		this.imageLocationURL = doctor.imageLocationURL;
		this.address = doctor.address;
	}

	public int getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getImageLocationURL() {
		return imageLocationURL;
	}

	public void setImageLocationURL(String imageLocationURL) {
		this.imageLocationURL = imageLocationURL;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	

}
