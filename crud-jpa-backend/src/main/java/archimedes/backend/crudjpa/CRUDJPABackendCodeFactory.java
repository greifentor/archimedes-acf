package archimedes.backend.crudjpa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.ollie.archimedes.alexandrian.service.so.DatabaseSO;

/**
 * A code factory for a CRUD JPA backend.
 * 
 * @author ollie (20.06.2020)
 *
 */
public class CRUDJPABackendCodeFactory {

	static Logger log = LogManager.getLogger(CRUDJPABackendCodeFactory.class);

	/**
	 * Generates the code for the CRUD JPA backend.
	 * 
	 * @param targetPath The name of the path where the code should be written into.
	 * @param model      The database model which the code is to create for.
	 * @return "true" if the generation process is successful, otherwise "false".
	 */
	public boolean generate(String targetPath, DatabaseSO database) {
		log.info("backend factory called.");
		return false;
	}

}