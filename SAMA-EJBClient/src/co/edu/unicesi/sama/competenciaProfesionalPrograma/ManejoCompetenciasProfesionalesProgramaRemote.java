package co.edu.unicesi.sama.competenciaProfesionalPrograma;

import javax.ejb.Remote;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.BloquesMateriaPKBO;
import co.edu.unicesi.sama.bo.MateriaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.exception.SamaException;

/**
 * Esta interfaz provee los metodos para asociar y desasociar competencias con programas de manera remota
 */
@Remote
public interface ManejoCompetenciasProfesionalesProgramaRemote {

	/**
	 * Este metodo se encarga de asociar una competencia a un programa.
	 * @param idCompetencia - String - id de la competencia que se quiere asociar.
	 * @param programa - String - id del programa al que se le quiere asociar la competencia.
	 * @return String con el estado de la ejecucion del metodo.
	 * @throws SamaException - Se lanza la excepcion cuando la competencia o el programa que se desean asociar no existen.
	 * @throws SamaException - Se lanza cuando la competencia ya esta asociado al programa.
	 */
	public String asociarCompetenciaPrograma(String idCompetencia, String programa) throws SamaException;
	
	/**
	 * Este metodo se encarga de desasociar una competencia a un programa.
	 * @param idCompetencia - String - id de la competencia que se quiere desasociar.
	 * @param programa - String - id del programa al que se le quiere desasociar la competencia.
	 * @return String con el estado de la ejecucion del metodo.
	 * @throws SamaException - Se lanza la excepcion cuando la competencia o el programa que se desean asociar no existen.
	 * @throws SamaException - Se lanza cuando la competencia ya esta desasociado al programa.
	 */
	public String desasociarCompetenciaPrograma(String idCompetencia) throws SamaException;
}
