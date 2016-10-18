package persistence;

import model.Event;

public class EventRepository extends HibernateGenericDAO<Event> implements GenericRepository<Event> {

	private static final long serialVersionUID = 4587472159808484719L;

	@Override
	protected Class<Event> getDomainClass() {

		return Event.class;
	}

}
