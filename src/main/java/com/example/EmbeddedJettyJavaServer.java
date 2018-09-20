package com.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Run Jetty HTTP server in embedded mode which means that the server shipped together with the application.
 */
public class EmbeddedJettyJavaServer {

	public static void main(String... args) throws Exception {

		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");

		//Running Jetty HTTP server on port 8080. When started, can be accessed from http://localhost:8080/
		Server jettyServer = new Server(8080);
		jettyServer.setHandler(context);

		ServletHolder jerseyServlet = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");
		jerseyServlet.setInitOrder(0);

		jerseyServlet.setInitParameter("jersey.config.server.provider.classnames",Calculator.class.getCanonicalName());

		// Starting Jetty server.
		jettyServer.start();
		jettyServer.join();
	}
}