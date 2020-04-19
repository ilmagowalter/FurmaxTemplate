package it.furmax.template.exception;

public final class EmailAlreadyExistsException extends Exception {

	private static final long serialVersionUID = -8579353013639171599L;

	public EmailAlreadyExistsException(final String email) {
		super(email);
	}

}
