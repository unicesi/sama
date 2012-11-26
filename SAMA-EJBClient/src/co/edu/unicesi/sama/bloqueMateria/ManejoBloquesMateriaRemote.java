package co.edu.unicesi.sama.bloqueMateria;

import javax.ejb.Remote;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.MateriaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.exception.SamaException;

/**
 * Esta interfaz es la que designa el comportamiento para el manejo de bloquesMateria de manera remota 
 */
@Remote
public interface ManejoBloquesMateriaRemote {

	/**
     * Este metodo se encarga de asociar una materia a un bloque de materias.
     * @param bloque - String - id del bloque al que se le quiere asociar la materia.
     * @param materia - String - id de la materia que se quiere asociar.
     * @return String - resultado de la ejecucion del metodo.
     * @throws SamaException cuando la materia que se desea asociar ya esta asociada.
     * @throws SamaException cuando la materia que se quiere asociar ya existe.
     * @throws SamaException cuando el bloque al que se le quiere asociar la materia no existen. 
     */
	public String crearBloquesMateria(String bloque, String materia) throws SamaException;
	
	/**
     * Este metodo se encarga de desasociar una materia de un bloque de materias.
     * @param bloque - String con el id del bloque al que se le quiere desasociar una materia.
     * @param materia - String con el id de la materia que se quiere desasociar.
     * @return String con el resultado de la ejecucion del metodo.
     * @throws SamaException cuando la materia que se desea asociar ya esta asociada.
     * @throws SamaException cuando la materia que se quiere asociar ya existe.
     * @throws SamaException cuando el bloque al que se le quiere asociar la materia no existen.      
     */
	public String eliminarBloquesMateria(String bloque, String materia) throws SamaException;
}
