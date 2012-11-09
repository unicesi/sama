package co.edu.unicesi.sama.bloqueMateria;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.BloquesMateriaPKBO;
import co.edu.unicesi.sama.bo.MateriaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.dbutil.DBUtil;
import co.edu.unicesi.sama.entidades.Bloque;

import co.edu.unicesi.sama.entidades.Materia;
import co.edu.unicesi.sama.entidades.Programa;
import co.edu.unicesi.sama.exception.SamaException;

/**
 * Session Bean implementation class ManejoProgramaSession
 */
@Stateless
public class ManejoBloquesMateriaSession implements ManejoBloquesMateriaRemote, ManejoBloquesMateriaLocal  {

	@PersistenceContext(unitName = DBUtil.PU_DT)
	protected EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public ManejoBloquesMateriaSession() {
        // TODO Auto-generated constructor stub
    }

	




	@Override
	public String crearBloquesMateria(String bloque, String materia)
			throws SamaException {
		
		try{
			
			TypedQuery<Bloque> respProgramas = entityManager.createNamedQuery(
					"buscarBloqueporId", Bloque.class);
			respProgramas.setParameter("id", "%"+Integer.parseInt(bloque)+ "%");
			List<Bloque> bloques = respProgramas.getResultList();
			
			
			TypedQuery<Materia> respProgramas2 = entityManager.createNamedQuery(
					"buscarMateriaPorId", Materia.class);
			respProgramas2.setParameter("id", "%"+ Integer.parseInt(materia) + "%");
			List<Materia> materias = respProgramas2.getResultList();
			
			
			Bloque bloqObj=bloques.get(0);
			Materia matObj=materias.get(0);
			
			String retorno="";
			if(!matObj.getBloques().contains(bloqObj)){
			matObj.getBloques().add(bloqObj);
			bloqObj.getMaterias().add(matObj);
			entityManager.persist(bloqObj);
			entityManager.persist(matObj);
			
			entityManager.flush();
			
			 return "Asociacion creada con exito";
			
			}else{
			retorno="Error";
			}
			return retorno;
			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
			throw new SamaException("Error");
			
		}
		// TODO Auto-generated method stub
		
	}
	
	public String eliminarBloquesMateria(String bloque, String materia)
			throws SamaException {
		
		try{		
			TypedQuery<Bloque> respProgramas = entityManager.createNamedQuery(
					"buscarBloqueporId", Bloque.class);
			respProgramas.setParameter("id", "%"+Integer.parseInt(bloque)+ "%");
			List<Bloque> bloques = respProgramas.getResultList();
			
			
			TypedQuery<Materia> respProgramas2 = entityManager.createNamedQuery(
					"buscarMateriaPorId", Materia.class);
			respProgramas2.setParameter("id", "%"+ Integer.parseInt(materia) + "%");
			List<Materia> materias = respProgramas2.getResultList();
			
			
			Bloque bloqObj=bloques.get(0);
			Materia matObj=materias.get(0);
			
			String retorno="";
			
				
				
			matObj.getBloques().remove(bloqObj);
			
			bloqObj.getMaterias().remove(matObj);
			
			entityManager.persist(bloqObj);
			entityManager.persist(matObj);
			
			entityManager.flush();
			
			 return "Asociacion eliminada con exito";
			
		
			
			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
			throw new SamaException("Error");
			
		}
		// TODO Auto-gene
	}
}
