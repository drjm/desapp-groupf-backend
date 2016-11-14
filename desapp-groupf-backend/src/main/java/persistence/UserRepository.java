package persistence;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;

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


}
