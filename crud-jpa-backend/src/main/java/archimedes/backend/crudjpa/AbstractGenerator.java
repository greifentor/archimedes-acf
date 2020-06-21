package archimedes.backend.crudjpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import archimedes.backend.crudjpa.exception.GeneratorException;
import archimedes.backend.crudjpa.util.NameManager;
import archimedes.backend.crudjpa.util.TypeManager;
import de.ollie.archimedes.alexandrian.service.so.ColumnSO;
import de.ollie.archimedes.alexandrian.service.so.TableSO;

/**
 * 
 *
 * @author ollie (21.06.2020)
 */
abstract public class AbstractGenerator { // NOSONAR

	protected final NameManager nameManager;
	protected final TypeManager typeManager;

	private final String name;

	public AbstractGenerator(String name, NameManager nameManager, TypeManager typeManager) {
		super();
		this.name = name;
		this.nameManager = nameManager;
		this.typeManager = typeManager;
	}

	abstract public String generate(String templatePath, String basePackageName, TableSO table) // NOSONAR
			throws GeneratorException;

	public Set<String> getGenerationTypes() {
		return new HashSet<>();
	}

	public String getName() {
		return this.name;
	}

	protected Optional<TableSO> getReferencedTable(ColumnSO column) {
		return column.getTable().getForeignKeys() //
				.stream() //
				.flatMap(fk -> fk.getReferences().stream()) //
				.filter(r -> r.getReferencingColumn() == column) //
				.map(r -> r.getReferencedColumn().getTable()) //
				.findAny() //
		;
	}

}