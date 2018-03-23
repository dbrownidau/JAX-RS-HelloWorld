package au.id.dbrown.example.helloworld.servlets.hellojson;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

/**
 * @author Damion Brown (dbrown) <the@dbrown.id.au>
 * 
 *         Borrows heavily from
 *         https://github.com/jersey/jersey/blob/master/examples/helloworld-pure-jax-rs/src/main/java/org/glassfish/jersey/examples/helloworld/jaxrs/JaxRsApplication.java
 *
 */
@ApplicationPath("/")
public class HelloJsonApp extends Application {
	private final Set<Class<?>> classes;

	public HelloJsonApp() {
		System.out.println("HelloJsonApp Contruct");
		HashSet<Class<?>> c = new HashSet<Class<?>>();
		c.add(HelloJson.class);
		/*
		 * com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider
		 * 
		 * Binder for JSON<->POJO, this providers readers and writers for
		 * MediaType.APPLICATION_JSON
		 */
		c.add(JacksonJsonProvider.class);
		classes = Collections.unmodifiableSet(c);
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

}