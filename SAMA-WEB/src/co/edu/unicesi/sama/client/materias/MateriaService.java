package co.edu.unicesi.sama.client.materias;

import java.util.List;

import co.edu.unicesi.sama.bo.MateriaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("materiaService")
public interface MateriaService extends RemoteService{

	/**
	 * Este método se encarga de crear una nueva materia a partir de un Bussines Object de una materia.
	 * @param materia - MateriaBO - es el BO de la materia que se desea crear.
	 * @return String indicando el resultado de la ejecucion del método. 
	 */
	public String crearMateria (MateriaBO materia);
	

}
