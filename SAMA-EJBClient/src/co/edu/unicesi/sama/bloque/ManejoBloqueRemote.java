package co.edu.unicesi.sama.bloque;

import javax.ejb.Remote;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.exception.SamaException;

@Remote
public interface ManejoBloqueRemote {
	
	public String crearBloque(String programa, BloqueBO bloque) throws SamaException;

}
