package co.edu.unicesi.sama.competencias;

import javax.ejb.Local;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.MateriaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.exception.SamaException;

@Local
public interface ManejoCompetenciasLocal {

	
	
	
	public String crearAsociacionLineaProfesional(String linea, String programa) throws SamaException;
	public String eliminarAsociacionLineaProfesional(String linea, String programa) throws SamaException;
}
