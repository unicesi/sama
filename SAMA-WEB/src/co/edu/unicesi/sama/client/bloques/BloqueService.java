package co.edu.unicesi.sama.client.bloques;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.ProgramaBO;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("bloqueService")
public interface BloqueService extends RemoteService {
	
	public String crearBloque (String programa, BloqueBO bloque);

}
