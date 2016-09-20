package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import factory.EventFactory;
import model.MovieEvent;
import model.MoviesGeneres;
import model.Profile;
import model.User;

public class MovieEventTest {
	
	@Test
	public void isCompatibleTrueGenereAccion(){
	
		Profile profile = mock(Profile.class);
		
		List <String> generes = new ArrayList<String>();
		
		generes.add(MoviesGeneres.ACCION);
		
		when(profile.getMoviegeneres()).thenReturn(generes);
	
		MovieEvent movieEvent = EventFactory.eventMovieGenderAccion();
		
		assertTrue(movieEvent.isCompatible(profile));
		
	}
	
	@Test
	public void isCompatibleFalseGenereAccion(){
		
		Profile profile = mock(Profile.class);
		
		List <String> generes = new ArrayList<String>();
		
		generes.add(MoviesGeneres.COMEDIA);
		
		when(profile.getMoviegeneres()).thenReturn(generes);
	
		MovieEvent movieEvent = EventFactory.eventMovieGenderAccion();
		
		assertFalse(movieEvent.isCompatible(profile));
		
	}
	
	@Test
	public void couldBelongTrue(){
		Profile profile = mock(Profile.class);
		MovieEvent movieEvent = EventFactory.eventMovieGenderAccion();
		
		@SuppressWarnings("unchecked")
		ArrayList<String> movie= mock(ArrayList.class); 
		
		when(profile.getMoviegeneres()).thenReturn(movie);
		when(movie.isEmpty()).thenReturn(false);
		
		assertTrue(movieEvent.couldBelong(profile));
		
	}
	
	@Test
	public void couldBelongFalse(){
		Profile profile = mock(Profile.class);
		MovieEvent movieEvent = EventFactory.eventMovieGenderAccion();
		
		@SuppressWarnings("unchecked")
		ArrayList<String> movie= mock(ArrayList.class); 
		
		when(profile.getMoviegeneres()).thenReturn(movie);
		when(movie.isEmpty()).thenReturn(true);
		
		assertFalse(movieEvent.couldBelong(profile));
		
	}
	
	@Test
	public void whereAddYou(){
		User user = mock(User.class);
		MovieEvent event = EventFactory.eventMovieGenderAccion();
		
		doNothing().when(user).addMovie(event.getGenere());
		
		event.whereAddYou(user);
		
		verify(user, times(1)).addMovie(event.getGenere());
		
	}


}
