package factory;

import model.FoodEvent;
import model.FoodTypes;
import model.MovieEvent;
import model.MoviesGeneres;
import model.MusicalEvent;
import model.MusicalGeneres;

public class EventFactory {
	
	public static MusicalEvent eventMusicalGenderRock(){
		
		MusicalEvent event = new MusicalEvent(MusicalGeneres.ROCK, null, null, null, null,
				null, null, null, null);
		
				return event;
	}

	public static MovieEvent eventMovieGenderAccion(){
		
		MovieEvent event = new MovieEvent(MoviesGeneres.ACCION, null, null, null, null,
				null, null, null, null);
		
				return event;
	}

	public static FoodEvent eventFoodCarne(){
		
		FoodEvent event = new FoodEvent(FoodTypes.CARNE, null, null, null, null,
				null, null, null, null);
		
				return event;
	}

	
}
