package co.edu.unicesi.sama.client.bloqueMaterias;

import java.util.List;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.BloquesMateriaPKBO;
import co.edu.unicesi.sama.bo.MateriaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface BloquesMateriaServiceAsync{

	/**
     * Este metodo se encarga de asociar una materia a un bloque de materias.
     * @param bloque - String - id del bloque al que se le quiere asociar la materia.
     * @param materia - String - id de la materia que se quiere asociar.
     * @param callback the callback to return String - resultado de la ejecucion del metodo.     
     */
	public void crearBloquesMateria(String bloque, String materia, AsyncCallback<String> callback);
	
	/**
     * Este metodo se encarga de desasociar una materia de un bloque de materias.
     * @param bloque - String con el id del bloque al que se le quiere desasociar una materia.
     * @param materia - String con el id de la materia que se quiere desasociar.
     * @param callback the callback to return String con el resultado de la ejecucion del metodo.          
     */
	public void eliminarBloquesMateria(String bloque, String materia, AsyncCallback<String> callback);

}
