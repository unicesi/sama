package co.edu.unicesi.sama.server;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import co.edu.unicesi.sama.bo.MateriaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.client.materias.MateriaService;
import co.edu.unicesi.sama.client.programas.ProgramaService;
import co.edu.unicesi.sama.materias.ManejoMateriaRemote;
import co.edu.unicesi.sama.programas.ManejoProgramaRemote;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class MateriaServiceImpl extends RemoteServiceServlet implements MateriaService {

	private ManejoMateriaRemote materiasRemote;
	protected InitialContext context;

	public MateriaServiceImpl() {

		doLookup();
	}

	private void doLookup() {

		try {

			context = new InitialContext();
			materiasRemote = (ManejoMateriaRemote) context
					.lookup("java:global/SAMA-EAR/SAMA-EJB/ManejoMateriaSession!co.edu.unicesi.sama.materias.ManejoMateriaRemote");
		} catch (NamingException e) {

			e.printStackTrace();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String crearMateria(MateriaBO materia) {
		try {

			return materiasRemote.crearMateria(materia);

		} catch (Exception e) {

			e.printStackTrace();
			return "Error";
		}
	}

}
