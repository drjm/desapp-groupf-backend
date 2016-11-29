package webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import model.Event;
import model.Place;
import model.User;
import service.EventService;
import service.PlaceService;
import service.UserService;

@Path("/utils")

public class UtilitiesRest {

	private PlaceService placeService;
	private UserService userService;
	private EventService eventService;

	public PlaceService getPlaceService() {
		return placeService;
	}

	public void setPlaceService(PlaceService placeService) {
		this.placeService = placeService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public EventService getEventService() {
		return eventService;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	@GET
	@Path("/place/{id}")
	@Produces("application/json")
	public Response findPlacesById(@PathParam("id") final Integer id) {
		Place places;
		try {
			places = this.getPlaceService().getById(id);
		} catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

		return Response.ok(places).build();
	}

	@GET
	@Path("/places")
	@Produces("application/json")
	public Response findAllPlaces() {
		List<Place> places = this.getPlaceService().retriveAll();
		return Response.ok(places).build();
	}

	@POST
	@Path("/addplace")
	@Consumes("application/json")
	@Produces("application/json")
	public Response addPlace(final Place place) {

		this.getPlaceService().save(place);

		return Response.ok(place).build();
	}

	@POST
	@Path("/attendEvent/{idUser}/{idEvent}")
	@Produces("application/json")
	public Response updateUser(final @PathParam("idUser") Integer idUser, final @PathParam("idEvent") Integer idEvent) {

		User ret;
		Event ret2;
		try {

			ret = this.getUserService().attendEvent(idUser, idEvent);
			ret2 = this.getEventService().addUserToEvent(idEvent, idUser);

		} catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok("OK").build();
	}

}
