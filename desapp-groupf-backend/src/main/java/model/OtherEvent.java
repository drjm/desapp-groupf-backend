package model;

import java.time.LocalDate;

public class OtherEvent extends Event {

	private OtherLike otherLike;

	public OtherEvent(OtherLike otherLike, String statTime, String endTime, LocalDate fecha, String descripcion, Long price,
			Boolean alone, Boolean inTwosome, Boolean inGroup, Place place) {
		super(statTime, endTime, fecha, descripcion, price, alone, inTwosome, inGroup, null, place);
		this.setOtherLike(otherLike);

	}

	public OtherEvent() {
		super(null, null, null, null, null, null, null, null, null, null);

	}

	@Override
	public Boolean isCompatible(Profile profile) {
		return profile.getOtherLikes().contains(otherLike);
	}

	public OtherLike getOtherLike() {
		return otherLike;
	}

	public void setOtherLike(OtherLike otherLike) {
		this.otherLike = otherLike;
	}

	@Override
	public Boolean couldBelong(Profile profile) {
		return !profile.getOtherLikes().isEmpty();
	}

	@Override
	public void whereAddYou(User user) {
		user.addOther(this.getOtherLike());
	}
}
