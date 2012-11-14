package co.edu.unicesi.sama.asociacionEspecifica;

import javax.ejb.Remote;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.exception.SamaException;

@Remote
public interface ManejoAsociacionEspecificaRemote {
	
public String crearAsociacionBloque(String programa, String bloque, String competencia, int opc) throws SamaException;
	
	public String eliminarAsociacionBloque(String programa, String bloque, String competencia, int opc) throws SamaException;
	
	public String crearAsociacionMateria(String programa, String bloque, String competencia, int opc) throws SamaException;
	
	public String elminarAsociacionMateria(String programa, String bloque, String competencia, int opc) throws SamaException;

}
