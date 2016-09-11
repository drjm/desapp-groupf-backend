package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import model.MusicalEvent;
import model.Profile;
import model.User;
import model.WithFriends;

public class WithFriendFilterTest {

	@Test
	public void testApplyFilterTrueAllFriendAreCompatible() {

		User user1 = mock(User.class);
		User user2 = mock(User.class);
		Profile profile = mock(Profile.class);
		MusicalEvent event = mock(MusicalEvent.class);
		when(event.getInGruop()).thenReturn(true);
		when(user1.getProfile()).thenReturn(profile);
		when(user2.getProfile()).thenReturn(profile);
		when(event.isCompatible(profile)).thenReturn(true);
		
		List<User> users = new ArrayList<User>();
		users.add(user2);
		users.add(user1);
		
		WithFriends withFriends = new WithFriends();

		assertTrue(withFriends.applyFilter(event, users));
	}
	@Test
	public void testApplyFilterFalseGetInGrouṕ() {

		User user1 = mock(User.class);
		User user2 = mock(User.class);
		Profile profile = mock(Profile.class);
		MusicalEvent event = mock(MusicalEvent.class);
		when(event.getInGruop()).thenReturn(false);
		when(user1.getProfile()).thenReturn(profile);
		when(user2.getProfile()).thenReturn(profile);
		when(event.isCompatible(profile)).thenReturn(true);
		
		List<User> users = new ArrayList<User>();
		users.add(user2);
		users.add(user1);
		
		WithFriends withFriends = new WithFriends();

		assertFalse(withFriends.applyFilter(event, users));
	}

	
}
