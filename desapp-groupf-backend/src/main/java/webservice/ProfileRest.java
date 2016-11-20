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

import model.Profile;
import service.ProfileService;

@Path("/profile")
public class ProfileRest {

	private ProfileService profileService;

	public ProfileService getProfileService() {
		return profileService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	@POST
	@Path("/addprofile")
	@Consumes("application/json")
	@Produces("application/json")
	public Response addProfile(Profile profile) {

		this.getProfileService().save(profile);

		return Response.ok(profile).build();
	}

	@GET
	@Path("/profiles")
	@Produces("application/json")
	public Response profiles() {

		List<Profile> listProfiles = this.getProfileService().retriveAll();
		return Response.ok(listProfiles).build();

	}

	@DELETE
	@Path("/deleteProfile/{id}")
	@Produces("application/json")
	public Response deleteProfile(@PathParam("id") final Integer id) {

		try {
			Profile toDelete = this.getProfileService().getById(id);
			this.getProfileService().delete(toDelete);
		} catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok("Se borro correctamente").build();
	}

	@GET
	@Path("/getprofile/{id}")
	@Produces("application/json")
	public Response getProfile(@PathParam("id") final Integer id) {
		Profile profile;
		try {
			profile = this.getProfileService().getById(id);
		} catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(profile).build();

	}

	@POST
	@Path("/updateprofile")
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateProfile(Profile profile) {

		Profile ret;
		try {
			this.getProfileService().update(profile);
			ret = this.getProfileService().getById(profile.getIdProfile());
		} catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(ret).build();

	}

}
