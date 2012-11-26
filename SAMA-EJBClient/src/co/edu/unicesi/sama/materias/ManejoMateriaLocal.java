package co.edu.unicesi.sama.materias;

import javax.ejb.Local;

import co.edu.unicesi.sama.bo.MateriaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.exception.SamaException;

@Local
public interface ManejoMateriaLocal {

	/**
	 * Este método se encarga de crear una nueva materia a partir de un Bussines Object de una materia.
	 * @param materia - MateriaBO - es el BO de la materia que se desea crear.
	 * @return String indicando el resultado de la ejecucion del método.
	 * @throws SamaException cuando la materia que se desea crear ya existe.
	 */
	public String crearMateria(MateriaBO materia) throws SamaException;

}
