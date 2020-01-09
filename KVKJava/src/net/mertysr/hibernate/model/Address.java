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
	

	public void setUser(User user) {
		this.user = user;
	}
	protected Address getCopy() {

	    try {
	      return ( Address ) super.clone();//Prototype Creational
	    } catch ( final CloneNotSupportedException e ) {
	      e.printStackTrace();
	      return null;
	    }
	  }
}
