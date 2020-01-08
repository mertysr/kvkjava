package net.mertysr.hibernate.model.VehicleType;

public class Excavator implements SelectVehicle{
	@Override
	public String selectVehicle() {
		return "Excavator";
	}
}
