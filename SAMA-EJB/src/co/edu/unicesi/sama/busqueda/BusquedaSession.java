package co.edu.unicesi.sama.busqueda;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.BloquesMateriaPKBO;
import co.edu.unicesi.sama.bo.CompetenciaBO;
import co.edu.unicesi.sama.bo.CompetenciasprofesionaleBO;
import co.edu.unicesi.sama.bo.LineaCompetenciaBO;
import co.edu.unicesi.sama.bo.MateriaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.dbutil.DBUtil;
import co.edu.unicesi.sama.entidades.Bloque;

import co.edu.unicesi.sama.entidades.Competencia;
import co.edu.unicesi.sama.entidades.Lineadecompetencia;
import co.edu.unicesi.sama.entidades.Materia;
import co.edu.unicesi.sama.entidades.Programa;

/**
 * Session Bean implementation class BusquedaSession
 */
@Stateless
public class BusquedaSession implements BusquedaServiceRemote, BusquedaServiceLocal{

	@PersistenceContext(unitName= DBUtil.PU_DT)
	protected EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public BusquedaSession() {
        // TODO Auto-generated constructor stub
    }

    @Override
	public ArrayList<ProgramaBO> darProgramasOrdenadosPorNombre() {
    	
    	TypedQuery<Programa> respProgramas = entityManager.createNamedQuery("listarProgramasOrdenadosPorNombre",Programa.class);
    	List<Programa> programas = respProgramas.getResultList();
    	ArrayList<ProgramaBO> progBO = new ArrayList<ProgramaBO>();
    	
    	if(programas.size()>0){
    		for(Programa p:programas){
        		
        		progBO.add(p.toBO());
        	}
    		return progBO;
    	}
    	
    	return null;
    }
    @Override
	public ArrayList<MateriaBO> darMateriasOrdenadosPorNombre(String busqueda) {
		TypedQuery<Materia> respMaterias = entityManager.createNamedQuery(
				"listarMateriasOrdenadosPorNombre", Materia.class);
		List<Materia> materias = respMaterias.getResultList();
		

		TypedQuery<Bloque> query = entityManager
				.createNamedQuery("buscarBloqueporId",
						Bloque.class);
		query.setMaxResults(30);
		query.setParameter("id", "%" + Integer.parseInt(busqueda) + "%");
		
		List<Bloque> list = query.getResultList();
		Bloque bloq = list.get(0);
		Set <Materia> mat= bloq.getMaterias();
	
		ArrayList<Materia> resultado= new ArrayList();
		
		for (int i=0;i<materias.size();i++){
			resultado.add(materias.get(i));
		}
		

		
		for (Materia q: materias){
			for(Materia t: mat){
				if(t.getIdMateria()==(q.getIdMateria())){
					resultado.remove(t);
				}
				
			}
			
		}
		
		ArrayList<MateriaBO> matBO = new ArrayList<MateriaBO>();
		if (materias.size() > 0) {
			for (Materia m : resultado) {

				matBO.add(m.toBO());
			}
			return matBO;
		}

		return null;
	}

	@Override
	public ArrayList<BloqueBO> darBloqueporPrograma(ProgramaBO programa) {
		TypedQuery<Bloque> query2 = entityManager.createNamedQuery(
				"buscarBloqueporPrograma", Bloque.class);
		query2.setParameter("programa", "%" + programa.getIdPrograma() + "%");
		List<Bloque> bloques = query2.getResultList();
		ArrayList<BloqueBO> bloqBO = new ArrayList<BloqueBO>();

		if (bloques.size() > 0) {
			for (Bloque p : bloques) {

				bloqBO.add(p.toBO());
			}
			return bloqBO;
		}

		return null;
	}
	
	@Override
	public List<BloqueBO> buscarMateriaBloquePorBloque(String busqueda) {

		try {
			TypedQuery<Bloque> query = entityManager
					.createNamedQuery("buscarBloqueporId",
							Bloque.class);
			query.setMaxResults(30);
			query.setParameter("id", "%" + Integer.parseInt(busqueda) + "%");
			List<Bloque> list = query.getResultList();
			List<BloqueBO> l = new ArrayList<BloqueBO>();
			for (Bloque d : list) {
				l.add(d.toBO());
			}
			return l;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public ArrayList<CompetenciaBO> buscarCompetenciaPorPrograma(String busqueda, String programa ) {
		// TODO Auto-generated method stub
		try {
			
			TypedQuery<Competencia> query = entityManager
					.createNamedQuery("buscarCompetenciaPorTipo",
							Competencia.class);
			
			query.setMaxResults(30);
			
			query.setParameter("tipo", "%" + busqueda + "%");
			
			List<Competencia> list = query.getResultList();
			
			ArrayList<CompetenciaBO> retorno = new ArrayList<CompetenciaBO>();
			
			
			
			

			if (list.size() > 0) {
				
				for (Competencia p : list) {
					boolean contiene=false;
					for (Programa t: p.getProgramas()){
						if(t.getIdPrograma()==Integer.parseInt(programa)){
							contiene=true;
						}
						
					}
					CompetenciaBO Bo=p.toBO();
					if(contiene){
						retorno.add(Bo);
					}
					
				
				}
				
			}
			

			
		
			return retorno;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public ArrayList<LineaCompetenciaBO> buscarLineaDeCompetenciaPorCompetencia(
			String programa, String competencias) {
try {
	System.out.println("entrando a buscar Linea de competencia");
			TypedQuery<Lineadecompetencia> query = entityManager
					.createNamedQuery("buscarLineaDeCompetenciaPorCompetencia",
							Lineadecompetencia.class);
			
			query.setMaxResults(30);
			
			query.setParameter("id", "%" + competencias + "%");
			
			List<Lineadecompetencia> list = query.getResultList();
			
			ArrayList<LineaCompetenciaBO> retorno = new ArrayList<LineaCompetenciaBO>();
			
			
			System.out.println("tamaño Lista linea de comeptencia"+list.size());
			

			if (list.size() > 0) {
				
				for (Lineadecompetencia p : list) {
					boolean asociado=false;
					for (Programa q:p.getProgramas()){
						if(q.getIdPrograma()==Integer.parseInt(programa)){
							asociado=true;
						}
					}
//					boolean asociado=false;
//					LineaCompetenciaBO Bo=p.toBO();
//					System.out.println(Bo.getIdLineaDeCompetencia() + "esperando q" + Bo.getProgramas().get(1).getIdPrograma());
//					for (ProgramaBO q: Bo.getProgramas()){
//						if(q.getIdPrograma()==Integer.parseInt(programa)){
//							asociado=true;
//						}
//					}
					LineaCompetenciaBO Bo=p.toBO();
					
					Bo.setAsociado(asociado);
					retorno.add(Bo);
					
				
				}
				
			}
			

			
			System.out.println("tamaño Lista retorno"+retorno.size());
			return retorno;
		} catch (Exception e) {
			return null;
		}
	}

}
