package it.furmax.template.rest;

import java.util.HashSet;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.jboss.logging.Logger;

import it.furmax.template.util.CorsFilter;

@ApplicationPath("/rest")
public class RestApplication extends Application {

	private static Logger log = Logger.getLogger(RestApplication.class.getName());
	private HashSet<CorsFilter> singletons;

	public RestApplication() {
		log.debug("RestApplication - set corsFilter");
		this.singletons = new HashSet<>();
		CorsFilter corsFilter = new CorsFilter();
		corsFilter.getAllowedOrigins().add(" * ");
		corsFilter.setAllowedMethods("OPTIONS, GET, POST, DELETE, PUT, PATCH");
		this.singletons.add(corsFilter);
		log.debug("RestApplication - end");
	}

}