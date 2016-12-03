package service;

import org.springframework.transaction.annotation.Transactional;

import model.User;
import persistence.UserRepository;

public class UserService extends GenericService<User> {

	private static final long serialVersionUID = -7871118767651385673L;

	@Transactional
	public User getUserByEmail(final String mail) {

		return ((User) ((UserRepository) this.getRepository()).getUserByEmailRepo(mail));
	}

	@Transactional
	public User attendEvent(Integer idUser, Integer idEvent) {

		return ((User) ((UserRepository) this.getRepository()).attendEvent(idUser, idEvent));
	}

	@Transactional
	public User addFriend(Integer idUser, Integer idFriend) {

		return ((User) ((UserRepository) this.getRepository()).addFriend(idUser, idFriend));
	}

}
