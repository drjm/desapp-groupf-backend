package test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import model.MovieEvent;
import model.MoviesGeneres;
import model.Profile;

public class MovieEventTest {
	
	@Test
	public void isCompatibleTrueGenereAccion(){
	
		Profile profile = mock(Profile.class);
		
		List <String> generes = new ArrayList<String>();
		
		generes.add(MoviesGeneres.ACCION);
		
		when(profile.getMoviegeneres()).thenReturn(generes);
	
		MovieEvent movieEvent = new MovieEvent(MoviesGeneres.ACCION);
		
		assertTrue(movieEvent.isCompatible(profile));
		
	}
	
	@Test
	public void isCompatibleFalseGenereAccion(){
		
		Profile profile = mock(Profile.class);
		
		List <String> generes = new ArrayList<String>();
		
		generes.add(MoviesGeneres.COMEDIA);
		
		when(profile.getMoviegeneres()).thenReturn(generes);
	
		MovieEvent movieEvent = new MovieEvent(MoviesGeneres.ACCION);
		
		assertFalse(movieEvent.isCompatible(profile));
		
	}


}
