package archimedes.backend.crudjpa.data;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 
 *
 * @author ollie (22.06.2020)
 */
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
public class ElementValuePairData {

	private String name;
	private String value;

}