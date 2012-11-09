package co.edu.unicesi.sama.programas;

import javax.ejb.Local;
import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.exception.SamaException;

@Local
public interface ManejoProgramaLocal {

	public String crearPrograma(ProgramaBO programa) throws SamaException;
	
}
