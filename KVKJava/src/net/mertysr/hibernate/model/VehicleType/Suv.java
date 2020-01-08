package net.mertysr.hibernate.model.VehicleType;

public class Suv implements SelectVehicle{
	@Override
	public String selectVehicle() {
		return "SUV";
	}
}
