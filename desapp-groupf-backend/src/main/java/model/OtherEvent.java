package model;

import java.util.Date;

public class OtherEvent extends Event {

	private String otherLike; 
	
	public OtherEvent(String otherLike, String statTime, String endTime, Date fecha, String descripcion, Long price, Boolean alone,
			Boolean inTwosome, Boolean inGroup) {
		super(statTime, endTime, fecha, descripcion, price, alone, inTwosome, inGroup);
		this.setOtherLike(otherLike);
		
	}
	@Override
	public Boolean isCompatible(Profile profile) {
		return profile.getOtherLikes().contains(otherLike);
	}
	public String getOtherLike() {
		return otherLike;
	}
	public void setOtherLike(String otherLike) {
		this.otherLike = otherLike;
	}

	@Override
	public Boolean couldBelong(Profile profile) {
		return ! profile.getOtherLikes().isEmpty();
	}
	
	@Override
	public void whereAddYou(User user) {
		user.addOther(this.getOtherLike());
	}
}
