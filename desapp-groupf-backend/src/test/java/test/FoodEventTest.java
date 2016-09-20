package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import factory.EventFactory;
import model.FoodEvent;
import model.FoodTypes;
import model.Profile;
import model.User;

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
	
	@Test
	public void couldBelongTrue(){
		Profile profile = mock(Profile.class);
		FoodEvent foodEvent = EventFactory.eventFoodCarne();
		
		@SuppressWarnings("unchecked")
		ArrayList<String> food= mock(ArrayList.class); 
		
		when(profile.getFoodTastes()).thenReturn(food);
		when(food.isEmpty()).thenReturn(false);
		
		assertTrue(foodEvent.couldBelong(profile));
		
	}
	
	@Test
	public void couldBelongFalse(){
		Profile profile = mock(Profile.class);
		FoodEvent foodEvent = EventFactory.eventFoodCarne();
		
		@SuppressWarnings("unchecked")
		ArrayList<String> food= mock(ArrayList.class); 
		
		when(profile.getFoodTastes()).thenReturn(food);
		when(food.isEmpty()).thenReturn(true);
		
		assertFalse(foodEvent.couldBelong(profile));
		
	}
	
	@Test
	public void whereAddYou(){
		User user = mock(User.class);
		FoodEvent event = EventFactory.eventFoodCarne();
		
		doNothing().when(user).addFood(event.getTypeFood());
		
		event.whereAddYou(user);
		
		verify(user, times(1)).addFood(event.getTypeFood());
		
	}
}
