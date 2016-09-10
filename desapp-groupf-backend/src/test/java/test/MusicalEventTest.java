package test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import model.MusicalEvent;
import model.MusicalGeneres;
import model.Profile;

public class MusicalEventTest {

	@Test
	public void isCompatibleTrueGenereMusicalRock(){
		
		Profile profile = mock(Profile.class);
		
		List <String> generes = new ArrayList<String>();
		
		generes.add(MusicalGeneres.ROCK);
		
		when(profile.getMoviegeneres()).thenReturn(generes);
	
		MusicalEvent movieEvent = new MusicalEvent(MusicalGeneres.ROCK);
		
		assertTrue(movieEvent.isCompatible(profile));
		
	}

	@Test
	public void isCompatibleFalseGenereMusicalRock(){
		
		Profile profile = mock(Profile.class);
		
		List <String> generes = new ArrayList<String>();
		
		generes.add(MusicalGeneres.DISCO);
		
		when(profile.getMoviegeneres()).thenReturn(generes);
	
		MusicalEvent movieEvent = new MusicalEvent(MusicalGeneres.ROCK);
		
		assertFalse(movieEvent.isCompatible(profile));
		
	}
	
}
