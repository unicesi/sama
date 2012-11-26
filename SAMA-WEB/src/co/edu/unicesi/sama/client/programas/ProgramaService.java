package co.edu.unicesi.sama.client.programas;

import java.util.List;

import co.edu.unicesi.sama.bo.ProgramaBO;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("programaService")
public interface ProgramaService extends RemoteService{

	/**
     * Este método se encarga de crear un nuevo programa apartir de un BussinesObject de un programa.
     * @param programa -ProgramaBO- es el BO del programa que se desea crear.
     */
	public String crearPrograma (ProgramaBO programa);

}
