package co.edu.unicesi.sama.server;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.BloquesMateriaPKBO;
import co.edu.unicesi.sama.bo.CompetenciaBO;
import co.edu.unicesi.sama.bo.LineaCompetenciaBO;
import co.edu.unicesi.sama.bo.MateriaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.busqueda.BusquedaServiceRemote;
import co.edu.unicesi.sama.client.busqueda.BusquedaService;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class BusquedaServiceImpl extends RemoteServiceServlet implements
		BusquedaService {

	private BusquedaServiceRemote busquedaRemote;
	protected InitialContext context;

	public BusquedaServiceImpl() {

		doLookup();
	}

	private void doLookup() {

		try {
			context = new InitialContext();
			busquedaRemote = (BusquedaServiceRemote) context
					.lookup("java:global/SAMA-EAR/SAMA-EJB/BusquedaSession!co.edu.unicesi.sama.busqueda.BusquedaServiceRemote");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<ProgramaBO> darProgramasOrdenadosPorNombre() {
		try {

			return busquedaRemote.darProgramasOrdenadosPorNombre();
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}

	@Override
	public ArrayList<MateriaBO> darMateriasOrdenadosPorNombre(String busqueda) {
		try {

			return busquedaRemote.darMateriasOrdenadosPorNombre(busqueda);
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}


	@Override
	public ArrayList<BloqueBO> darBloqueporPrograma(ProgramaBO programa) {
		
		try{
			
			return busquedaRemote.darBloqueporPrograma(programa);
		}catch(Exception e){
			
			return null;
		}
		
		
	}

	@Override
	public ArrayList<MateriaBO> buscarMateriaBloquePorBloque(String busqueda) {
		try{
			
			return (ArrayList<MateriaBO>) busquedaRemote.buscarMateriaBloquePorBloque(busqueda).get(0).getMaterias();
		}catch(Exception e){
			
			return null;
		}
	}

	@Override
	public ArrayList<CompetenciaBO> buscarCompetenciaPorPrograma(String busqueda, String programa) {
		// TODO Auto-generated method stub
	try{
			
			return (ArrayList<CompetenciaBO>) busquedaRemote.buscarCompetenciaPorPrograma(busqueda, programa);
		}catch(Exception e){
			
			return null;
		}
	}

	@Override
	public ArrayList<LineaCompetenciaBO> buscarLineaDeCompetenciaPorCompetencia(String programa, String competencias) {
try{
			
			return (ArrayList<LineaCompetenciaBO>) busquedaRemote.buscarLineaDeCompetenciaPorCompetencia(programa, competencias);
		}catch(Exception e){
			
			return null;
		}
	}



}
