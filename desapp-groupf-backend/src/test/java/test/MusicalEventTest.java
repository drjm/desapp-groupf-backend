package test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import factory.EventFactory;
import model.GenderMusical;
import model.MusicalEvent;
import model.MusicalGeneres;
import model.Profile;

public class MusicalEventTest {

	@Test
	public void isCompatibleTrueGenereMusicalRock() {

		Profile profile = mock(Profile.class);

		List<GenderMusical> generes = new ArrayList<GenderMusical>();

		generes.add(new GenderMusical(MusicalGeneres.ROCK));

		when(profile.getMusicalGeneres()).thenReturn(generes);

		MusicalEvent movieEvent = EventFactory.eventMusicalGenderRock();

		assertTrue(movieEvent.isCompatible(profile));

	}

	@Test
	public void isCompatibleFalseGenereMusicalRock() {

		Profile profile = mock(Profile.class);

		List<GenderMusical> generes = new ArrayList<GenderMusical>();

		generes.add(new GenderMusical(MusicalGeneres.DISCO));

		when(profile.getMusicalGeneres()).thenReturn(generes);

		MusicalEvent movieEvent = EventFactory.eventMusicalGenderRock();

		assertFalse(movieEvent.isCompatible(profile));

	}

}
