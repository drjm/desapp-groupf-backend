package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import factory.EventFactory;
import model.GenderMovie;
import model.MovieEvent;
import model.MoviesGeneres;
import model.Profile;

public class MovieEventTest {

	@Test
	public void isCompatibleTrueGenereAccion() {

		Profile profile = mock(Profile.class);

		List<GenderMovie> generes = new ArrayList<GenderMovie>();

		generes.add(new GenderMovie(MoviesGeneres.ACCION));

		when(profile.getMoviegeneres()).thenReturn(generes);

		MovieEvent movieEvent = EventFactory.eventMovieGenderAccion();

		assertTrue(movieEvent.isCompatible(profile));

	}

	@Test
	public void isCompatibleFalseGenereAccion() {

		Profile profile = mock(Profile.class);

		List<GenderMovie> generes = new ArrayList<GenderMovie>();

		generes.add(new GenderMovie(MoviesGeneres.COMEDIA));

		when(profile.getMoviegeneres()).thenReturn(generes);

		MovieEvent movieEvent = EventFactory.eventMovieGenderAccion();

		assertFalse(movieEvent.isCompatible(profile));

	}

}
