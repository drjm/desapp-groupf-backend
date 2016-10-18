package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import model.MovieEvent;
import model.Profile;
import model.Twosome;
import model.User;

public class TwosomeTest {

	@Test
	public void testApplyFilterTrueWithEqualsAmountPriceAndTwoSome() {

		MovieEvent event = mock(MovieEvent.class);
		User user = mock(User.class);
		Profile profile = mock(Profile.class);

		when(event.getInTwosome()).thenReturn(true);
		when(user.getProfile()).thenReturn(profile);
		when(event.getPrice()).thenReturn(new Long(10));
		when(profile.getAmountMax()).thenReturn(new Long(10));
		when(event.isCompatible(user.getProfile())).thenReturn(true);
		when(event.isAvaliable()).thenReturn(true);

		Twosome twosome = new Twosome();

		assertTrue(twosome.applyFilter(event, user));

	}

	@Test
	public void testApplyFilterFalseWithNotEqualsAmountPriceAndTwoSome() {

		MovieEvent event = mock(MovieEvent.class);
		User user = mock(User.class);
		Profile profile = mock(Profile.class);

		when(event.getInTwosome()).thenReturn(true);
		when(user.getProfile()).thenReturn(profile);
		when(event.getPrice()).thenReturn(new Long(15));
		when(profile.getAmountMax()).thenReturn(new Long(10));
		when(event.isCompatible(user.getProfile())).thenReturn(true);

		Twosome twosome = new Twosome();

		assertFalse(twosome.applyFilter(event, user));
	}

}
