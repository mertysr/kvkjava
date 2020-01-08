package net.mertysr.hibernate.model.Phone;

public class Samsung implements Phone {
	@Override
	public String select() {
		return "Samsung";
	}
}
