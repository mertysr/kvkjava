package net.mertysr.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Address implements Cloneable {
	@Id @GeneratedValue
	private int id;
	final private String street;
	final private String city;
	@OneToOne(mappedBy="address")
	private User user;
	public Address(final String street,final String city) {
		this.street = street;
		this.city = city;
	}
	public String getStreet() {
		return street;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	protected Address getCopy() {

	    try {
	      return ( Address ) super.clone();//Prototype Creational
	    } catch ( final CloneNotSupportedException e ) {
	      e.printStackTrace();
	      return null;
	    }
	  }
	 @Override
	  public String toString() {
	    return "[street=" + street + ", city=" + city + "]";
	  }
}
