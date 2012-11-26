package co.edu.unicesi.sama.bloque;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.exception.SamaException;
import javax.ejb.Local;

/**
 * 
 * Esta interfaz es la que designa el comportamiento para el manejo de bloques de manera local
 *
 */
@Local
public interface ManejoBloqueLocal {
	
	/**
	 * Este metodo se encarga de crear un bloque asociado a un programa.
	 * @param programa - String - id del programa al que queda asociado el bloque que se esta creando.
	 * @param bloque - String - id del Bussines Object del bloque que se va a crear.
	 * @return String indicando el resultado de la ejecucion de este metodo.
	 * @throws SamaException cuando el programa al que se le va a asociar el bloque que se va a crear no existe.
	 * @throws SamaException cuando el bloque que se quiere crear ya existe.
	 */
	public String crearBloque(String programa, BloqueBO bloque) throws SamaException;

}
