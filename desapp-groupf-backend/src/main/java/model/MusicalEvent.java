package model;

public class MusicalEvent extends Event {

	private String gender;
	
	@Override
	public Boolean isCompatible(Profile profile) {
		// TODO Auto-generated method stub
		return profile.getMoviegeneres().contains(gender);
	}

}
