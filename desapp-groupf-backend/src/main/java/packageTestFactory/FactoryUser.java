package packageTestFactory;

import static org.mockito.Mockito.*;
import model.User;

public class FactoryUser {
	
	private static User instance = null;
	   protected FactoryUser() {
	      // Exists only to defeat instantiation.
	   }
	   public static User getInstance() {
	      if(instance == null) {
	         instance = mock(User.class);
	      }
	      return instance;
	   }
	
	
}
