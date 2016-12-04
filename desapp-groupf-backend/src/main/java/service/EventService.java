package service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.transaction.annotation.Transactional;

import model.Event;
import model.GenderMovie;
import model.GenderMusical;
import model.MovieEvent;
import model.MoviesGeneres;
import model.MusicalEvent;
import model.Place;
import model.User;
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
		Place place1 = new Place("Estadio Monumental Antonio Vespucio Liberti",
				"Av. Pres. Figueroa Alcorta 7597, 1424 CABA");
		Place place2 = new Place("Estadio Pedro Bidegain",
				"Av. Gral. Fernández de la Cruz 2145, Cdad. Autónoma de Buenos Aires");

		MusicalEvent eventMusical1 = new MusicalEvent("Recital Indio Solari", new GenderMusical("ROCK"), "21:00:00",
				"01:00:00", LocalDate.of(2016, Month.DECEMBER, 8), "Recital en vivo de el Indio Solari", new Long(200),
				new Boolean(true), new Boolean(true), new Boolean(true), place);

		eventMusical1.addUser(new User("Pedro", "Gomez", "pedro@test", "pedro@test"));
		eventMusical1.getUsers().get(0).getEventsToattend().add(eventMusical1);

		MusicalEvent eventMusical2 = new MusicalEvent("Recital Indio Solari", new GenderMusical("ROCK"), "21:00:00",
				"01:00:00", LocalDate.of(2016, Month.DECEMBER, 9), "Recital en vivo de el Indio Solari", new Long(200),
				new Boolean(true), new Boolean(true), new Boolean(true), place1);
		eventMusical2.addUser(new User("Juan", "Perez", "juan@test", "juan@test"));
		eventMusical2.getUsers().get(0).getEventsToattend().add(eventMusical2);

		MusicalEvent eventMusical3 = new MusicalEvent("Recital Indio Solari", new GenderMusical("ROCK"), "21:00:00",
				"01:00:00", LocalDate.of(2016, Month.DECEMBER, 9), "Recital en vivo de el Indio Solari", new Long(200),
				new Boolean(true), new Boolean(true), new Boolean(true), place2);
		eventMusical3.addUser(new User("Roberto", "Rolon", "robert@test", "robert@test"));
		eventMusical3.getUsers().get(0).getEventsToattend().add(eventMusical3);

		this.getRepository().save(eventMusical1);
		this.getRepository().save(eventMusical2);
		this.getRepository().save(eventMusical3);

		Place cine1 = new Place("Hoyts Temperley", "Av. Hipólito Yrigoyen 10699, 1834 Temperley, Buenos Aires");
		Place cine2 = new Place("Atlas Alto Avellaneda", "Gral. Güemes 896, Crucecita, Buenos Aires");
		Place cine3 = new Place("Hoyts Abasto", "Av. Corrientes 3247, CABA");

		MovieEvent movieEvent = new MovieEvent("Estreno de la semana", new GenderMovie(MoviesGeneres.CIENCIAFICCION),
				"21:00:00", "01:00:00", LocalDate.of(2017, Month.DECEMBER, 15), "Star Wars: Episodio VIII",
				new Long(125), new Boolean(true), new Boolean(true), new Boolean(true), cine1);
		movieEvent.addUser(new User("Jorge", "Perez", "jorge@test", "jorge@test"));
		movieEvent.getUsers().get(0).getEventsToattend().add(movieEvent);

		MovieEvent movieEvent1 = new MovieEvent("Estreno de la semana", new GenderMovie(MoviesGeneres.CIENCIAFICCION),
				"21:00:00", "01:00:00", LocalDate.of(2017, Month.MARCH, 10), "Kong: Skull Island", new Long(125),
				new Boolean(true), new Boolean(true), new Boolean(true), cine2);
		movieEvent1.addUser(new User("Sofia", "Lucero", "sof@test", "sof@test"));
		movieEvent1.getUsers().get(0).getEventsToattend().add(movieEvent1);

		MovieEvent movieEvent2 = new MovieEvent("Estreno de la semana", new GenderMovie(MoviesGeneres.ACCION),
				"21:00:00", "01:00:00", LocalDate.of(2017, Month.DECEMBER, 15), "Fast 8", new Long(125),
				new Boolean(true), new Boolean(true), new Boolean(true), cine3);
		movieEvent2.addUser(new User("Pato", "Sara", "sara@test", "sara@test"));
		movieEvent2.getUsers().get(0).getEventsToattend().add(movieEvent2);

		this.getRepository().save(movieEvent);
		this.getRepository().save(movieEvent1);
		this.getRepository().save(movieEvent2);

		MovieEvent movieEvent3 = new MovieEvent("Estreno de la semana", new GenderMovie(MoviesGeneres.CIENCIAFICCION),
				"21:00:00", "01:00:00", LocalDate.of(2017, Month.DECEMBER, 15), "Star Wars: Episodio VIII",
				new Long(125), new Boolean(true), new Boolean(true), new Boolean(true), null);
		movieEvent3.addUser(new User("PEPE", "SOTO", "pepe@test", "pepe@test"));
		movieEvent3.getUsers().get(0).getEventsToattend().add(movieEvent3);

		MovieEvent movieEvent4 = new MovieEvent("Estreno de la semana", new GenderMovie(MoviesGeneres.CIENCIAFICCION),
				"21:00:00", "01:00:00", LocalDate.of(2017, Month.MARCH, 10), "Kong: Skull Island", new Long(125),
				new Boolean(true), new Boolean(true), new Boolean(true), null);
		movieEvent4.addUser(new User("maka", "test", "test@test", "test@test"));
		movieEvent4.getUsers().get(0).getEventsToattend().add(movieEvent4);

		MovieEvent movieEvent5 = new MovieEvent("Estreno de la semana", new GenderMovie(MoviesGeneres.ACCION),
				"21:00:00", "01:00:00", LocalDate.of(2017, Month.DECEMBER, 15), "Fast 8", new Long(125),
				new Boolean(true), new Boolean(true), new Boolean(true), null);
		movieEvent5.addUser(new User("USer test", "test", "test@test", "test@test"));
		movieEvent5.getUsers().get(0).getEventsToattend().add(movieEvent5);

		this.getRepository().save(movieEvent3);
		this.getRepository().save(movieEvent4);
		this.getRepository().save(movieEvent5);

		movieEvent3.setPlace(cine2);
		movieEvent4.setPlace(cine3);
		movieEvent5.setPlace(cine1);
		this.getRepository().update(movieEvent3);
		this.getRepository().update(movieEvent4);
		this.getRepository().update(movieEvent5);
	}

	@Transactional
	public Event addUserToEvent(Integer idEvent, Integer idUser) {
		return ((Event) ((EventRepository) this.getRepository()).attendEvent(idEvent, idUser));
	}

	@Transactional
	public void associateUserToEvent(Integer idEvent, Integer idUser) {

		((EventRepository) this.getRepository()).associateUserToEvent(idEvent, idUser);

	}

}
