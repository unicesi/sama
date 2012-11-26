package co.edu.unicesi.sama.client.bloques;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.ProgramaBO;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface BloqueServiceAsync {
	
	/**
	 * Este metodo se encarga de crear un bloque asociado a un programa.
	 * @param programa - String - id del programa al que queda asociado el bloque que se esta creando.
	 * @param bloque - String - id del Bussines Object del bloque que se va a crear.
	 * @param callback the callback to return String - resultado de la ejecucion del metodo.	 
	 */
	public void crearBloque (String programa, BloqueBO bloque, AsyncCallback<String> callback);

}
