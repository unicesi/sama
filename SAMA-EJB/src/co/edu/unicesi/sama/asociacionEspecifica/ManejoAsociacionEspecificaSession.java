package co.edu.unicesi.sama.asociacionEspecifica;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import co.edu.unicesi.sama.bo.AsociacionEspecificaBO;
import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.BloquesMateriaPKBO;
import co.edu.unicesi.sama.bo.MateriaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.dbutil.DBUtil;
import co.edu.unicesi.sama.entidades.Bloque;

import co.edu.unicesi.sama.entidades.BloquesCompetenciasespecifica;
import co.edu.unicesi.sama.entidades.BloquesCompetenciasespecificaPK;
import co.edu.unicesi.sama.entidades.CompetenciasespecificasPrograma;
import co.edu.unicesi.sama.entidades.CompetenciasespecificasProgramaPK;
import co.edu.unicesi.sama.entidades.Materia;
import co.edu.unicesi.sama.entidades.Programa;
import co.edu.unicesi.sama.exception.SamaException;

/**
 * Session Bean implementation class ManejoProgramaSession
 */
@Stateless
public class ManejoAsociacionEspecificaSession implements ManejoAsociacionEspecificaRemote, ManejoAsociacionEspecificaLocal  {

	@PersistenceContext(unitName = DBUtil.PU_DT)
	protected EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public ManejoAsociacionEspecificaSession() {
        // TODO Auto-generated constructor stub
    }
    
    
	@Override
	public String crearAsociacionBloque(String programa, String bloque,
			String competencia, int opc) throws SamaException {
		

		
		System.out.println("LLEGANDO ACA");

		TypedQuery<BloquesCompetenciasespecifica> query = entityManager
				.createNamedQuery("consultaBloqueCompetenciaEspecifica",
						BloquesCompetenciasespecifica.class);
		
		query.setMaxResults(30);
		
		
		query.setParameter("bloque", "%" + bloque + "%");
		
		List<BloquesCompetenciasespecifica> list = query.getResultList();
		
		
		boolean encontrado=false;
		BloquesCompetenciasespecifica comp=null;
		
		for(int i=0; i<list.size()&&!encontrado;i++){
			BloquesCompetenciasespecifica temporal= list.get(i);
			CompetenciasespecificasPrograma temporal2=temporal.getCompetenciasespecificasPrograma();
			if(temporal2!=null){
			CompetenciasespecificasProgramaPK  temporal3=temporal2.getId();
			
			
			
					
		if (temporal3!=null){
			if (temporal3.getFK_CodigoPrograma().equals(programa)&&temporal3.getFK_IdCompetenciaEspecifica()==Integer.valueOf(competencia)){
				
				encontrado=true;
				
				comp=list.get(i);
			}
			}
			}
				
			
			
			
			
			
		}
		
		if(comp!=null){
			if(opc==1){
				comp.setIntroduce(1);
			}else if (opc==2){
				comp.setEnseña(1);
			}else{
				comp.setAplica(1);
			}
		}else{
			
			BloquesCompetenciasespecificaPK pk=new BloquesCompetenciasespecificaPK();
			pk.setFK_CodigoPrograma(programa);
			pk.setFK_IdBloque(Integer.valueOf(bloque));
			pk.setFK_idCompetenciaEspecifica(Integer.valueOf(competencia));
			
			 comp= new BloquesCompetenciasespecifica();
			if(opc==1){
				comp.setIntroduce(1);
			}else if (opc==2){
				comp.setEnseña(1);
			}else{
				comp.setAplica(1);
			}
			comp.setId(pk);
			TypedQuery<Bloque> query2 = entityManager
					.createNamedQuery("buscarBloqueporId",
							Bloque.class);
			query2.setMaxResults(30);
			query2.setParameter("id", "%" + Integer.parseInt(bloque) + "%");
			
			List<Bloque> list2 = query2.getResultList();
			Bloque bloq = list2.get(0);
			
			comp.setBloque(bloq);
			
		}
		

		
		entityManager.persist(comp);
		entityManager.flush();
		
		return "Asociacion exitosa";
		
		
		
	
		
				
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
		return null;
	}
	@Override
	public String elminarAsociacionMateria(String programa, String bloque,
			String competencia, int opc) throws SamaException {
		// TODO Auto-generated method stub
		return null;
	}

	


    
}
