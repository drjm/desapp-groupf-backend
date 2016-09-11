package factory;

import model.User;
import static org.mockito.Mockito.*;

public class UserFactory {
	
	private static User instance = null;
	   protected UserFactory() {
		      // Exists only to defeat instantiation.
		   }
		   public static User getInstance() {
		      if(instance == null) {
		         instance = mock(User.class);
		      }
		      return instance;
		   }

}
