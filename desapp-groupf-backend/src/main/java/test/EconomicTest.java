package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import model.Economic;
import model.Event;
import model.FoodEvent;
import model.MovieEvent;
import model.MusicalEvent;
import model.OtherEvent;
import model.Profile;
import model.User;
import packageTestFactory.FactoryUser;


public class EconomicTest {

	@Test
	public void filterEconomic()  {
        // create mocks
		//FactoryUser fu = new FactoryUser();
		User user = FactoryUser.getInstance(); //mock(User.class);
        Profile profile = mock(Profile.class);
        Event musicalEvent = mock(MusicalEvent.class);
        Event foodEvent = mock(FoodEvent.class);
        Event movieEvent = mock(MovieEvent.class);
        Event otherEvent = mock(OtherEvent.class);
        
        // creates the list for "economic" class
        List<Event> allEvents = new ArrayList<Event>();
        allEvents.add(musicalEvent);
        allEvents.add(foodEvent);
        allEvents.add(movieEvent);
        allEvents.add(otherEvent);
        
        // create the concrete class "Economica"
        Economic economic = new Economic();
        
        // defined answers for methods        
        when(user.getProfile()).thenReturn(profile);
        when(profile.getAmuntMax()).thenReturn(10L);
        when(musicalEvent.getPrice()).thenReturn(10L);
        when(foodEvent.getPrice()).thenReturn(11L);
        when(movieEvent.getPrice()).thenReturn(9L);
        when(otherEvent.getPrice()).thenReturn(12L);      
        
        // verifies that the elements are just 2
        assertEquals(economic.filter(allEvents, user).size(), 2);
        
        // verifies that the correct items are 
        assertTrue(economic.filter(allEvents, user).contains(musicalEvent));
        assertTrue(economic.filter(allEvents, user).contains(movieEvent));
        
        assertFalse(economic.filter(allEvents, user).contains(foodEvent));
        assertFalse(economic.filter(allEvents, user).contains(otherEvent));
    }

}
