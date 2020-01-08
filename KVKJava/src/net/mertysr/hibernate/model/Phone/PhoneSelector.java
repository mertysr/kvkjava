package net.mertysr.hibernate.model.Phone;

import net.mertysr.hibernate.model.Phone.iPhone;

public class PhoneSelector {
	private Phone samsung;
	   private Phone iphone;
	 
	   public PhoneSelector() {
	      samsung = new Samsung();
	      iphone = new iPhone(); //facade
	   }
	 
	   public String selectSamsung(){
		   samsung.select();
		   return samsung.select().toString();
	   }
	   public String selectIphone(){
	      iphone.select();
	      return iphone.toString();
	   }
	}

