package co.edu.unicesi.sama.client.bloqueMaterias;

import java.util.List;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.BloquesMateriaPKBO;
import co.edu.unicesi.sama.bo.MateriaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface BloquesMateriaServiceAsync{

	

	public void crearBloquesMateria(String bloque, String materia, AsyncCallback<String> callback);
	public void eliminarBloquesMateria(String bloque, String materia, AsyncCallback<String> callback);

}
