package model;

import java.util.ArrayList;
import java.util.List;

public class SaturNight extends Filter {

	private String startTimeEvent1 = ""; // 18 hs
	private String endTime = ""; // 10 hs
	private String currentTime = "";

	@Override
	public Boolean applyFilter(Event e, Object profile) {

		return e.isAvaliable() && e.isCompatible((Profile) profile);
	}

	public List<Event> filter(List<Event> listEvent, User user) {

		List<Event> events = new ArrayList<Event>();
		Profile profile = user.getProfile();
		this.currentTime = startTimeEvent1;

		for (Event e : listEvent) {
			if (this.applyFilter(e, profile) && e.timeStartIn(profile, this.getCurrentTime(), this.getEndTime())) {
				events.add(e);
			}
		}

		return events;

	}

	public String getStartTimeEvent1() {
		return startTimeEvent1;
	}

	public void setStartTimeEvent1(String startTimeEvent1) {
		this.startTimeEvent1 = startTimeEvent1;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Boolean matchTime(Event event) {

		return true;
	}

	public String getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}

}
