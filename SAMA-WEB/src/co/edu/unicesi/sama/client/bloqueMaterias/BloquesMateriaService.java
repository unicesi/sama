package co.edu.unicesi.sama.client.bloqueMaterias;

import java.util.List;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.BloquesMateriaPKBO;
import co.edu.unicesi.sama.bo.MateriaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("bloquesMateriaService")
public interface BloquesMateriaService extends RemoteService{

	/**
     * Este metodo se encarga de asociar una materia a un bloque de materias.
     * @param bloque - String - id del bloque al que se le quiere asociar la materia.
     * @param materia - String - id de la materia que se quiere asociar.
     * @return String - resultado de la ejecucion del metodo.     
     */
	public String crearBloquesMateria(String bloque, String materia);
	
	/**
     * Este metodo se encarga de desasociar una materia de un bloque de materias.
     * @param bloque - String con el id del bloque al que se le quiere desasociar una materia.
     * @param materia - String con el id de la materia que se quiere desasociar.
     * @return String con el resultado de la ejecucion del metodo.          
     */
	public String eliminarBloquesMateria(String bloque, String materia);

}
