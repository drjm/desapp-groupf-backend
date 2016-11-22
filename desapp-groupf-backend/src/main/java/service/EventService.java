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

		MusicalEvent eventMusical1 = new MusicalEvent(new GenderMusical("ROCK"), "21:00:00", "01:00:00",
				LocalDate.of(2016, Month.DECEMBER, 8), "Recital en vivo de el Indio Solari", new Long(200),
				new Boolean(true), new Boolean(true), new Boolean(true), place);
		MusicalEvent eventMusical2 = new MusicalEvent(new GenderMusical("ROCK"), "21:00:00", "01:00:00",
				LocalDate.of(2016, Month.DECEMBER, 9), "Recital en vivo de el Indio Solari", new Long(200),
				new Boolean(true), new Boolean(true), new Boolean(true), place1);
		MusicalEvent eventMusical3 = new MusicalEvent(new GenderMusical("ROCK"), "21:00:00", "01:00:00",
				LocalDate.of(2016, Month.DECEMBER, 9), "Recital en vivo de el Indio Solari", new Long(200),
				new Boolean(true), new Boolean(true), new Boolean(true), place2);
		this.getRepository().save(eventMusical1);
		this.getRepository().save(eventMusical2);
		this.getRepository().save(eventMusical3);

		Place cine1 = new Place("Hoyts Temperley", "Av. Hipólito Yrigoyen 10699, 1834 Temperley, Buenos Aires");
		Place cine2 = new Place("Atlas Alto Avellaneda", "Gral. Güemes 896, Crucecita, Buenos Aires");
		Place cine3 = new Place("Hoyts Abasto", "Av. Corrientes 3247, CABA");

		MovieEvent movieEvent = new MovieEvent(new GenderMovie(MoviesGeneres.CIENCIAFICCION), "21:00:00", "01:00:00",
				LocalDate.of(2017, Month.DECEMBER, 15), "Star Wars: Episodio VIII", new Long(125), new Boolean(true),
				new Boolean(true), new Boolean(true), cine1);

		MovieEvent movieEvent1 = new MovieEvent(new GenderMovie(MoviesGeneres.CIENCIAFICCION), "21:00:00", "01:00:00",
				LocalDate.of(2017, Month.MARCH, 10), "Kong: Skull Island", new Long(125), new Boolean(true),
				new Boolean(true), new Boolean(true), cine2);

		MovieEvent movieEvent2 = new MovieEvent(new GenderMovie(MoviesGeneres.ACCION), "21:00:00", "01:00:00",
				LocalDate.of(2017, Month.DECEMBER, 15), "Fast 8", new Long(125), new Boolean(true), new Boolean(true),
				new Boolean(true), cine3);

		this.getRepository().save(movieEvent);
		this.getRepository().save(movieEvent1);
		this.getRepository().save(movieEvent2);
		
		MovieEvent movieEvent3 = new MovieEvent(new GenderMovie(MoviesGeneres.CIENCIAFICCION), "21:00:00", "01:00:00",
				LocalDate.of(2017, Month.DECEMBER, 15), "Star Wars: Episodio VIII", new Long(125), new Boolean(true),
				new Boolean(true), new Boolean(true), null);

		MovieEvent movieEvent4 = new MovieEvent(new GenderMovie(MoviesGeneres.CIENCIAFICCION), "21:00:00", "01:00:00",
				LocalDate.of(2017, Month.MARCH, 10), "Kong: Skull Island", new Long(125), new Boolean(true),
				new Boolean(true), new Boolean(true), null);

		MovieEvent movieEvent5 = new MovieEvent(new GenderMovie(MoviesGeneres.ACCION), "21:00:00", "01:00:00",
				LocalDate.of(2017, Month.DECEMBER, 15), "Fast 8", new Long(125), new Boolean(true), new Boolean(true),
				new Boolean(true), null);

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

}
