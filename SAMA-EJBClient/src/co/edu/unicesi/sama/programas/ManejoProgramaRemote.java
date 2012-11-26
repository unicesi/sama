package co.edu.unicesi.sama.programas;

import javax.ejb.Remote;
import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.exception.SamaException;

@Remote
public interface ManejoProgramaRemote {

	/**
     * Este método se encarga de crear un nuevo programa apartir de un BussinesObject de un programa.
     * @param programa -ProgramaBO- es el BO del programa que se desea crear.
     * @return String indicando el resultado de la ejecucion del método.
     * @throws SamaException cuando el programa que se desea crear ya existe.
     */
	public String crearPrograma(ProgramaBO programa) throws SamaException;
}
