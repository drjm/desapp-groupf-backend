package test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import model.Event;
import model.MusicalEvent;
import model.Profile;
import model.SaturNight;
import model.User;

public class SaturNightTest {

	@Test
	public void testApplyFilterToThreeEventsReturnTrueApli() {

		MusicalEvent event1 = mock(MusicalEvent.class);
		MusicalEvent event2 = mock(MusicalEvent.class);
		MusicalEvent event3 = mock(MusicalEvent.class);

		User user = mock(User.class);
		Profile profile = mock(Profile.class);

		List<Event> listEvent = new ArrayList<Event>();
		listEvent.add(event1);
		listEvent.add(event2);
		listEvent.add(event3);

		when(user.getProfile()).thenReturn(profile);

		when(event1.isCompatible(profile)).thenReturn(true);
		when(event2.isCompatible(profile)).thenReturn(true);
		when(event3.isCompatible(profile)).thenReturn(true);

		when(event1.isAvaliable()).thenReturn(true);
		when(event2.isAvaliable()).thenReturn(true);
		when(event3.isAvaliable()).thenReturn(true);
		
		SaturNight saturNight = new SaturNight();

		when(event1.timeStartIn(profile, saturNight.getCurrentTime(), saturNight.getEndTime())).thenReturn(true);
		when(event2.timeStartIn(profile, saturNight.getCurrentTime(), saturNight.getEndTime())).thenReturn(true);
		when(event3.timeStartIn(profile, saturNight.getCurrentTime(), saturNight.getEndTime())).thenReturn(true);
		List<Event> size = saturNight.filter(listEvent, user);

		assertEquals(size.size(), 3);

	}

}
