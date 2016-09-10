package model;

public class FoodEvent extends Event {

	@Override
	public Boolean isCompatible(Profile profile) {
		return profile.getFoodTastes().contains(profile);
	}

}
