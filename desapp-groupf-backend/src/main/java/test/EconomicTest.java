package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
//import org.junit.Test;
import org.mockito.Mockito;

import model.Profile;
import model.User;


public class EconomicTest {

	@Test
	public void getAmountMaxTest()  {
        
		User user = Mockito.mock(User.class);
        Profile profile = Mockito.mock(Profile.class);

        when(user.getProfile()).thenReturn(profile);
        when(profile.getAmuntMax()).thenReturn(10L);

        assertEquals(user.getProfile().getAmuntMax(), 10L);
    }

}
