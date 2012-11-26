package co.edu.unicesi.sama.client.asociacionEspecifica;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.ProgramaBO;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AsociacionEspecificaServiceAsync {
	
	/**
	 * Este metodo se encarga de crear una asociacion entre una competencia y un bloque.
	 * @param programa - String - id del programa donde se encuentra el bloque.
	 * @param bloque - String - id del bloque al que se le quiere asociar una competencia.
	 * @param competencia - String - id de la competencia que se quiere asociar.
	 * @param opc - int - tipo de la asociacion.
	 * @param callback the callback to return String - resultado de la ejecucion del metodo.
	 * @throws SamaException
	 */
	public void crearAsociacionBloque(String programa, String bloque, String competencia, int opc, AsyncCallback<String> callback);
	
	/**
	 * Este metodo se encarga de eliminar una asociacion entre una competencia y un bloque.
	 * @param programa - String - id del programa donde se encuentra el bloque.
	 * @param bloque - String - id del bloque al que se le quiere desasociar una competencia.
	 * @param competencia - String - id de la competencia que se quiere desasociar.
	 * @param opc - int - tipo de la asociacion que se quiere eliminar.
	 * @param callback the callback to return String - resultado de la ejecucion del metodo.
	 * @throws SamaException
	 */
	public void eliminarAsociacionBloque(String programa, String bloque, String competencia, int opc, AsyncCallback<String> callback);
	
	/**
	 * Este metodo se encarga de crear una asociacion entre una competencia y una materia.
	 * @param programa - String - id del programa donde se encuentra el bloque.
	 * @param bloque - String - id del bloque.
	 * @param competencia - String - id de la competencia que se quiere asociar.
	 * @param opc - int - tipo de la asociacion.
	 * @param callback the callback to return String - resultado de la ejecucion del metodo.
	 * @throws SamaException
	 */
	public void crearAsociacionMateria(String programa, String bloque, String competencia, int opc, AsyncCallback<String> callback);
	
	/**
	 * Este metodo se encarga de eliminar una asociacion entre una competencia y una materia.
	 * @param programa - String - id del programa donde se encuentra el bloque.
	 * @param bloque - String - id del bloque.
	 * @param competencia - String - id de la competencia que se quiere desasociar.
	 * @param opc - int - tipo de la asociacion que se quiere eliminar.
	 * @param callback the callback to return String - resultado de la ejecucion del metodo.
	 * @throws SamaException
	 */
	public void elminarAsociacionMateria(String programa, String bloque, String competencia, int opc, AsyncCallback<String> callback);


}
