package service;

import org.springframework.transaction.annotation.Transactional;

import model.User;
import persistence.UserRepository;

public class UserService extends GenericService<User> {

	private static final long serialVersionUID = -7871118767651385673L;

	@Transactional
	public User getUserByEmail(final String mail) {

		return ((User)((UserRepository)this.getRepository()).getUserByEmailRepo(mail));
	}

}
