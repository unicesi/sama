package co.edu.unicesi.sama.bloqueMateria;

import javax.ejb.Remote;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.MateriaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.exception.SamaException;

@Remote
public interface ManejoBloquesMateriaRemote {



	public String crearBloquesMateria(String bloque, String materia) throws SamaException;
	public String eliminarBloquesMateria(String bloque, String materia) throws SamaException;
}
