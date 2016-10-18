package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import factory.UserFactory;
import model.Event;
import model.FoodEvent;
import model.MovieEvent;
import model.MusicalEvent;
import model.OtherEvent;
import model.Profile;
import model.Surprise;
import model.User;

public class SurpriseTest {
	
	@Test
	public void filterSuprise()  {
	User user = UserFactory.getInstance();
	Profile profile = mock(Profile.class);
	Event musicalEvent = mock(MusicalEvent.class);
	Event foodEvent = mock(FoodEvent.class);
	Event movieEvent = mock(MovieEvent.class);
	Event otherEvent = mock(OtherEvent.class);

	// creates the list for "Surprise" class
	List<Event> allEvents = new ArrayList<Event>();
	allEvents.add(musicalEvent);
	allEvents.add(foodEvent);
	allEvents.add(movieEvent);
	allEvents.add(otherEvent);

	// create the concrete class "Surprise"
	Surprise surprise = new Surprise();

	// defined answers for methods
	when(user.getProfile()).thenReturn(profile);
    when(musicalEvent.couldBelong(profile)).thenReturn(true);
    when(foodEvent.couldBelong(profile)).thenReturn(true);
    when(movieEvent.couldBelong(profile)).thenReturn(false);
    when(otherEvent.couldBelong(profile)).thenReturn(true);      
    
    // verifies that the elements are just 3
    assertEquals(surprise.filter(allEvents, user).size(), 3);
    
    // verifies that the correct items are 
    assertTrue(surprise.filter(allEvents, user).contains(musicalEvent));    
    assertTrue(surprise.filter(allEvents, user).contains(foodEvent));
    assertTrue(surprise.filter(allEvents, user).contains(otherEvent));
    
    assertFalse(surprise.filter(allEvents, user).contains(movieEvent));
}
}
