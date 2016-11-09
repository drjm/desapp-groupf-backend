package model;

import java.util.Date;

public class FoodEvent extends Event {

	private TypeFood typeFood;

	public FoodEvent(TypeFood type, String statTime, String endTime, Date fecha, String descripcion, Long price,
			Boolean alone, Boolean inTwosome, Boolean inGroup) {

		super(statTime, endTime, fecha, descripcion, price, alone, inTwosome, inGroup, null);

		typeFood = type;
	}

	public FoodEvent() {
		super(null, null, null, null, null, null, null, null, null);
	}

	public TypeFood getTypeFood() {
		return typeFood;
	}

	public void setTypeFood(TypeFood typeFood) {
		this.typeFood = typeFood;
	}

	@Override
	public Boolean isCompatible(Profile profile) {

		boolean ret = false;

		for (TypeFood tf : profile.getFoodTastes()) {
			ret = ret || tf.getName().equals(this.getTypeFood().getName());
		}
		return ret;
	}

	@Override
	public Boolean couldBelong(Profile profile) {
		return !profile.getFoodTastes().isEmpty();
	}

	@Override
	public void whereAddYou(User user) {
		user.addFood(this.getTypeFood());
	}

}
