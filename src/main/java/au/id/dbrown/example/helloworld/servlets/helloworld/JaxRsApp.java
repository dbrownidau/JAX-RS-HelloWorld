package au.id.dbrown.example.helloworld.servlets.helloworld;

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
public class JaxRsApp extends Application {
	private final Set<Class<?>> classes;

	public JaxRsApp() {
		HashSet<Class<?>> c = new HashSet<Class<?>>();
		c.add(HelloWorld.class);
		classes = Collections.unmodifiableSet(c);
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

}