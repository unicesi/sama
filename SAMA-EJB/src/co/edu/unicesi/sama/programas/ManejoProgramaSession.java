package co.edu.unicesi.sama.programas;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.dbutil.DBUtil;
import co.edu.unicesi.sama.entidades.Programa;
import co.edu.unicesi.sama.exception.SamaException;

/**
 * Esta clase es la encargada de crear programas.
 */
@Stateless
public class ManejoProgramaSession implements ManejoProgramaRemote, ManejoProgramaLocal  {

	@PersistenceContext(unitName = DBUtil.PU_DT)
	protected EntityManager entityManager;
    /**
     * Constructor. 
     */
    public ManejoProgramaSession() {
        // TODO Auto-generated constructor stub
    }

    /**
     * {@inheritDoc}
     */
	@Override
	public String crearPrograma(ProgramaBO programa) throws SamaException {
		
		try{
			
			Programa prog = new Programa();
			prog.setNombre(programa.getNombre());
			prog.setCodigo(programa.getIdPrograma());
			prog.setDescripcion(programa.getDescripcion());
			
			
	
			if(!entityManager.contains(prog)){
				
				entityManager.persist(prog);
				
				entityManager.flush();
				return programa.getNombre();
			}
			
			return "Error";
			
		}catch(Exception e){
			
			throw new SamaException("Error creando el programa");
			
		}
	}

}
