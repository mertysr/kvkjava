package net.mertysr.hibernate;



import java.util.Collections;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.*;

import net.bytebuddy.asm.Advice.Return;
import net.mertysr.hibernate.dao.UserDao;
import net.mertysr.hibernate.model.Address;
import net.mertysr.hibernate.model.Mobile;
import net.mertysr.hibernate.model.User;
import net.mertysr.hibernate.model.Vehicle;
import net.mertysr.hibernate.model.Phone.PhoneSelector;
import net.mertysr.hibernate.model.VehicleType.Suv;
import net.mertysr.hibernate.model.VehicleType.Type;
import net.mertysr.hibernate.model.city.Iterator;
import net.mertysr.hibernate.model.city.NameRepository;
public class App {
	final User[] user = new User[2];
	public User[] userNull() {
		return user;
	}
	public static void main (String[] args) {
	    App app = new App();
	    app.doSomething();
	}
	
	public void doSomething() {
		NameRepository namesRepository = new NameRepository(); //Iterator behaivor
		  List < String > cityName = new ArrayList < String > ();
		  for(Iterator iter = namesRepository.getIterator(); iter.hasNext();){
		     cityName.add((String)iter.next());
		}
		  System.out.println(cityName.get(0));
		 
	  //User_1
	  //Builder Creational
	  
	  user[0] = new User();
	  user[0].setUserName("User_1");
	  Address adr = new Address("Street", cityName.get(0)); //Iterator behaivor
	  adr.setUser(user[0]);
	  user[0].setAddress(adr);
	  //Strategy Behaivor
	  final Type vehicletype = new Type( new Suv() );
	  Vehicle vhc = new Vehicle(vehicletype.SelectVehicle());
	  //***********************
	  user[0].getVehicle().add(vhc); 
	  vhc.getUser().add(user[0]);
	  Mobile mbl = new Mobile("Brand", "Model");
	  user[0].getMobile().add(mbl);
	  mbl.setUser(user[0]);

	  //User_2
	  user[1] = new User();
	  user[1].setUserName("User_2");
	  Address adrr = new Address("street", "city");
	  adrr.setUser(user[1]);
	  user[1].setAddress(adrr);
	  final Vehicle[] vehicle = new Vehicle[2]; //Bridge Structural
	  vehicle[0] = new Vehicle("Vehicle_2");
	  vehicle[1] = new Vehicle("Vehicle_2_1");
	  //Add mobile..
	  for (int i = 0; i < vehicle.length; i++) {
	   user[1].getVehicle().add(vehicle[i]);
	   vehicle[i].getUser().add(user[1]);
	  }

	  PhoneSelector pSelector=new PhoneSelector(); //facade structural
	  final Mobile[] mobile = new Mobile[1];
	  mobile[0] = new Mobile(pSelector.selectSamsung() ,"Model");
	  //Add mobile..
	  for (int i = 0; i < mobile.length; i++) {
	   user[1].getMobile().add(mobile[i]);
	   mobile[i].setUser(user[1]);
	  }
	  Mobile mbll = new Mobile("Brand", "Model");
	  user[1].getMobile().add(mbll);
	  mbll.setUser(user[1]);

	  //save
	  UserDao userDao = new UserDao();
	  userDao.saveUser(user[0]);
	  userDao.saveUser(user[1]);

	  //update
	  user[1].setUserName("deneme");
	  userDao.updateUser(user[1]);

	  //UserSearch
	  String searchUserName = "deneme";
	  for (int i = 0; i < user.length; i++) {
	   if (user[i].getUserName().toString() == searchUserName) {
	    System.out.println("user" + i + "=" + searchUserName);
	   }
	  }

	  //UserSorting
	  List < String > userNameList = new ArrayList < String > ();
	  for (int i = 0; i < user.length; i++) {
	   userNameList.add(user[i].getUserName());
	  }
	  Collections.sort(userNameList);
	  for (int i = userNameList.size() - 1; i >= 0; i--) {
	   System.out.println(userNameList.get(i));
	  }

	  //Vehicle Search
	  String searchVehicleName = "Vehicle_2";
	  for (int i = 0; i < vehicle.length; i++) {
	   if (vehicle[i].getName().toString() == searchVehicleName) {
	    System.out.println("Vehicle" + "=" + searchVehicleName);
	   }
	  }

	  //Vehicle Sorting
	  List < String > vehicleNameList = new ArrayList < String > ();
	  for (int i = 0; i < user.length; i++) {
	   vehicleNameList.add(vehicle[i].getName());
	  }
	  Collections.sort(vehicleNameList);
	  for (String str: vehicleNameList) System.out.print(" " + str);

	  //Mobile Search
	  String searchMobileName = "Model";
	  for (int i = 0; i < mobile.length; i++) {
	   if (mobile[i].getModel().toString() == searchMobileName) {
	    System.out.println("Vehicle" + "=" + searchMobileName);
	   }
	  }

	  //Mobile Sorting
	  List < String > mobileNameList = new ArrayList < String > ();
	  for (int i = 0; i < mobile.length; i++) {
	   mobileNameList.add(mobile[i].getModel());
	  }
	  Collections.sort(mobileNameList);
	  for (String str: mobileNameList) System.out.print(" " + str);



	  
	  //delete
	  //userDao.deleteUser(5);
	}
	public int IteratorCount() {
		NameRepository namesRepository = new NameRepository(); //Iterator behaivor
		  List < String > cityName = new ArrayList < String > ();
		  for(Iterator iter = namesRepository.getIterator(); iter.hasNext();){
		     cityName.add((String)iter.next());
		}
		  return cityName.size();
	}
 
 }
