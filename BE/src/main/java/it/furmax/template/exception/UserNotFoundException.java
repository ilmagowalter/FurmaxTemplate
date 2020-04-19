package it.furmax.template.exception;

public final class UserNotFoundException extends Exception {

	private static final long serialVersionUID = -3006811421673918931L;

	public UserNotFoundException(final Long id) {
		super("" + id);
	}

	public UserNotFoundException(final String username) {
		super("" + username);
	}

	public UserNotFoundException() {
		super("");
	}

}
