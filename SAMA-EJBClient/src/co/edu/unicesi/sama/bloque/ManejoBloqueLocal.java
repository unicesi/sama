package co.edu.unicesi.sama.bloque;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.exception.SamaException;
import javax.ejb.Local;

@Local
public interface ManejoBloqueLocal {
	
	public String crearBloque(String programa, BloqueBO bloque) throws SamaException;

}
