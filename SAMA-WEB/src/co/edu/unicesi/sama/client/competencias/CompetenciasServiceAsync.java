package co.edu.unicesi.sama.client.competencias;

import java.util.List;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.BloquesMateriaPKBO;
import co.edu.unicesi.sama.bo.MateriaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CompetenciasServiceAsync{

	

	public void crearLinea(String linea, String programa, AsyncCallback<String> callback);
	public void eliminarLinea(String linea, String programa, AsyncCallback<String> callback);
	

}
