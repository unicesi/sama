package co.edu.unicesi.sama.busqueda;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remote;

import co.edu.unicesi.sama.bo.AsociacionEspecificaBO;
import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.BloquesMateriaPKBO;
import co.edu.unicesi.sama.bo.CompetenciaTerminalBO;
import co.edu.unicesi.sama.bo.CompetenciaEspecificaBO;
import co.edu.unicesi.sama.bo.MateriaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;

@Remote
public interface BusquedaServiceRemote {

	public ArrayList<ProgramaBO> darProgramasOrdenadosPorNombre();
		
	public ArrayList<BloqueBO> darBloqueporPrograma(ProgramaBO programa);
	
	public List<BloqueBO> buscarMateriaBloquePorBloque(String busqueda);
	
	public ArrayList<MateriaBO> darMateriasOrdenadosPorNombre(String busqueda);

	public ArrayList<CompetenciaTerminalBO> buscarCompetenciaPorPrograma(String busqueda, String programa);
	
	public ArrayList<CompetenciaEspecificaBO> buscarLineaDeCompetenciaPorCompetencia(String programa, String competencias);
	
	
	
public AsociacionEspecificaBO buscarAsociacionCompetenciaEspecificaMateria (String programa, String bloque, String CompetenciaEspecifica);
	
	public AsociacionEspecificaBO buscarAsociacionCompetenciaEspecificaBloque (String programa, String bloque, String CompetenciaEspecifica);
}
