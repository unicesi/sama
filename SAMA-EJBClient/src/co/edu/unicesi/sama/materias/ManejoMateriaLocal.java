package co.edu.unicesi.sama.materias;

import javax.ejb.Local;

import co.edu.unicesi.sama.bo.MateriaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.exception.SamaException;

@Local
public interface ManejoMateriaLocal {

	public String crearMateria(MateriaBO materia) throws SamaException;

}
