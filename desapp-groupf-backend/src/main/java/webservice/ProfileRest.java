package webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

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
	public Profile addProfile(Profile profile) {
		this.getProfileService().save(profile);
		return profile;
	}

	@GET
	@Path("/profiles")
	@Produces("application/json")
	public List<Profile> profiles() {

		return this.getProfileService().retriveAll();

	}

	@DELETE
	@Path("/deleteProfile/{id}")
	@Produces("application/json")
	public String deleteProfile(@PathParam("id") final Integer id) {

		try {
			Profile toDelete = this.getProfileService().getById(id);
			this.getProfileService().delete(toDelete);
		} catch (Exception e) {
			return "Id not found";
		}
		return "Delete Ok";
	}

	@GET
	@Path("/getprofile/{id}")
	@Produces("application/json")
	public Profile getProfile(@PathParam("id") final Integer id) {

		return this.getProfileService().getById(id);

	}

	@PUT
	@Path("/updateprofile")
	@Consumes("application/json")
	@Produces("application/json")
	public Profile updateProfile(Profile profile) {

		this.getProfileService().update(profile);
		return this.getProfileService().getById(profile.getIdProfile());
	}

}
