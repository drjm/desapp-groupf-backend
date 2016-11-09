package webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import model.Event;
import model.FoodEvent;
import model.MovieEvent;
import model.MusicalEvent;
import model.OtherEvent;
import service.EventService;

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
	public List<Event> events() {

		return this.getEventService().retriveAll();

	}

	@DELETE
	@Path("/deleteevent/{id}")
	@Produces("application/json")
	public String deleteProfile(@PathParam("id") final Integer id) {

		try {
			Event toDelete = this.getEventService().getById(id);
			this.getEventService().delete(toDelete);
		} catch (Exception e) {
			return "Id not found";
		}
		return "Delete Ok";
	}

	@GET
	@Path("/getEvent/{id}")
	@Produces("application/json")
	public Event getEvent(@PathParam("id") final Integer id) {
		return this.getEventService().getById(id);
	}

	@POST
	@Path("/addfoodevent")
	@Consumes("application/json")
	@Produces("application/json")
	public Event addFoodEvent(FoodEvent event) {
		this.getEventService().save(event);
		return event;
	}

	@POST
	@Path("/addmovieevent")
	@Consumes("application/json")
	@Produces("application/json")
	public Event addMovieEvent(MovieEvent event) {

		this.getEventService().save(event);
		return event;
	}

	@POST
	@Path("/addmusicalevent")
	@Consumes("application/json")
	@Produces("application/json")
	public Event addMusicalEvent(MusicalEvent event) {

		this.getEventService().save(event);
		return event;
	}

	@POST
	@Path("/addotherevent")
	@Consumes("application/json")
	@Produces("application/json")
	public Event addOtherEvent(OtherEvent event) {

		this.getEventService().save(event);
		return event;
	}

	@GET
	@Path("/filter/cantPerson/{cant}")
	@Produces("application/json")
	public List<Event> getEventByCantPerson(@PathParam("cant") final Integer cant) {
		return this.getEventService().getEventByCantPerson(cant);
	}

}
