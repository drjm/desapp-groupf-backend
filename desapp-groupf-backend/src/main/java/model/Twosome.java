package model;

public class Twosome extends Filter {

	@Override
	public Boolean applyFilter(Event e, Object user) {
		Profile profilelocal = ((User) user).getProfile();
		return  e.isAvaliable() && e.getInTwosome() && e.getPrice() <= profilelocal.getAmuntMax() && e.isCompatible(profilelocal) ;
	}

}
