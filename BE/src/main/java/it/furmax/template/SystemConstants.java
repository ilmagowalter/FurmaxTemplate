package it.furmax.template;

import org.jboss.logging.Logger;

/**
 * Project constants
 */
public final class SystemConstants {

	private static Logger log = Logger.getLogger(SystemConstants.class.getName());

	private SystemConstants() {
	}

	public static final String JWT_KEYSTORE_DIR = System.getProperty("chiave.jwt.keystore.dir", "");

	// Pagination constants
	public static final Long PAGINATION_PAGE_MAX_SIZE = 300L;

}
