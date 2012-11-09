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


@SuppressWarnings("serial")
public class BloqueServiceImpl extends RemoteServiceServlet implements BloqueService {

	private ManejoBloqueRemote bloquesRemote;
	protected InitialContext context;
	
	public BloqueServiceImpl() {
		
		doLookup();
	}
	
	private void doLookup(){
		
		try {
			context = new InitialContext();
			bloquesRemote = (ManejoBloqueRemote)context.lookup("java:global/SAMA-EAR/SAMA-EJB/ManejoBloqueSession!co.edu.unicesi.sama.bloque.ManejoBloqueRemote");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String crearBloque(String programa, BloqueBO bloque) {
		try{
			bloquesRemote.getClass();
			return bloquesRemote.crearBloque(programa, bloque);
		}catch(Exception e){
			
			e.printStackTrace();
			return "Error";
			
		}

	}

}

