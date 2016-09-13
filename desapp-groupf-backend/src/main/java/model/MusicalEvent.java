package model;

import java.util.Date;

public class MusicalEvent extends Event {

	private String gender;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public MusicalEvent(String gener,String statTime, String endTime, Date fecha, String descripcion, Long price, Boolean alone, Boolean inTwosome, Boolean inGroup) {

		super(statTime,  endTime, fecha, descripcion,  price, alone,inTwosome,inGroup);
		gender = gener;

	}

	@Override
	public Boolean isCompatible(Profile profile) {

		return profile.getMoviegeneres().contains(gender);
	}

	@Override
	public Boolean couldBelong(Profile profile) {
		return ! profile.getMusicalGeneres().isEmpty();
	}
	
	@Override
	public void whereAddYou(User user) {
		user.addMusic(this.getGender());
	}
	
}
