package model;

public class Surprise extends Filter {

	@Override
	public Boolean applyFilter(Event e, Object user) {
		User userAux = (User) user;
		return (e.couldBelong(userAux.getProfile()));
	}

	
}
