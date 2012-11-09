package co.edu.unicesi.sama.server;

import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import co.edu.unicesi.sama.bloque.ManejoBloqueRemote;
import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.busqueda.BusquedaServiceRemote;
import co.edu.unicesi.sama.client.bloques.BloqueService;
import co.edu.unicesi.sama.client.busqueda.BusquedaService;
import co.edu.unicesi.sama.client.competencias.CompetenciasService;
import co.edu.unicesi.sama.competencias.ManejoCompetenciasRemote;


@SuppressWarnings("serial")
public class CompetenciasServiceImpl extends RemoteServiceServlet implements CompetenciasService {

	private ManejoCompetenciasRemote competenciasRemote;
	protected InitialContext context;
	
	public CompetenciasServiceImpl() {
		
		doLookup();
	}
	
	private void doLookup(){
		
		try {
			context = new InitialContext();
			competenciasRemote = (ManejoCompetenciasRemote)context.lookup("java:global/SAMA-EAR/SAMA-EJB/ManejoCompetenciasSession!co.edu.unicesi.sama.competencias.ManejoCompetenciasRemote");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String crearLinea(String linea, String programa) {
		try{
			
			return competenciasRemote.crearAsociacionLineaProfesional(linea, programa);
		}catch(Exception e){
			
			e.printStackTrace();
			return "Error";
			
		}

	}

	
	public String eliminarLinea(String linea, String programa) {
		try{
			
			return competenciasRemote.eliminarAsociacionLineaProfesional(linea, programa);
		}catch(Exception e){
			
			e.printStackTrace();
			return "Error";
			
		}

	}
}

