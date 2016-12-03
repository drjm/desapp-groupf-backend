package persistence;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;

import model.Event;
import model.User;

public class UserRepository extends HibernateGenericDAO<User> implements GenericRepository<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5837587448665827923L;

	@Override
	protected Class<User> getDomainClass() {

		return User.class;
	}

	@Transactional
	public User getUserByEmailRepo(String mail) {

		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "FROM User U WHERE U.mail LIKE :email";
		Query query = session.createQuery(hql);
		query.setParameter("email", mail);
		return (User) query.list().get(0);
	}

	@Transactional
	public User attendEvent(Integer idUser, Integer idEvent) {

		Session session = this.getSessionFactory().getCurrentSession();
		User user = this.findById(idUser);
		String hql = "FROM Event E WHERE E.idEvent = :idEvent";
		Query query = session.createQuery(hql);
		query.setParameter("idEvent", idEvent);
		Event event = (Event) query.list().get(0);
		user.attendEvent(event);
		session.update(event);
		session.update(user);
		session.flush();
		return user;
	}

	public User addFriend(Integer idUser, Integer idFriend) {

		Session session = this.getSessionFactory().getCurrentSession();
		User user = this.findById(idUser);
		User friend = this.findById(idFriend);

		user.addFrien(friend);
		session.update(friend);
		session.update(user);
		session.flush();
		return user;
	}

}
