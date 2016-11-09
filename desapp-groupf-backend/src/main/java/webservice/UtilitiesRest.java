package webservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import model.Place;
import service.GeneralService;

@Path("/utils")

public class UtilitiesRest {

	private GeneralService service;

	public GeneralService getService() {
		return service;
	}

	public void setService(GeneralService service) {
		this.service = service;
	}

	@GET
	@Path("/place/{id}")
	@Produces("application/json")
	public Place findPlacesById(@PathParam("id") final Integer id) {
		Place places = this.getService().getUtilitiesService().getById(id);
		return places;
	}

	@GET
	@Path("/places")
	@Produces("application/json")
	public List<Place> findAllPlaces() {
		List<Place> places = this.getService().getUtilitiesService().retriveAll();
		return places;
	}
	
	@POST
	@Path("/addplace/{name}/{address}")
	@Produces("application/json")
	public Place addPlace(@PathParam("name") final String name, @PathParam("address") final String address) {

		Place place = new Place();
		place.setName(name);
		place.setAddress(address);
		this.getService().getUtilitiesService().save(place);

		return place;
	}
}
