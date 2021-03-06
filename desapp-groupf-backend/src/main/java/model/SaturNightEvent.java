package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SaturNightEvent extends Event {

	private List<Event> events;

	public SaturNightEvent(String statTime, String endTime, LocalDate fecha, String descripcion, Long price, Boolean alone,
			Boolean inTwosome, Boolean inGroup, Place place) {
		super("Sabado Toda La noche!", statTime, endTime, fecha, descripcion, price, alone, inTwosome, inGroup, null,
				place);
		this.events = new ArrayList<Event>();
	}

	@Override
	public Boolean isCompatible(Profile profile) {

		Boolean isCompatible = true;

		for (Event e : events) {
			isCompatible = isCompatible && e.isCompatible(profile);
		}

		return isCompatible;
	}

	@Override
	public Boolean couldBelong(Profile profile) {

		Boolean couldBelong = true;

		for (Event e : events) {
			couldBelong = couldBelong && e.couldBelong(profile);
		}

		return couldBelong;

	}

	@Override
	public void whereAddYou(User user) {
		for (Event event : events) {
			event.whereAddYou(user);
		}
	}

}
