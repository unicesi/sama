package co.edu.unicesi.sama.server;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import co.edu.unicesi.sama.bloqueMateria.ManejoBloquesMateriaRemote;
import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.BloquesMateriaPKBO;
import co.edu.unicesi.sama.bo.MateriaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.client.bloqueMaterias.BloquesMateriaService;
import co.edu.unicesi.sama.client.programas.ProgramaService;
import co.edu.unicesi.sama.programas.ManejoProgramaRemote;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class BloquesMateriaServiceImpl extends RemoteServiceServlet implements BloquesMateriaService{

	private ManejoBloquesMateriaRemote bloquesMateriaService;
	protected InitialContext context;
	
	public BloquesMateriaServiceImpl(){
		
		doLookup();
	}
	
	private void doLookup(){
		
		try{
			
			context = new InitialContext();
			bloquesMateriaService = (ManejoBloquesMateriaRemote)context.lookup("java:global/SAMA-EAR/SAMA-EJB/ManejoBloquesMateriaSession!co.edu.unicesi.sama.bloqueMateria.ManejoBloquesMateriaRemote");
		}catch(NamingException e){
			
			e.printStackTrace();
		}
	}
	
	@Override
	public String crearBloquesMateria(String bloque, String materia) {
		try{
			return bloquesMateriaService.crearBloquesMateria(bloque, materia);
		}catch(Exception e){
			e.printStackTrace();
			return "Error";
		}
	}
	
	
	public String eliminarBloquesMateria(String bloque, String materia) {
		try{
			return bloquesMateriaService.eliminarBloquesMateria(bloque, materia);
		}catch(Exception e){
			e.printStackTrace();
			return "Error";
		}
	}


}
