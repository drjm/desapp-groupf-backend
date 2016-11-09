package model;

import java.util.Date;

public class MusicalEvent extends Event {

	private GenderMusical gender;

	public MusicalEvent(GenderMusical gener, String statTime, String endTime, Date fecha, String descripcion,
			Long price, Boolean alone, Boolean inTwosome, Boolean inGroup) {

		super(statTime, endTime, fecha, descripcion, price, alone, inTwosome, inGroup, null);
		gender = gener;

	}

	public MusicalEvent() {
		super(null, null, null, null, null, null, null, null, null);

	}

	public GenderMusical getGender() {
		return gender;
	}

	public void setGender(GenderMusical gender) {
		this.gender = gender;
	}

	@Override
	public Boolean isCompatible(Profile profile) {

		boolean ret = false;

		for (GenderMusical gm : profile.getMusicalGeneres()) {
			ret = ret || gm.getName().equals(this.getGender().getName());
		}
		return ret;


	}

	@Override
	public Boolean couldBelong(Profile profile) {
		return !profile.getMusicalGeneres().isEmpty();
	}

	@Override
	public void whereAddYou(User user) {
		user.addMusic(this.getGender());
	}

}
