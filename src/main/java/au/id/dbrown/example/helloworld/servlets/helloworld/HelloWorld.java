package au.id.dbrown.example.helloworld.servlets.helloworld;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Damion Brown (dbrown) <the@dbrown.id.au>
 *
 */
@Path("/")
public class HelloWorld {
	@GET
	@Path("helloworld")
	@Produces(MediaType.TEXT_PLAIN)
	public String helloworld() {
		return "Hello World!";
	}
}
