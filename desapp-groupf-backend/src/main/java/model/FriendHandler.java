package model;

import java.util.Iterator;
import java.util.List;

public class FriendHandler {

	private List<User> friends;
	
	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	public void addFriend(User friend){
	   this.getFriends().add(friend);	
	}
	
	public void removeFriend(User friend){
		   this.getFriends().remove(friend);	
	}
	
	public void eventInvite(Event event, List<User>friends){
		  Iterator<User> itr = friends.iterator();
	      while(itr.hasNext()) {
	         (itr.next()).invited(event);
	      }
	}
	
}