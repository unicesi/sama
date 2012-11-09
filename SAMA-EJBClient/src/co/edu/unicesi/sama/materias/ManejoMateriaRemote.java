package co.edu.unicesi.sama.materias;

import javax.ejb.Remote;

import co.edu.unicesi.sama.bo.MateriaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.exception.SamaException;

@Remote
public interface ManejoMateriaRemote {

	
	public String crearMateria(MateriaBO materia) throws SamaException;

	
}
