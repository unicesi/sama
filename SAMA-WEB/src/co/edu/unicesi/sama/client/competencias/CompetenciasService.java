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

	

	public String crearLinea(String linea, String programa);
	public String eliminarLinea(String linea, String programa);
	

}
