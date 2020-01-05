package net.javaguides.hibernate;
//import java.io.Console;
import org.hibernate.Session;
//import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import net.javaguides.hibernate.dao.UserDao;
//import org.hibernate.cfg.Configuration;
import net.javaguides.hibernate.model.Address;
import net.javaguides.hibernate.model.Mobile;
import net.javaguides.hibernate.model.User;
import net.javaguides.hibernate.model.Vehicle;
import net.javaguides.hibernate.util.HibernateUtil;
public class App {
public static void main(String[] args) {
	//User_1
	User usr=new User();
	usr.setUserName("User_1");
	Address adr=new Address("Street","City",usr);
	usr.setAddress(adr);
	Vehicle vhc=new Vehicle("Vehicle");
	usr.getVehicle().add(vhc);
	vhc.getUser().add(usr);
	Mobile mbl=new Mobile("Brand","Model");
	usr.getMobile().add(mbl);
	mbl.setUser(usr);
	
	//User_2
	User usrr=new User();
	usrr.setUserName("User_2");
	Address adrr=new Address("Street_2","City_2",usr);
	usrr.setAddress(adrr);
	Vehicle vhcc=new Vehicle("Vehicle_2");
	Vehicle vhccc=new Vehicle("Vehicle_2_1");
	usrr.getVehicle().add(vhcc);
	vhcc.getUser().add(usrr);
	usrr.getVehicle().add(vhcc);
	vhccc.getUser().add(usrr);
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
	
	//delete
	//userDao.deleteUser(5);
}}

