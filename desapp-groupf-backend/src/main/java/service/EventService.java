package service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import model.Event;
import persistence.EventRepository;

public class EventService extends GenericService<Event> {

	private static final long serialVersionUID = -6489416395090525589L;

	@Transactional
	public List<Event> getEventByCantPerson(final Integer cant) {

		return (List<Event>) ((EventRepository) this.getRepository()).getEventByCantPerson(cant);
	}

}
