package model;

import java.util.List;

public class SaturNight extends Filter {

	
	
	@Override
	public Boolean applyFilter(Event e, Object profile) {
			
		return e.isAvaliable() && e.isCompatible((Profile) profile);
	}
	
	public List<Event> filter(List<Event> listEvent, User user){
	
		//AGREGAR LA LOGICA QUE CREA LOS USER S

		return listEvent;
		
	}

}
