package net.mertysr.hibernate.model.VehicleType;

public class Sedan implements SelectVehicle{
	@Override
	public String selectVehicle() {
		return "Sedan";
	}
}
