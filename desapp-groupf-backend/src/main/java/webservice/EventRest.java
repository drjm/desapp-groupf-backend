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

import model.Event;
import model.FoodEvent;
import model.MovieEvent;
import model.MusicalEvent;
import model.OtherEvent;
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

		// List<Event> ret = this.getEventService().retriveAll();
		return Response.ok(this.getEventService().retriveAll()).build();

	}

	@GET
	@Path("/eventsL")
	@Produces("application/json")
	public List<Event> eventsL() {

		// List<Event> ret = this.getEventService().retriveAll();
		return this.getEventService().retriveAll();

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
		return Response.ok(ret).build();
	}

	@POST
	@Path("/addfoodevent")
	@Consumes("application/json")
	@Produces("application/json")
	public Response addFoodEvent(FoodEvent event) {

		this.getEventService().save(event);

		return Response.ok(event).build();
	}

	@POST
	@Path("/addmovieevent/{idUser}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response addMovieEvent(MovieEvent event, @PathParam("idUser") final Integer idUser) {

		this.getEventService().save(event);
		this.getEventService().associateUserToEvent(event.getIdEvent(), idUser);
		return Response.ok(event).build();
	}

	@POST
	@Path("/addmusicalevent")
	@Consumes("application/json")
	@Produces("application/json")
	public Response addMusicalEvent(MusicalEvent event) {

		this.getEventService().save(event);

		return Response.ok(event).build();
	}

	@POST
	@Path("/addotherevent")
	@Consumes("application/json")
	@Produces("application/json")
	public Response addOtherEvent(OtherEvent event) {

		this.getEventService().save(event);

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
		return Response.ok(events).build();
	}

}
