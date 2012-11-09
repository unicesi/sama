package co.edu.unicesi.sama.client.materias;

import java.util.List;

import co.edu.unicesi.sama.bo.MateriaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MateriaServiceAsync{

	public void crearMateria (MateriaBO materia, AsyncCallback<String> callback);
	

}
