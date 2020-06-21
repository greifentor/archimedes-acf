package archimedes.backend.crudjpa.data;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * A container for an annotation.
 *
 * @author ollie (22.06.2020)
 */
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
public class AnnotationData {

	private String name;
	private String value;
	private List<ElementValuePairData> elementValuePairs = new ArrayList<>();

}