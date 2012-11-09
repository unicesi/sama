package co.edu.unicesi.sama.client.bloques;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.ProgramaBO;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface BloqueServiceAsync {
	
	public void crearBloque (String programa, BloqueBO bloque, AsyncCallback<String> callback);

}
