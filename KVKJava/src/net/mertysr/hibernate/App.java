package net.mertysr.hibernate;


import java.util.List;


import net.mertysr.hibernate.dao.UserDao;
import net.mertysr.hibernate.model.Address;
import net.mertysr.hibernate.model.Mobile;
import net.mertysr.hibernate.model.User;
import net.mertysr.hibernate.model.Vehicle;
public class App {
public static void main(String[] args) {
	//User_1
	//Builder Creational
	User usr=new User();
	usr.setUserName("User_1");
	Address adr=new Address("Street","City",usr);
	usr.setAddress(adr);
	Vehicle vhc=new Vehicle("Vehicle");
	usr.getVehicle().add(vhc); //DataCollection using
	vhc.getUser().add(usr);
	Mobile mbl=new Mobile("Brand","Model");
	usr.getMobile().add(mbl);
	mbl.setUser(usr);
	
	//User_2
	User usrr=new User();
	usrr.setUserName("User_2");
	Address adrr=new Address("Street_2","City_2",usrr);
	usrr.setAddress(adrr);
	final Vehicle[] vehicle = new Vehicle[2]; //Bridge Structural
	vehicle[0]=new Vehicle("Vehicle_2");
	vehicle[1] =new Vehicle("Vehicle_2_1");
	//Add mobile..
	for(int i=0;i<vehicle.length;i++) {
		usrr.getVehicle().add(vehicle[i]);
		vehicle[i].getUser().add(usrr);
	}
	
	final Mobile[] mobile = new Mobile[1];
	mobile[0]=new Mobile("Brand","Model");
	//Add mobile..
	for(int i=0;i<mobile.length;i++) {
		usrr.getMobile().add(mobile[i]);
		mobile[i].setUser(usrr);
	}
	Mobile mbll=new Mobile("Brand","Model");
	usrr.getMobile().add(mbll);
	mbll.setUser(usrr);
	
	//save
	UserDao userDao=new UserDao();
	userDao.saveUser(usr);
	userDao.saveUser(usrr);
	
	//update
	usr.setUserName("deneme");
	userDao.updateUser(usr);
	
	//showAllStudent
	List<User> user=userDao.getAllStudents();
	for(int i=0;i<userDao.getAllStudents().size();i++) {
		System.out.println(user.get(i));
	}
	
	//delete
	//userDao.deleteUser(5);
}}

