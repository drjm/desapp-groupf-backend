package test;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;

import model.Event;
import model.GenderMovie;
import model.GenderMusical;
import model.HandlerEvent;
import model.OtherLike;
import model.Profile;
import model.TypeFood;
import model.User;

public class UserTest {

	@Test
	public void invitedTest() {
		HandlerEvent handlerEvent = mock(HandlerEvent.class);
		User juan = new User();
		Event event = mock(Event.class);

		juan.eventHandler(handlerEvent);

		doNothing().when(handlerEvent).addPendingEvent(event);

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

		juan.eventHandler(handlerEvent);

		when(handlerEvent.getPendingEvents()).thenReturn(list);
		doNothing().when(handlerEvent).acceptEvent(event);
		doNothing().when(event).whereAddYou(juan);

		juan.acceptEvent(event);

		verify(handlerEvent, times(1)).getPendingEvents();
		verify(event, times(1)).whereAddYou(juan);
	}

	@Test
	public void addFood() {
		User juan = new User();
		Profile profile = mock(Profile.class);

		TypeFood food = new TypeFood("food");
		
		doNothing().when(profile).addFood(food);

		juan.setProfile(profile);
		juan.addFood(food);

		verify(profile, times(1)).addFood(food);
	}

	@Test
	public void addMusic() {
		User juan = new User();
		Profile profile = mock(Profile.class);

		GenderMusical gender = new GenderMusical("rock");

		doNothing().when(profile).addMusic(gender);

		juan.setProfile(profile);
		juan.addMusic(gender);

		verify(profile, times(1)).addMusic(gender);
	}

	@Test
	public void addMovie() {
		User juan = new User();
		Profile profile = mock(Profile.class);

		GenderMovie gender = new GenderMovie("movie");
		
		doNothing().when(profile).addMovie(gender);

		juan.setProfile(profile);
		juan.addMovie(gender);

		verify(profile, times(1)).addMovie(gender);
	}

	@Test
	public void addOther() {
		User juan = new User();
		Profile profile = mock(Profile.class);

		OtherLike other = new OtherLike("other");
		
		doNothing().when(profile).addOther(other);

		juan.setProfile(profile);
		juan.addOther(other);

		verify(profile, times(1)).addOther(other);
	}

}