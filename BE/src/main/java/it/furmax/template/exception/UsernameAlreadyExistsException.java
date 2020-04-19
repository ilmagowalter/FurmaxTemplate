package it.furmax.template.exception;

public final class UsernameAlreadyExistsException extends Exception {

	private static final long serialVersionUID = -6732777564006440326L;

	public UsernameAlreadyExistsException(final String username) {
		super(username);
	}

}
