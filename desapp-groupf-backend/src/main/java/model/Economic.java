package model;

public class Economic extends Filter {

	@Override
	public Boolean applyFilter(Event e, Object user) {
		return e.getPrice() <= ((User)user).getProfile().getAmuntMax();
	}

}
