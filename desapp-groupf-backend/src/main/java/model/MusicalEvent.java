package model;

import java.time.LocalDate;

public class MusicalEvent extends Event {

	private GenderMusical genderMusical;
	public MusicalEvent(GenderMusical gener, String statTime, String endTime, LocalDate fecha, String descripcion,
			Long price, Boolean alone, Boolean inTwosome, Boolean inGroup, Place place) {

		super(statTime, endTime, null, descripcion, price, alone, inTwosome, inGroup, null, place);
		this.genderMusical = gener;

	}

	public MusicalEvent() {
		super(null, null, null, null, null, null, null, null, null,null);

	}

	public GenderMusical getGender() {
		return genderMusical;
	}

	public void setGender(GenderMusical gender) {
		this.genderMusical = gender;
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
