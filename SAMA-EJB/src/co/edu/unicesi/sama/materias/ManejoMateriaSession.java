package co.edu.unicesi.sama.materias;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.unicesi.sama.bo.MateriaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.dbutil.DBUtil;
import co.edu.unicesi.sama.entidades.Materia;
import co.edu.unicesi.sama.entidades.Programa;
import co.edu.unicesi.sama.exception.SamaException;

/**
 * Session Bean implementation class ManejoProgramaSession
 */
@Stateless
public class ManejoMateriaSession implements ManejoMateriaRemote,
		ManejoMateriaLocal {

	@PersistenceContext(unitName = DBUtil.PU_DT)
	protected EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public ManejoMateriaSession() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String crearMateria(MateriaBO materia) throws SamaException {
		try {
			
			Materia mat = new Materia();
			mat.setNombre(materia.getNombre());
			mat.setCodigo(materia.getIdMateria());
			mat.setDescripcion(materia.getDescripcion());
			

			if(!entityManager.contains(mat)){
				
				entityManager.persist(mat);
				
				entityManager.flush();
				return materia.getNombre();		
			}
			
			return "Error";
			
		} catch (Exception e) {

			throw new SamaException("Error creando la materia");

		}
	}

}
