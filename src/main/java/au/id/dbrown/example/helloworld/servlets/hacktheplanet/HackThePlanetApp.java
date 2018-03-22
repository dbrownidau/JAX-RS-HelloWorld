package au.id.dbrown.example.helloworld.servlets.hacktheplanet;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * @author Damion Brown (dbrown) <the@dbrown.id.au>
 * 
 * Borrows heavily from https://github.com/jersey/jersey/blob/master/examples/helloworld-pure-jax-rs/src/main/java/org/glassfish/jersey/examples/helloworld/jaxrs/JaxRsApplication.java
 *
 */
@ApplicationPath("/")
public class HackThePlanetApp extends Application {
	private final Set<Class<?>> classes;

	public HackThePlanetApp() {
		HashSet<Class<?>> c = new HashSet<Class<?>>();
		c.add(HackThePlanet.class);
		classes = Collections.unmodifiableSet(c);
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

}