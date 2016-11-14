//package test;
//
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.*;
//
//import java.util.ArrayList;
//
//import model.Event;
//import model.FriendHandler;
//import model.User;
//
//public class FriendHandlerTest {
//	
//	@Test
//	public void eventInviteAllUsersInvited() {
//		User pedro = mock(User.class);
//		User juan = mock(User.class);
//		
//		Event event = mock(Event.class);
//		
//		FriendHandler fh = new FriendHandler();
//		
//		ArrayList<User> friends = new ArrayList<User>();
//		friends.add(pedro);
//		friends.add(juan);
//		
//		doNothing().when(pedro).invited(event);
//		doNothing().when(juan).invited(event);
//		
//		fh.eventInvite(event, friends);
//		
//		verify(pedro, times(1)).invited(event);
//		verify(juan, times(1)).invited(event);
//	}
//	
//	@Test
//	public void eventInviteNotAllUserInvited() {
//		User pedro = mock(User.class);
//		User juan = mock(User.class); // do not invited
//		
//		Event event = mock(Event.class);
//		
//		FriendHandler fh = new FriendHandler();
//		
//		ArrayList<User> friends = new ArrayList<User>();
//		friends.add(pedro);
//		
//		doNothing().when(pedro).invited(event);
//		doNothing().when(juan).invited(event);
//		
//		fh.eventInvite(event, friends);
//		
//		verify(pedro, times(1)).invited(event);
//		verify(juan, times(0)).invited(event);
//	}
//	
//	@Test
//	public void addFriend() {
//		User pedro = mock(User.class);
//		
//		FriendHandler friendHandler = new FriendHandler();
//		
//		ArrayList<User> friends = new ArrayList<User>();
//		
//		friendHandler.setFriends(friends);
//		friendHandler.addFriend(pedro);
//		
//		assertEquals(friendHandler.getFriends().size(),1);
//		assertEquals(friendHandler.getFriends().get(0),pedro);
//	}
//	
//	@Test
//	public void removeFriend() {
//		User pedro = mock(User.class);
//		
//		FriendHandler friendHandler = new FriendHandler();
//		
//		ArrayList<User> friends = new ArrayList<User>();
//		
//		friendHandler.setFriends(friends);
//		friendHandler.removeFriend(pedro);
//		
//		assertTrue(friendHandler.getFriends().isEmpty());
//	}
//	
//	
//
//}