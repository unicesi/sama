package co.edu.unicesi.sama.client.asociacionEspecifica;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.ProgramaBO;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AsociacionEspecificaServiceAsync {
	
	public void crearAsociacionBloque(String programa, String bloque, String competencia, int opc, AsyncCallback<String> callback);
	
	public void eliminarAsociacionBloque(String programa, String bloque, String competencia, int opc, AsyncCallback<String> callback);
	
	public void crearAsociacionMateria(String programa, String bloque, String competencia, int opc, AsyncCallback<String> callback);
	
	public void elminarAsociacionMateria(String programa, String bloque, String competencia, int opc, AsyncCallback<String> callback);


}
