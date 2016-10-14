package com.whatsupdoc.pojo;


import java.awt.geom.Point2D;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;

import org.hibernate.annotations.Type;
import org.springframework.stereotype.Component;

import com.vividsolutions.jts.geom.Geometry;

@Component
@Entity
@Table(name="Address")
public class Address implements Serializable{
	/* a separate class for address to hold the street, city, state and zip information.
	 * Adding Latitude and longitude as attributed so that it can be  */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "addressID", unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int addressID;
	@Column(name="addressLine1")
	private String addressLine1;
	@Column(name="addressLine2")
	private String addressLine2;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	@Column(name="zipCode")
	private String zipCode;
	@Column(name="latitude")
	private double latitude;
	@Column(name="longitude")
	private double longitude;
	
	
	public Address(){
		
	}
	
	public Address(Address address){
		this.addressID = address.addressID;
		this.addressLine1 = address.addressLine1;
		this.addressLine2 = address.addressLine2;
		this.city = address.city;
		this.state = address.state;
		this.zipCode = address.zipCode;
	}
	
	
	public int getAddressID() {
		return addressID;
	}

	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}

	public String getAddressLine1() {
		return addressLine1;
	}
	
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


}
