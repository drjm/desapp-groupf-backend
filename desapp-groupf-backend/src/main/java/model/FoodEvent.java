package model;

import java.util.Date;

public class FoodEvent extends Event {

	private String typeFood;
	
	public FoodEvent(String type,String statTime, String endTime, Date fecha, String descripcion, Long price, Boolean alone, Boolean inTwosome, Boolean inGroup) {

		super(statTime,  endTime, fecha, descripcion,  price, alone,inTwosome,inGroup);	

		typeFood = type;
	}

	@Override
	public Boolean isCompatible(Profile profile) {
		return profile.getFoodTastes().contains(typeFood);
	}

	public String getTypeFood() {
		return typeFood;
	}

	public void setTypeFood(String typeFood) {
		this.typeFood = typeFood;
	}

	@Override
	public Boolean couldBelong(Profile profile) {
		return ! profile.getFoodTastes().isEmpty();
	}
}
