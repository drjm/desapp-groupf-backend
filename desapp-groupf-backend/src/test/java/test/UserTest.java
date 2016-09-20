package test;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;

import model.Event;
import model.HandlerEvent;
import model.Profile;
import model.User;

public class UserTest {
	
	@Test
	public void invitedTest() {
		HandlerEvent handlerEvent = mock(HandlerEvent.class);
		User juan = new User();
		Event event = mock(Event.class);
		
		juan.setHandlerEvent(handlerEvent);
		
		doNothing().when(handlerEvent).addPendingEvent(event);
		doNothing().when(event).addObserver(juan);
		
		juan.invited(event);
		verify(handlerEvent, times(1)).addPendingEvent(event);
	}
	
	@Test
	public void acceptEventTest() {
		HandlerEvent handlerEvent = mock(HandlerEvent.class);
		User juan = new User();
		Event event = mock(Event.class);
		ArrayList<Event> list = new ArrayList<Event>();
		list.add(event);
		
		juan.setHandlerEvent(handlerEvent);
		
		when(handlerEvent.getPendingEvents()).thenReturn(list);
		doNothing().when(handlerEvent).acceptEvent(event);
		doNothing().when(event).whereAddYou(juan);
		doNothing().when(event).addObserver(juan);
		
		juan.acceptEvent(event);
		
		verify(handlerEvent, times(1)).getPendingEvents();
		verify(event, times(1)).whereAddYou(juan);
	}
	
	@Test
	public void addFood() {
		User juan = new User();
        Profile profile = mock(Profile.class);
        
		
		doNothing().when(profile).addFood("food");
		
		juan.setProfile(profile);		
		juan.addFood("food");
		
		verify(profile, times(1)).addFood("food");
	}
	
	@Test
	public void addMusic() {
		User juan = new User();
        Profile profile = mock(Profile.class);
		
		doNothing().when(profile).addMusic("rock");
		
		juan.setProfile(profile);
		juan.addMusic("rock");
		
		verify(profile, times(1)).addMusic("rock");
	}
	
	@Test
	public void addMovie() {
		User juan = new User();
        Profile profile = mock(Profile.class);
		
		doNothing().when(profile).addMovie("movie");
		
		juan.setProfile(profile);
		juan.addMovie("movie");
		
		verify(profile, times(1)).addMovie("movie");
	}
	
	@Test
	public void addOther() {
		User juan = new User();
        Profile profile = mock(Profile.class);
		
		doNothing().when(profile).addOther("other");
		
		juan.setProfile(profile);
		juan.addOther("other");
		
		verify(profile, times(1)).addOther("other");
	}
	
	@Test
	public void cancelEvent(){
		User user = new User();
		Event event = mock(Event.class);
		
		doNothing().when(event).cancel();
		
		user.cancelEvent(event);
		
		verify(event, times(1)).cancel();
	}
	
	
}