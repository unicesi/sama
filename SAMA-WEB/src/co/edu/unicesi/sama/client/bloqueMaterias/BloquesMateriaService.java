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

	

	public String crearBloquesMateria(String bloque, String materia);
	public String eliminarBloquesMateria(String bloque, String materia);

}
