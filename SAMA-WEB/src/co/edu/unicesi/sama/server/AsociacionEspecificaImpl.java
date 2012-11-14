package co.edu.unicesi.sama.server;

import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import co.edu.unicesi.sama.asociacionEspecifica.ManejoAsociacionEspecificaRemote;
import co.edu.unicesi.sama.bloque.ManejoBloqueRemote;
import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.busqueda.BusquedaServiceRemote;
import co.edu.unicesi.sama.client.asociacionEspecifica.AsociacionEspecificaService;
import co.edu.unicesi.sama.client.bloques.BloqueService;
import co.edu.unicesi.sama.client.busqueda.BusquedaService;
import co.edu.unicesi.sama.exception.SamaException;


@SuppressWarnings("serial")
public class AsociacionEspecificaImpl extends RemoteServiceServlet implements AsociacionEspecificaService {

	private ManejoAsociacionEspecificaRemote asociacionRemote;
	protected InitialContext context;
	
	public AsociacionEspecificaImpl() {
		
		doLookup();
	}
	
	private void doLookup(){
		
		try {
			context = new InitialContext();
			asociacionRemote = (ManejoAsociacionEspecificaRemote)context.lookup("java:global/SAMA-EAR/SAMA-EJB/ManejoAsociacionEspecificaSession!co.edu.unicesi.sama.asociacionEspecifica.ManejoAsociacionEspecificaRemote");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Override
	public String elminarAsociacionMateria(String programa, String bloque,
			String competencia, int opc) throws SamaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String crearAsociacionBloque(String programa, String bloque,
			String competencia, int opc) throws SamaException {
		// TODO Auto-generated method stub

		try{
			return asociacionRemote.crearAsociacionBloque(programa, bloque, competencia, opc);
		}catch(Exception e){
			e.printStackTrace();
			return "Error";
		}
	}

	@Override
	public String eliminarAsociacionBloque(String programa, String bloque,
			String competencia, int opc) throws SamaException {
		// TODO Auto-generated method stub
	return null;	
	
	}

	@Override
	public String crearAsociacionMateria(String programa, String bloque,
			String competencia, int opc) throws SamaException {
		// TODO Auto-generated method stub
		try{
			return asociacionRemote.crearAsociacionMateria(programa, bloque, competencia, opc);
		}catch(Exception e){
			e.printStackTrace();
			return "Error";
		}
	}



}

