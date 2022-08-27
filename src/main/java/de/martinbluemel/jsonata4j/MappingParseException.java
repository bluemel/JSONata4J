package de.martinbluemel.jsonata4j;

public class MappingParseException extends MappingException {

	private static final long serialVersionUID = 1L;

	public MappingParseException() {
	}

	public MappingParseException(String message) {
		super(message);
	}

	public MappingParseException(Throwable cause) {
		super(cause);
	}

	public MappingParseException(String message, Throwable cause) {
		super(message, cause);
	}

	public MappingParseException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
