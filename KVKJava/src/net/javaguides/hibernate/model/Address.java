package net.javaguides.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Address {
	@Id @GeneratedValue
	private int id;
	private String street;
	private String city;
	@OneToOne(mappedBy="address")
	private User user;
	public Address() {}
	public Address(String street, String city,User user) {
		this.street = street;
		this.city = city;
		this.user = user;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public User getUser() {
		return user;
	}	
	public void setUser(User user) {
		this.user = user;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
