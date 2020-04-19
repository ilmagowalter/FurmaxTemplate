package it.furmax.template;

import org.jboss.logging.Logger;

/**
 * Project constants
 */
public final class MessageConstants {

	private static Logger log = Logger.getLogger(MessageConstants.class.getName());

	private MessageConstants() {
	}

	// Error code
	public static final String ERROR_CODE_GENERIC = "001";

	// User code
	public static final String USER_NOT_AUTHORIZED = "100";
	public static final String USERNAME_ALREADY_EXISTS = "101";
	public static final String EMAIL_ALREADY_EXISTS = "102";
	public static final String USER_NOT_FOUND = "103";

}
