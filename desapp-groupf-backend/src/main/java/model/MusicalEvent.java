package model;

public class MusicalEvent extends Event {

	private String gender;

	public MusicalEvent(String gener) {

		gender = gener;

	}

	@Override
	public Boolean isCompatible(Profile profile) {

		return profile.getMoviegeneres().contains(gender);
	}

}
