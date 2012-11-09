package co.edu.unicesi.sama.programas;

import javax.ejb.Remote;
import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.exception.SamaException;

@Remote
public interface ManejoProgramaRemote {

	public String crearPrograma(ProgramaBO programa) throws SamaException;
}
