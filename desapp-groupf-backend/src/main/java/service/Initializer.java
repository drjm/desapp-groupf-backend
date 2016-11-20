package service;

public class Initializer {

	public Initializer(Initialize... services) {
		for (Initialize o : services) {

			o.initialize();
		}

	}
}
