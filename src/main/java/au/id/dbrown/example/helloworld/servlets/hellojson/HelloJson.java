package au.id.dbrown.example.helloworld.servlets.hellojson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import au.id.dbrown.example.helloworld.servlets.hellojson.simplemodel.ModelHolder;
import au.id.dbrown.example.helloworld.servlets.hellojson.simplemodel.SimpleModel;

/**
 * @author Damion Brown (dbrown) <the@dbrown.id.au>
 *
 */
@Path("/")
public class HelloJson {

	@GET
	@Path("hellojson")
	@Produces(MediaType.TEXT_PLAIN)
	public String heyjson() {
		return "Hey JSON!";
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/getmodel/{id}")
	public Response getModel(@PathParam("id") int id) {

		SimpleModel sm = ModelHolder.getHolder().getSimpleModel(id);

		if (sm == null) {
			return Response.status(Status.NOT_FOUND).build();
		}

		return Response.ok(sm).build();
	}

	@GET
	@Produces({ MediaType.TEXT_PLAIN })
	@Path("/setmodel/{id}/{string}")
	public Response setModel(@PathParam("id") int id, @PathParam("string") String string) {

		ModelHolder.getHolder().setSimpleModel(new SimpleModel(id, string));

		return Response.ok("OK").build();
	}
}
