package co.edu.unicesi.sama.client.materias;

import java.util.List;

import co.edu.unicesi.sama.bo.MateriaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("materiaService")
public interface MateriaService extends RemoteService{

	public String crearMateria (MateriaBO materia);
	

}
