package factory;

import model.FoodEvent;
import model.FoodTypes;
import model.GenderMovie;
import model.GenderMusical;
import model.MovieEvent;
import model.MoviesGeneres;
import model.MusicalEvent;
import model.MusicalGeneres;
import model.TypeFood;

public class EventFactory {

	public static MusicalEvent eventMusicalGenderRock() {

		MusicalEvent event = new MusicalEvent(new GenderMusical(MusicalGeneres.ROCK), null, null, null, null, null,
				null, null, null);

		return event;
	}

	public static MovieEvent eventMovieGenderAccion() {

		MovieEvent event = new MovieEvent(new GenderMovie(MoviesGeneres.ACCION), null, null, null, null, null, null,
				null, null);

		return event;
	}

	public static FoodEvent eventFoodCarne() {

		FoodEvent event = new FoodEvent(new TypeFood(FoodTypes.CARNE), null, null, null, null, null, null, null, null);

		return event;
	}

}
