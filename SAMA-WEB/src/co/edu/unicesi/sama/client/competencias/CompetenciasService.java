package co.edu.unicesi.sama.client.competencias;

import java.util.List;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.BloquesMateriaPKBO;
import co.edu.unicesi.sama.bo.MateriaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("competenciasService")
public interface CompetenciasService extends RemoteService{
	
	/**
	 * Este metodo se encarga de asociar una linea de competencias profesionales a un programa.
	 * @param linea - String - id de la linea de competencias profesionales.
	 * @param programa - String - id del programa al que se le desea asociar la linea de competencias profesionales.	 
	 */
	public String crearLinea(String linea, String programa);
	
	/**
	 * Este metodo se encarga de desasociar una linea de competencias profesionales a un programa.
	 * @param linea - String - id de la linea de competencias profesionales.
	 * @param programa - String - id del programa al que se le desea asociar la linea de competencias profesionales.	 
	 */
	public String eliminarLinea(String linea, String programa);
	

}
