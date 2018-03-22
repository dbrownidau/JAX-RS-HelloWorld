package au.id.dbrown.example.helloworld.servlets.hacktheplanet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Damion Brown (dbrown) <the@dbrown.id.au>
 *
 */
@Path("/")
public class HackThePlanet {
	@GET
	@Path("hacktheplanet")
	@Produces(MediaType.TEXT_PLAIN)
	public String hacktheplanet() {
		return "Hack The Planet!";
	}
}
