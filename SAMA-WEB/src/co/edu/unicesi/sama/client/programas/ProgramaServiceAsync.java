package co.edu.unicesi.sama.client.programas;

import java.util.List;

import co.edu.unicesi.sama.bo.ProgramaBO;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ProgramaServiceAsync{

	/**
     * Este método se encarga de crear un nuevo programa apartir de un BussinesObject de un programa.
     * @param programa -ProgramaBO- es el BO del programa que se desea crear.
     */
	public void crearPrograma (ProgramaBO programa, AsyncCallback<String> callback);

}
