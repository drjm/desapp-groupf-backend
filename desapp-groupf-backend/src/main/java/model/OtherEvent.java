package model;

public class OtherEvent extends Event {

	private String type;
	@Override
	public Boolean isCompatible(Profile profile) {
		return profile.getOtherLikes().contains(type);
	}

}
