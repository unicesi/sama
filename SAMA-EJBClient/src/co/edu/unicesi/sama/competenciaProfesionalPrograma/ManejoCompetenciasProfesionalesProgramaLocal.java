package co.edu.unicesi.sama.competenciaProfesionalPrograma;

import javax.ejb.Local;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.BloquesMateriaPKBO;
import co.edu.unicesi.sama.bo.MateriaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.exception.SamaException;

@Local
public interface ManejoCompetenciasProfesionalesProgramaLocal {

	
	
	
	public String asociarCompetenciaPrograma(String idCompetencia, String programa) throws SamaException;
	public String desasociarCompetenciaPrograma(String idCompetencia) throws SamaException;
	
}
