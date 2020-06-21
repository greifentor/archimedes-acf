package archimedes.backend.crudjpa.generators.persistence.dbo;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import archimedes.backend.crudjpa.AbstractGenerator;
import archimedes.backend.crudjpa.data.AttributeData;
import archimedes.backend.crudjpa.exception.GeneratorException;
import archimedes.backend.crudjpa.util.NameManager;
import archimedes.backend.crudjpa.util.TypeManager;
import de.ollie.archimedes.alexandrian.service.so.TableSO;

/**
 * A generator for the DBO classes.
 *
 * @author ollie (21.06.2020)
 */
public class DBOClassGenerator extends AbstractGenerator {

	public DBOClassGenerator(NameManager nameManager, TypeManager typeManager) {
		super("DBOClassGenerator", nameManager, typeManager);
	}

	@Override
	public String generate(String templatePath, String basePackageName, TableSO table) throws GeneratorException {
		VelocityEngine velocityEngine = new VelocityEngine();
		velocityEngine.init();
		Template t = velocityEngine.getTemplate(templatePath + "/DBOClass.vm");
		VelocityContext context = new VelocityContext();
		context.put("Attributes", getAttributeData(table));
		context.put("BasePackageName", basePackageName);
		context.put("NamesProvider", this.nameManager.getDBONamesProvider(table));
		context.put("PluralName", this.nameManager.getPluralName(table));
		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		return writer.toString();
	}

	private List<AttributeData> getAttributeData(TableSO table) {
		return new ArrayList<>();
	}

}