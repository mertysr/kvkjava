package net.mertysr.hibernate.model.Phone;

public class iPhone implements Phone {
	@Override
	public String select() {
		return "iPhone";
	}
}
