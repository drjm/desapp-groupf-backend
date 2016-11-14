package webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import model.Profile;
import model.User;
import service.UserService;

@Path("/user")
public class UserRest {
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@POST
	@Path("/addUser")
	@Consumes("application/json")
	@Produces("application/json")
	public User addUser(User User) {
		this.getUserService().save(User);
		return User;
	}

	@POST
	@Path("/addUserNik/{nik}")
	@Produces("application/json")
	public User addUser(@PathParam("nik") final String nik) {
		User user = new User();
		Profile p = new Profile();
		p.setAmountMax(new Long(100));
		p.setConveyance("a Pie");
		p.setNik(nik);
		p.setStartTime("");
		user.setProfile(p);
		user.setNik(nik);
		this.getUserService().save(user);
		return user;
	}

	@GET
	@Path("/users")
	@Produces("application/json")
	public List<User> Users() {

		return this.getUserService().retriveAll();

	}

	@DELETE
	@Path("/deleteUser/{id}")
	@Produces("application/json")
	public String deleteUser(@PathParam("id") final Integer id) {

		try {
			User toDelete = this.getUserService().getById(id);
			this.getUserService().delete(toDelete);
		} catch (Exception e) {
			return "Id not found";
		}
		return "Delete Ok";
	}

	@GET
	@Path("/getUser/{id}")
	@Produces("application/json")
	public User getUser(@PathParam("id") final Integer id) {

		return this.getUserService().getById(id);

	}

	@GET
	@Path("/getUserByEmail/{mail}")
	@Produces("application/json")
	public User getUserByEmail(@PathParam("mail") final String mail) {
		try {
			return this.getUserService().getUserByEmail(mail);
		} catch (Exception e) {
			return null;
		}

	}

	@POST
	@Path("/updateUser")
	@Consumes("application/json")
	@Produces("application/json")
	public User updateUser(User User) {

		this.getUserService().update(User);
		return this.getUserService().getById(User.getIdUser());
	}

}
