package co.edu.unicesi.sama.bloques;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;



import co.edu.unicesi.sama.bloque.ManejoBloqueLocal;
import co.edu.unicesi.sama.bloque.ManejoBloqueRemote;
import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.dbutil.DBUtil;
import co.edu.unicesi.sama.entidades.Bloque;
import co.edu.unicesi.sama.entidades.Programa;
import co.edu.unicesi.sama.exception.SamaException;

/**
 * Bean de sesion encargado del manejo de los bloques.
*/
@Stateless
public class ManejoBloqueSession  implements ManejoBloqueRemote, ManejoBloqueLocal {
	@PersistenceContext(unitName = DBUtil.PU_DT)
	protected EntityManager entityManager;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String crearBloque(String programa, BloqueBO bloque)
			throws SamaException {
		// TODO Auto-generated method stub
		
		
		System.out.println("Entra a crearBloque");
		Bloque bloq= new Bloque();
		
		bloq.setNombre(bloque.getNombre());
		bloq.setDescripcion(bloque.getDescripcion());
		
		Programa prog2 = buscarProgramaporID(programa).get(0);
		
		bloq.setPrograma(prog2);
		
		entityManager.persist(bloq);
		System.out.println("Pasa el merge");
		entityManager.flush();
		return bloq.getNombre();
		
	}
	
	/**
	 * Este metodo se encarga de buscar un Programa a partir de su id.
	 * @param busqueda - int - id del Programa que se desea buscar.
	 * @return List<Programa> - lista con los programas encontrados. 
	 */
	private List<Programa> buscarProgramaporID(String busqueda)
	{
		try
		{
			TypedQuery<Programa> query = entityManager.createNamedQuery("buscarProgramaporId",Programa.class);
			query.setMaxResults(50);
			query.setParameter("programa","%"+busqueda+"%");
			List<Programa> list = query.getResultList();
			
		
			return list;
		}
		catch(Exception e)
		{
			return null;
		}
	}

}

