package co.edu.unicesi.sama.client.asociacionEspecifica;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.exception.SamaException;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("asociacionEspecificaService")
public interface AsociacionEspecificaService extends RemoteService {
	
	public String crearAsociacionBloque(String programa, String bloque, String competencia, int opc) throws SamaException;
	
	public String eliminarAsociacionBloque(String programa, String bloque, String competencia, int opc) throws SamaException;
	
	public String crearAsociacionMateria(String programa, String bloque, String competencia, int opc) throws SamaException;
	
	public String elminarAsociacionMateria(String programa, String bloque, String competencia, int opc) throws SamaException;


}
