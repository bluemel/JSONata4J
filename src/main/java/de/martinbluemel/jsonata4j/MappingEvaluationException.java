package de.martinbluemel.jsonata4j;

public class MappingEvaluationException extends MappingException {

	private static final long serialVersionUID = 1L;

	public MappingEvaluationException() {
	}

	public MappingEvaluationException(String message) {
		super(message);
	}

	public MappingEvaluationException(Throwable cause) {
		super(cause);
	}

	public MappingEvaluationException(String message, Throwable cause) {
		super(message, cause);
	}

	public MappingEvaluationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
