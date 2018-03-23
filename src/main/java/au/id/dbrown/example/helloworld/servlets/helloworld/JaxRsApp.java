package au.id.dbrown.example.helloworld.servlets.helloworld;

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
public class JaxRsApp extends ResourceConfig {

	public JaxRsApp() {
		System.out.println("HelloJsonApp Contruct");
		packages(this.getClass().getPackage().getName());
	}

}