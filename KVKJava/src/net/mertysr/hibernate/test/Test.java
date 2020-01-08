package net.mertysr.hibernate.test;



import net.bytebuddy.asm.Advice.Origin;
import net.mertysr.hibernate.dao.UserDao;
import net.mertysr.hibernate.model.Address;
import net.mertysr.hibernate.model.Mobile;
import net.mertysr.hibernate.model.User;
import net.mertysr.hibernate.model.Vehicle;


public class Test {
	User usr=new User();
	UserDao userDao=new UserDao();
	@org.junit.jupiter.api.Test
	public void saveTest()
	{ 
		usr.setUserName("User_1");
		Address adr=new Address("Street","City");
		adr.setUser(usr);
		usr.setAddress(adr);
		Vehicle vhc=new Vehicle("Vehicle");
		usr.getVehicle().add(vhc); 
		vhc.getUser().add(usr);
		Mobile mbl=new Mobile("Brand","Model");
		usr.getMobile().add(mbl);
		mbl.setUser(usr);
		userDao.saveUser(usr);
	}
	@org.junit.jupiter.api.Test
	public void updateTest() {
		usr.setUserName("Updated..");
		userDao.updateUser(usr);
	}
	@org.junit.jupiter.api.Test
	public void deleteTest() {
		userDao.deleteUser(5);
	}
}
