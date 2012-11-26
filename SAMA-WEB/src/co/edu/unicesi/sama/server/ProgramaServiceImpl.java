package co.edu.unicesi.sama.server;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.client.programas.ProgramaService;
import co.edu.unicesi.sama.programas.ManejoProgramaRemote;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class ProgramaServiceImpl extends RemoteServiceServlet implements ProgramaService{

	private ManejoProgramaRemote programasRemote;
	protected InitialContext context;
	
	public ProgramaServiceImpl(){
		
		doLookup();
	}
	
	private void doLookup(){
		
		try{
			
			context = new InitialContext();
			programasRemote = (ManejoProgramaRemote)context.lookup("java:global/SAMA-EAR/SAMA-EJB/ManejoProgramaSession!co.edu.unicesi.sama.programas.ManejoProgramaRemote");
		}catch(NamingException e){
			
			e.printStackTrace();
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String crearPrograma(ProgramaBO programa) {
		try{
			
			return programasRemote.crearPrograma(programa);
			
		}catch(Exception e){
			
			e.printStackTrace();
			return "Error";
		}
	}


}
