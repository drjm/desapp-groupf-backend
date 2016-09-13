package test;

import java.util.ArrayList;

import org.junit.Test;

import model.Event;
import model.HandlerEvent;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class HandlerEventTest {

	@Test
	public void addPendingEventTest(){
		Event event = mock(Event.class);
		
		HandlerEvent handlerEvent = new HandlerEvent();
		ArrayList<Event> pendingEvents = new ArrayList<Event>();
		
		handlerEvent.setPendingEvents(pendingEvents);
		
		handlerEvent.addPendingEvent(event);
		
		assertEquals(handlerEvent.getPendingEvents().size(),1);
		
		
	}
	
	@Test
	public void acceptEventTest(){
		Event event = mock(Event.class);
		
		HandlerEvent handlerEvent = new HandlerEvent();
		ArrayList<Event> pendingEvents = new ArrayList<Event>();
		ArrayList<Event> events = new ArrayList<Event>();
		
		pendingEvents.add(event);
		
		handlerEvent.setPendingEvents(pendingEvents);
		handlerEvent.setEvents(events);
		
		handlerEvent.acceptEvent(event);
		
		assertTrue(handlerEvent.getPendingEvents().isEmpty());
		assertEquals(handlerEvent.getEvents().size(),1);
		
	}
	
}