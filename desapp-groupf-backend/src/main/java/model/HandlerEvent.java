package model;

import java.util.Date;
import java.util.List;

public class HandlerEvent {

	private List<Event> events;
	private List<Event> pendingEvents;

	public List<Event> getPendingEvents() {
		return pendingEvents;
	}

	public void setPendingEvents(List<Event> pendingEvents) {
		this.pendingEvents = pendingEvents;
	}

	private List<Filter> filters;

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public List<Filter> getFilters() {
		return filters;
	}

	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}

	public void addPendingEvent(Event event) {
		this.getPendingEvents().add(event);
	}

	public void acceptEvent(Event event) {
		this.getPendingEvents().remove(event);
		this.getEvents().add(event);

	}

	public MusicalEvent createEventMusic(User user, Date date, String startTime, Long price, String endTime,
			String description, Boolean alone, Boolean inTwosome, Boolean inGroup, String gener) {

		MusicalEvent musical = new MusicalEvent(gener, startTime, endTime, date, description, price, alone, inTwosome,
				inGroup);

		events.add(musical);

		return musical;

	}

	public MovieEvent createEventMovie(User user, Date date, String startTime, Long price, String endTime,
			String description, Boolean alone, Boolean inTwosome, Boolean inGroup, String gener) {

		MovieEvent movieEvent = new MovieEvent(gener, startTime, endTime, date, description, price, alone, inTwosome,
				inGroup);

		events.add(movieEvent);

		return movieEvent;

	}

	public FoodEvent createEventFood(User user, Date date, String startTime, Long price, String endTime,
			String description, Boolean alone, Boolean inTwosome, Boolean inGroup, String gener) {

		FoodEvent foodEvent = new FoodEvent(gener, startTime, endTime, date, description, price, alone, inTwosome,
				inGroup);

		events.add(foodEvent);

		return foodEvent;

	}

	public OtherEvent createEventOther(User user, Date date, String startTime, Long price, String endTime,
			String description, Boolean alone, Boolean inTwosome, Boolean inGroup, String gener) {

		OtherEvent otherEvent = new OtherEvent(gener, startTime, endTime, date, description, price, alone, inTwosome,
				inGroup);

		events.add(otherEvent);

		return otherEvent;

	}

}
