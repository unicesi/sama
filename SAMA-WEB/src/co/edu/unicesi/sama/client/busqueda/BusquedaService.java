package co.edu.unicesi.sama.client.busqueda;

import java.util.ArrayList;


import co.edu.unicesi.sama.bo.BloqueBO;



import co.edu.unicesi.sama.bo.*;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("busquedaService")
public interface BusquedaService extends RemoteService {

	public ArrayList<ProgramaBO> darProgramasOrdenadosPorNombre();
	
	public ArrayList<MateriaBO>  darMateriasOrdenadosPorNombre(String id);

	public ArrayList<BloqueBO> darBloqueporPrograma(ProgramaBO programa);
	
	public ArrayList<MateriaBO> buscarMateriaBloquePorBloque(String busqueda);
	
	public ArrayList<CompetenciaTerminalBO> buscarCompetenciaPorPrograma(String busqueda,String programa);
	
	public ArrayList<CompetenciaEspecificaBO> buscarLineaDeCompetenciaPorCompetencia(String programa, String competencias);
}
