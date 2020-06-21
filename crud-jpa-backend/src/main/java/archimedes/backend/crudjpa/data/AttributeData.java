package archimedes.backend.crudjpa.data;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * A container for attribute data.
 *
 * @author ollie (21.06.2020)
 */
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
public class AttributeData {

	private String name;
	private String javaTypeName;
	private List<AnnotationData> annotations = new ArrayList<>();

}