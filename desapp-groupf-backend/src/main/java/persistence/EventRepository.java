package persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import model.Event;

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

}
