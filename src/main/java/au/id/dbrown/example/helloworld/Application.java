package au.id.dbrown.example.helloworld;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.sun.jersey.spi.container.servlet.ServletContainer;

import au.id.dbrown.example.helloworld.servlets.hellojson.HelloJsonApp;
import au.id.dbrown.example.helloworld.servlets.helloworld.JaxRsApp;

/**
 * @author Damion Brown (dbrown) <the@dbrown.id.au>
 *
 */
public class Application {

	static Server startServer() throws IOException {

		// Construct a server
		final Server server = new Server(new InetSocketAddress("localhost", 8080));

		ServletContextHandler handler = new ServletContextHandler();
		ServletHolder helloWorldServlet = new ServletHolder(new ServletContainer(new JaxRsApp()));
		// The Jetty ServletHolder contains a Jersey ServletContainer
		// the Jersey ServletContainer contains a JAX-RS Application.
		ServletHolder helloJsonServlet = new ServletHolder(new ServletContainer(new HelloJsonApp()));

		// Required symbol '*' grants scope to servlet application.
		handler.addServlet(helloWorldServlet, "/app1/*");
		handler.addServlet(helloJsonServlet, "/app2/*");

		server.setHandler(handler);

		// start the server
		try {
			server.start();
			server.join();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Shutdown
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					server.stop();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}));
		return server;
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("JAX-RS Servlets by Jetty via Jersey, Hello World Example!");

		startServer();

		System.out.println("Application started.");
		System.out.println("Try accessing " + getBaseURI() + "/app1/helloworld in the browser.");

		Thread.currentThread().join();
	}

	public static URI getBaseURI() {
		return UriBuilder.fromUri("http://127.0.0.1/").port(8080).build();
	}
}