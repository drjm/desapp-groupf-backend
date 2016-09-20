package test;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import factory.EventFactory;
import model.MusicalEvent;
import model.MusicalGeneres;
import model.Profile;
import model.User;

public class MusicalEventTest {

	@Test
	public void isCompatibleTrueGenereMusicalRock(){
		
		Profile profile = mock(Profile.class);
		
		List <String> generes = new ArrayList<String>();
		
		generes.add(MusicalGeneres.ROCK);
		
		when(profile.getMoviegeneres()).thenReturn(generes);
	
		MusicalEvent movieEvent = EventFactory.eventMusicalGenderRock();
		
		assertTrue(movieEvent.isCompatible(profile));
		
	}

	@Test
	public void isCompatibleFalseGenereMusicalRock(){
		
		Profile profile = mock(Profile.class);
		
		List <String> generes = new ArrayList<String>();
		
		generes.add(MusicalGeneres.DISCO);
		
		when(profile.getMoviegeneres()).thenReturn(generes);
	
		MusicalEvent movieEvent =  EventFactory.eventMusicalGenderRock();
		
		assertFalse(movieEvent.isCompatible(profile));
		
	}
	
	@Test
	public void couldBelongTrue(){
		Profile profile = mock(Profile.class);
		MusicalEvent musicalEvent = EventFactory.eventMusicalGenderRock();
		
		@SuppressWarnings("unchecked")
		ArrayList<String> musical= mock(ArrayList.class); 
		
		when(profile.getMusicalGeneres()).thenReturn(musical);
		when(musical.isEmpty()).thenReturn(false);
		
		assertTrue(musicalEvent.couldBelong(profile));
		
	}
	
	@Test
	public void couldBelongFalse(){
		Profile profile = mock(Profile.class);
		MusicalEvent musicalEvent = EventFactory.eventMusicalGenderRock();
		
		@SuppressWarnings("unchecked")
		ArrayList<String> musical= mock(ArrayList.class); 
		
		when(profile.getMusicalGeneres()).thenReturn(musical);
		when(musical.isEmpty()).thenReturn(true);
		
		assertFalse(musicalEvent.couldBelong(profile));
		
	}
	
	@Test
	public void whereAddYou(){
		User user = mock(User.class);
		MusicalEvent event = EventFactory.eventMusicalGenderRock();
		
		doNothing().when(user).addMusic(event.getGender());
		
		event.whereAddYou(user);
		
		verify(user, times(1)).addMusic(event.getGender());
		
	}
	
}
