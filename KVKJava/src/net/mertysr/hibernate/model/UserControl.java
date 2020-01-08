package net.mertysr.hibernate.model;

public class UserControl {
	private static UserControl   usercontrol   = new UserControl();
	private UserControl() {
	      
	   }
	public static UserControl nesneAl() {
	      return usercontrol;
	   }
	public int maxNameLenght() {
	      return 15;
	   }

}
