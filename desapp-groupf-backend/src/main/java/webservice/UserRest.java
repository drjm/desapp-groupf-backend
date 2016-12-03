package webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import dtos.CreateDTOS;
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
	public Response addUser(User user) {
		this.getUserService().save(user);
		return Response.ok(CreateDTOS.createUserDTOSinEventos(user)).build();
	}

	@GET
	@Path("/users")
	@Produces("application/json")
	public Response Users() {

		return Response.ok(CreateDTOS.listUserDTO(this.getUserService().retriveAll())).build();

	}

	@DELETE
	@Path("/deleteUser/{id}")
	@Produces("application/json")
	public Response deleteUser(@PathParam("id") final Integer id) {

		try {
			User toDelete = this.getUserService().getById(id);
			this.getUserService().delete(toDelete);
		} catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok("Se borro correctamente...").build();
	}

	@GET
	@Path("/getUser/{id}")
	@Produces("application/json")
	public Response getUser(@PathParam("id") final Integer id) {

		User ret;
		try {
			ret = this.getUserService().getById(id);
		} catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(CreateDTOS.createUserDTO(ret)).build();

	}

	@GET
	@Path("/getUserByEmail/{mail}")
	@Produces("application/json")
	public Response getUserByEmail(@PathParam("mail") final String mail) {
		User ret;
		try {
			ret = this.getUserService().getUserByEmail(mail);
		} catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(CreateDTOS.createUserDTO(ret)).build();
	}

	@POST
	@Path("/updateUser")
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateUser(User User) {

		User ret;
		try {
			this.getUserService().update(User);
			ret = this.getUserService().getById(User.getIdUser());
		} catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(CreateDTOS.createUserDTO(ret)).build();
	}

	@POST
	@Path("/attendEvent/{idUser}/{idEvent}")
	@Produces("application/json")
	public Response updateUser(final @PathParam("idUser") Integer idUser, final @PathParam("idEvent") Integer idEvent) {

		User ret;
		try {

			ret = this.getUserService().attendEvent(idUser, idEvent);

		} catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(CreateDTOS.createUserDTO(ret)).build();
	}

	@POST
	@Path("/addFriend/{idUser}/{idFriend}")
	@Produces("application/json")
	public Response addFriend(final @PathParam("idUser") Integer idUser,
			final @PathParam("idFriend") Integer idFriend) {

		User ret;
		try {

			ret = this.getUserService().addFriend(idUser, idFriend);

		} catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(CreateDTOS.createUserDTO(ret)).build();
	}

}
