package it.furmax.template.exception;

public final class UserNotEnabledException extends Exception {

	private static final long serialVersionUID = 2222572883389453488L;

	public UserNotEnabledException(final String username) {
		super(username);
	}

}
