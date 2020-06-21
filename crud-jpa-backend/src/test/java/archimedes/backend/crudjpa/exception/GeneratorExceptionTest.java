package archimedes.backend.crudjpa.exception;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

public class GeneratorExceptionTest {

	private static final RuntimeException CAUSE = new RuntimeException();
	private static final String MESSAGE = "message";

	private GeneratorException unitUnderTest = new GeneratorException(MESSAGE, CAUSE);

	@Test
	public void constructorSetsCauseCorrectly() {
		assertThat(this.unitUnderTest.getCause(), equalTo(CAUSE));
	}

	@Test
	public void constructorSetsMessageCorrectly() {
		assertThat(this.unitUnderTest.getMessage(), equalTo(MESSAGE));
	}

	@Test
	public void constructorWithMessageOnlySetsMessageCorrectly() {
		unitUnderTest = new GeneratorException(MESSAGE);
		assertThat(this.unitUnderTest.getMessage(), equalTo(MESSAGE));
	}

}