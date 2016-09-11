package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import factory.EventFactory;
import model.FoodEvent;
import model.FoodTypes;
import model.Profile;

public class FoodEventTest {

	@Test
	public void isCompatibleTrueFoodAccion(){
	
		Profile profile = mock(Profile.class);
		
		List <String> foodsTypes = new ArrayList<String>();
		
		foodsTypes.add(FoodTypes.CARNE);
		
		when(profile.getFoodTastes()).thenReturn(foodsTypes);
	
		FoodEvent foodEvent = EventFactory.eventFoodCarne();
		
		assertTrue(foodEvent.isCompatible(profile));
		
	}
	
	@Test
	public void isCompatibleFalseFoodAccion(){
		
		Profile profile = mock(Profile.class);
		
		List <String> foodsTypes = new ArrayList<String>();
		
		foodsTypes.add(FoodTypes.VERDURAS);
		
		when(profile.getFoodTastes()).thenReturn(foodsTypes);
	
		FoodEvent foodEvent = EventFactory.eventFoodCarne();
		
		assertFalse(foodEvent.isCompatible(profile));
		
	}
	
}
