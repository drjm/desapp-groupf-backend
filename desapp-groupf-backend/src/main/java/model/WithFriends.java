package model;

import java.util.ArrayList;
import java.util.List;

public class WithFriends extends Filter {

	@Override
	public Boolean applyFilter(Event e, Object usersParam) {

		@SuppressWarnings("unchecked")
		List<User> users = (ArrayList<User>) usersParam;

		Boolean isCompatible = e.getInGruop();

		for (User user : users) {
			isCompatible = isCompatible && e.isCompatible(user.getProfile());
		}
		return isCompatible;
	}

	public List<Event> filter(List<Event> listEvent, List<User> users) {

		List<Event> eventSuggestion = new ArrayList<Event>();

		for (Event e : listEvent) {

			if (this.applyFilter(e, users)) {
				eventSuggestion.add(e);
			}
		}
		return eventSuggestion;
	}

}
