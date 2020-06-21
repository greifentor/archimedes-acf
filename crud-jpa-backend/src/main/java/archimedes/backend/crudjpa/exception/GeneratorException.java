package archimedes.backend.crudjpa.exception;

/**
 * An exception which could be used as base exception or thrown directly by the code generators.
 *
 * @author ollie (21.06.2020)
 */
public class GeneratorException extends Exception {

	public GeneratorException(String message) {
		super(message);
	}

	public GeneratorException(String message, Throwable cause) {
		super(message, cause);
	}

}