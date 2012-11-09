package co.edu.unicesi.sama.client.programas;

import java.util.List;

import co.edu.unicesi.sama.bo.ProgramaBO;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ProgramaServiceAsync{

	public void crearPrograma (ProgramaBO programa, AsyncCallback<String> callback);

}
