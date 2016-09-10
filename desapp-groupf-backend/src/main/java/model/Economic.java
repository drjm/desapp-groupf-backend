package model;

import java.util.ArrayList;
import java.util.List;

public class Economic extends Filter {

	@Override
	public List<Event> filter(List<Event> listEvent, User user) {
		List<Event> eventToAmountMaxOfUser = new ArrayList<Event>(); 
		for(Event event:listEvent){
			if(event.getPrice() <= user.getProfile().getAmuntMax()){
				eventToAmountMaxOfUser.add(event);
			}
		}
		return eventToAmountMaxOfUser;
	}

	@Override
	public Boolean applyFilter(Event e, Object profile) {
		// TODO Auto-generated method stub
		return null;
	}

}
