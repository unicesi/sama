package co.edu.unicesi.sama.competencias;

import javax.ejb.Remote;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.MateriaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.exception.SamaException;

@Remote
public interface ManejoCompetenciasRemote {
	
	/**
	 * Este metodo se encarga de asociar una linea de competencias profesionales a un programa.
	 * @param linea - String - id de la linea de competencias profesionales.
	 * @param programa - String - id del programa al que se le desea asociar la linea de competencias profesionales.
	 * @return String con el resultado de la ejecucion del metodo.
	 * @throws SamaException - cuando la linea de competencias profesionales ya esta asociada.
	 * @throws SamaException - cuando la linea de competencias profesionales no exista.
	 * @throws SamaException - cuando el programa no exista.
	 */
	public String crearAsociacionLineaProfesional(String linea, String programa) throws SamaException;
	
	/**
	 * Este metodo se encarga de desasociar una linea de competencias profesionales a un programa.
	 * @param linea - String - id de la linea de competencias profesionales.
	 * @param programa - String - id del programa al que se le desea desasociar la linea de competencias profesionales.
	 * @return String con el resultado de la ejecucion del metodo.
	 * @throws SamaException - cuando la linea de competencias profesionales ya esta desasociada.
	 * @throws SamaException - cuando la linea de competencias profesionales no exista.
	 * @throws SamaException - cuando el programa no exista.
	 */
	public String eliminarAsociacionLineaProfesional(String linea, String programa) throws SamaException;
}
