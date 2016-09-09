package model;

import java.util.List;

public abstract class Filter {
	
	public abstract List<Event> filter(List<Event> listEvent, User user);

}
