package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Filter {

	public List<Event> filter(List<Event> listEvent, User user) {

		List<Event> eventSuggestion = new ArrayList<Event>();

		for (Event e : listEvent) {

			if (this.applyFilter(e, user)) {
				eventSuggestion.add(e);
			}
		}
		return eventSuggestion;
	}

	public abstract Boolean applyFilter(Event e, Object profile);

}
