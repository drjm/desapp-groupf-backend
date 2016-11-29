package persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import model.Event;
import model.User;

public class EventRepository extends HibernateGenericDAO<Event> implements GenericRepository<Event> {

	private static final long serialVersionUID = 4587472159808484719L;

	@Override
	protected Class<Event> getDomainClass() {

		return Event.class;
	}

	public List<Event> getEventByCantPerson(Integer cantPerson) {

		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "FROM Event E WHERE E.cantPerson = :cantperson";
		Query query = session.createQuery(hql);
		query.setParameter("cantperson", cantPerson);
		return query.list();
	}

	public Event attendEvent(Integer idEvent, Integer idUser) {

		Session session = this.getSessionFactory().getCurrentSession();
		Event event = this.findById(idEvent);
		String hql = "FROM User U WHERE U.idUser = :idUser";
		Query query = session.createQuery(hql);
		query.setParameter("idUser", idUser);
		User user = (User) query.list().get(0);
		event.addUser(user);
		session.update(event);
		session.flush();

		System.out.println("AAAAAAAAAAAAAAAAA" + event.getUsers().size());
		return event;

	}

}
