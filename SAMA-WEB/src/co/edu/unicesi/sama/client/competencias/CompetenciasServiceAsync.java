package co.edu.unicesi.sama.client.competencias;

import java.util.List;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.BloquesMateriaPKBO;
import co.edu.unicesi.sama.bo.MateriaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CompetenciasServiceAsync{
	
	/**
	 * Este metodo se encarga de asociar una linea de competencias profesionales a un programa.
	 * @param linea - String - id de la linea de competencias profesionales.
	 * @param programa - String - id del programa al que se le desea asociar la linea de competencias profesionales.	 
	 */
	public void crearLinea(String linea, String programa, AsyncCallback<String> callback);
	
	/**
	 * Este metodo se encarga de desasociar una linea de competencias profesionales a un programa.
	 * @param linea - String - id de la linea de competencias profesionales.
	 * @param programa - String - id del programa al que se le desea asociar la linea de competencias profesionales.	 
	 */
	public void eliminarLinea(String linea, String programa, AsyncCallback<String> callback);
	

}
