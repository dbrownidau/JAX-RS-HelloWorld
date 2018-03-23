package au.id.dbrown.example.helloworld.servlets.hellojson;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author Damion Brown (dbrown) <the@dbrown.id.au>
 * 
 *         Borrows heavily from
 *         https://github.com/nobuoka/jax-rs-jersey-application-sample/blob/master/src/main/java/info/vividcode/web/app/jerseysample/MyApplication.java
 *
 */
@ApplicationPath("/")
public class HelloJsonApp extends ResourceConfig {

	public HelloJsonApp() {
		System.out.println("HelloJsonApp Contruct");
		packages(this.getClass().getPackage().getName());
		/*
		 * com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider
		 * 
		 * Binder for JSON<->POJO, this providers readers and writers for
		 * MediaType.APPLICATION_JSON
		 */
		packages("com.fasterxml.jackson.jaxrs.json");
	}

}