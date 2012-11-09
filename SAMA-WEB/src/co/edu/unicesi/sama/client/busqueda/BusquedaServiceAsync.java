package co.edu.unicesi.sama.client.busqueda;

import java.util.ArrayList;


import co.edu.unicesi.sama.bo.BloqueBO;

import co.edu.unicesi.sama.bo.CompetenciaBO;
import co.edu.unicesi.sama.bo.LineaCompetenciaBO;
import co.edu.unicesi.sama.bo.MateriaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface BusquedaServiceAsync {

	public void darProgramasOrdenadosPorNombre(AsyncCallback<ArrayList<ProgramaBO>> callback);
	
	public void  darMateriasOrdenadosPorNombre(String id, AsyncCallback<ArrayList<MateriaBO>> callback);

	public void darBloqueporPrograma(ProgramaBO programa, AsyncCallback<ArrayList<BloqueBO>> callback);
	
	public void buscarMateriaBloquePorBloque(String busqueda, AsyncCallback<ArrayList<MateriaBO>> callback);
	
	public void buscarCompetenciaPorPrograma(String busqueda,String programa, AsyncCallback<ArrayList<CompetenciaBO>> callback);
	
	public void buscarLineaDeCompetenciaPorCompetencia(String programa, String competencias, AsyncCallback<ArrayList<LineaCompetenciaBO>> callback);
}
