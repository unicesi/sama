package co.edu.unicesi.sama.asociacionEspecifica;

import javax.ejb.Remote;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.exception.SamaException;

/**
 * 
 * Esta interfaz es la que designa el comportamiento para el manejo de las asociaciones de manera remote
 *
 */
@Remote
public interface ManejoAsociacionEspecificaRemote {

	/**
	 * Este metodo se encarga de crear una asociacion entre una competencia y un bloque.
	 * @param programa - String - id del programa donde se encuentra el bloque.
	 * @param bloque - String - id del bloque al que se le quiere asociar una competencia.
	 * @param competencia - String - id de la competencia que se quiere asociar.
	 * @param opc - int - tipo de la asociacion.
	 * @return String - resultado de la ejecucion del metodo.
	 * @throws SamaException
	 */
	public String crearAsociacionBloque(String programa, String bloque, String competencia, int opc) throws SamaException;

	/**
	 * Este metodo se encarga de eliminar una asociacion entre una competencia y un bloque.
	 * @param programa - String - id del programa donde se encuentra el bloque.
	 * @param bloque - String - id del bloque al que se le quiere desasociar una competencia.
	 * @param competencia - String - id de la competencia que se quiere desasociar.
	 * @param opc - int - tipo de la asociacion que se quiere eliminar.
	 * @return String - resultado de la ejecucion del metodo.
	 * @throws SamaException
	 */
	public String eliminarAsociacionBloque(String programa, String bloque, String competencia, int opc) throws SamaException;

	/**
	 * Este metodo se encarga de crear una asociacion entre una competencia y una materia.
	 * @param programa - String - id del programa donde se encuentra el bloque.
	 * @param bloque - String - id del bloque.
	 * @param competencia - String - id de la competencia que se quiere asociar.
	 * @param opc - int - tipo de la asociacion.
	 * @return String - resultado de la ejecucion del metodo.
	 * @throws SamaException
	 */
	public String crearAsociacionMateria(String programa, String bloque, String competencia, int opc) throws SamaException;

	/**
	 * Este metodo se encarga de eliminar una asociacion entre una competencia y una materia.
	 * @param programa - String - id del programa donde se encuentra el bloque.
	 * @param bloque - String - id del bloque.
	 * @param competencia - String - id de la competencia que se quiere desasociar.
	 * @param opc - int - tipo de la asociacion que se quiere eliminar.
	 * @return String - resultado de la ejecucion del metodo.
	 * @throws SamaException
	 */
	public String elminarAsociacionMateria(String programa, String bloque, String competencia, int opc) throws SamaException;

}
