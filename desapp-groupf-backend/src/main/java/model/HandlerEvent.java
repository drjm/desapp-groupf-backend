package model;

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
		this.events = 
				events;
	}
	public List<Filter> getFilters() {
		return filters;
	}
	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}
	public void addPendingEvent(Event event){
		this.getPendingEvents().add(event);
	}
	public void acceptEvent(Event event){
		this.getPendingEvents().remove(event);
		this.getEvents().add(event);
		
	}	
}
