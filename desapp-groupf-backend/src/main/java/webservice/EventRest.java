package webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import dtos.CreateDTOS;
import model.Event;
import model.FoodEvent;
import model.GenderMovie;
import model.GenderMusical;
import model.MovieEvent;
import model.MusicalEvent;
import model.OtherEvent;
import model.OtherLike;
import model.TypeFood;
import service.EventService;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Path("/event")
public class EventRest {

	private EventService eventService;

	public EventService getEventService() {
		return eventService;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	@GET
	@Path("/events")
	@Produces("application/json")
	public Response events() {
		return Response.ok(CreateDTOS.listEventDTO(this.getEventService().retriveAll())).build();
	}

	@DELETE
	@Path("/deleteevent/{id}")
	@Produces("application/json")
	public Response deleteProfile(@PathParam("id") final Integer id) {

		try {
			Event toDelete = this.getEventService().getById(id);
			this.getEventService().delete(toDelete);
		} catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.status(Response.Status.OK).build();
	}

	@GET
	@Path("/getEvent/{id}")
	@Produces("application/json")
	public Response getEvent(@PathParam("id") final Integer id) {
		Event ret;
		try {
			ret = this.getEventService().getById(id);
		} catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(CreateDTOS.createEventDTO(ret)).build();
	}

	@POST
	@Path("/addfoodevent/{idUser}/{like}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response addFoodEvent(FoodEvent event, @PathParam("idUser") final Integer idUser,
			@PathParam("like") final String like) {
		TypeFood food = new TypeFood(like);
		event.setTypeFood(food);
		this.getEventService().save(event);
		this.getEventService().associateUserToEvent(event.getIdEvent(), idUser);
		return Response.ok(event).build();
	}

	@POST
	@Path("/addmovieevent/{idUser}/{like}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response addMovieEvent(MovieEvent event, @PathParam("idUser") final Integer idUser,
			@PathParam("like") final String like) {

		GenderMovie movie = new GenderMovie(like);
		event.setGenere(movie);
		MovieEvent me = new MovieEvent(event.getTitle(), movie, event.getStarTime(), event.getEndTime(),
				event.getDate(), event.getDescription(), event.getPrice(), event.getAlone(), event.getInTwosome(),
				event.getInGruop(), event.getPlace());
		me.setDateString(event.getDateString());
		this.getEventService().save(me);
		this.getEventService().associateUserToEvent(me.getIdEvent(), idUser);
		return Response.ok(me).build();
	}

	@POST
	@Path("/addmusicalevent/{idUser}/{like}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response addMusicalEvent(MusicalEvent event, @PathParam("idUser") final Integer idUser,
			@PathParam("like") final String like) {

		GenderMusical musical = new GenderMusical(like);
		event.setGender(musical);

		this.getEventService().save(event);
		this.getEventService().associateUserToEvent(event.getIdEvent(), idUser);
		return Response.ok(event).build();
	}

	@POST
	@Path("/addotherevent/{idUser}/{like}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response addOtherEvent(OtherEvent event, @PathParam("idUser") final Integer idUser,
			@PathParam("like") final String like) {

		OtherLike other = new OtherLike(like);
		event.setOtherLike(other);
		this.getEventService().save(event);
		this.getEventService().associateUserToEvent(event.getIdEvent(), idUser);
		return Response.ok(event).build();
	}

	@GET
	@Path("/filter/cantPerson/{cant}")
	@Produces("application/json")
	public Response getEventByCantPerson(@PathParam("cant") final Integer cant) {
		List<Event> events;
		try {
			events = this.getEventService().getEventByCantPerson(cant);
		} catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).build();

		}
		return Response.ok(CreateDTOS.listEventDTO(events)).build();
	}

	@POST
	@Path("/filter/sugerenciasMusical")
	@Consumes("application/json")
	@Produces("application/json")
	public Response getEventByLikesMusical(List<String> likes) {
		List<Event> events;
		try {
			events = this.getEventService().getEventByMusicalLike(likes);
		} catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).build();

		}
		return Response.ok(CreateDTOS.listEventDTO(events)).build();
	}

	@POST
	@Path("/filter/sugerenciasMovies")
	@Consumes("application/json")
	@Produces("application/json")
	public Response getEventByLikesMovies(List<String> likes) {
		List<Event> events;
		try {
			events = this.getEventService().getEventByMovieLike(likes);

		} catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).build();

		}
		return Response.ok(CreateDTOS.listEventDTO(events)).build();
	}

	@POST
	@Path("/filter/sugerenciasFood")
	@Consumes("application/json")
	@Produces("application/json")
	public Response getEventByLikeFood(List<String> likes) {
		List<Event> events;
		try {
			events = this.getEventService().getEventByFoodLike(likes);
		} catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).build();

		}
		return Response.ok(CreateDTOS.listEventDTO(events)).build();
	}

	@POST
	@Path("/filter/sugerenciasOther")
	@Consumes("application/json")
	@Produces("application/json")
	public Response getEventByOther(List<String> likes) {
		List<Event> events;
		try {
			events = this.getEventService().getEventByOtherLike(likes);
		} catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).build();

		}
		return Response.ok(CreateDTOS.listEventDTO(events)).build();
	}

}
