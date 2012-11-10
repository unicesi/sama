package co.edu.unicesi.sama.busqueda;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.BloquesMateriaPKBO;
import co.edu.unicesi.sama.bo.CompetenciaTerminalBO;
import co.edu.unicesi.sama.bo.CompetenciaEspecificaBO;
import co.edu.unicesi.sama.bo.MateriaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;

@Local
public interface BusquedaServiceLocal {

	public ArrayList<ProgramaBO> darProgramasOrdenadosPorNombre();

	public ArrayList<MateriaBO> darMateriasOrdenadosPorNombre(String busqueda);
	
	public ArrayList<BloqueBO> darBloqueporPrograma(ProgramaBO programa);
	
	public List<BloqueBO> buscarMateriaBloquePorBloque(String busqueda);
	
	public ArrayList<CompetenciaTerminalBO> buscarCompetenciaPorPrograma(String busqueda, String programa);
	
	public ArrayList<CompetenciaEspecificaBO> buscarLineaDeCompetenciaPorCompetencia(String programa, String competencias);

	
}
