package co.edu.unicesi.sama.client.programas;

import java.util.List;

import co.edu.unicesi.sama.bo.ProgramaBO;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("programaService")
public interface ProgramaService extends RemoteService{

	public String crearPrograma (ProgramaBO programa);

}
