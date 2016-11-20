package service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.transaction.annotation.Transactional;

import model.Event;
import model.GenderMusical;
import model.MusicalEvent;
import model.Place;
import persistence.EventRepository;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class EventService extends GenericService<Event> implements Initialize {

	private static final long serialVersionUID = -6489416395090525589L;

	@Transactional
	public List<Event> getEventByCantPerson(final Integer cant) {

		return (List<Event>) ((EventRepository) this.getRepository()).getEventByCantPerson(cant);
	}

	@Transactional
	public void initialize() {
		
		Place place = new Place("Estadio Unico de La Plata", "Av. 25, 1900 La Plata, Buenos Aires");
		MusicalEvent eventMusical1 = new MusicalEvent(new GenderMusical("ROCK"), "21:00:00", "01:00:00",
				LocalDate.of(2016, Month.DECEMBER, 8), "Recital en vivo de el Indio Solari", new Long(200),
				new Boolean(true), new Boolean(true), new Boolean(true), place);
		this.getRepository().save(eventMusical1);
		System.out.println("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
	}

}
