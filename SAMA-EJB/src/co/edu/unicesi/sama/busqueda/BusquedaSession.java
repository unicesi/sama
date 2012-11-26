package co.edu.unicesi.sama.busqueda;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import co.edu.unicesi.sama.bo.*;
import co.edu.unicesi.sama.dbutil.DBUtil;
import co.edu.unicesi.sama.entidades.Bloque;
import co.edu.unicesi.sama.entidades.BloquesCompetenciasespecifica;
import co.edu.unicesi.sama.entidades.CompetenciasespecificasProgramaPK;



import co.edu.unicesi.sama.entidades.*;


/**
 * Esta clase esta encargada de manejar todas las busquedas.
 */
@Stateless
public class BusquedaSession implements BusquedaServiceRemote, BusquedaServiceLocal{

	@PersistenceContext(unitName= DBUtil.PU_DT)
	protected EntityManager entityManager;

	/**
	 * Constructor. 
	 */
	public BusquedaSession() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * {@inheritDoc}
	 */
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

	/**
	 * {@inheritDoc}
	 */
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
				if(t.getCodigo().equals(q.getCodigo())){
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

	/**
	 * {@inheritDoc}
	 */
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

	/**
	 * {@inheritDoc}
	 */
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArrayList<CompetenciaTerminalBO> buscarCompetenciaPorPrograma(String busqueda, String programa ) {
		// TODO Auto-generated method stub
		try {

			TypedQuery<Competenciasterminale> query = entityManager
					.createNamedQuery("buscarCompetenciaPorTipo",
							Competenciasterminale.class);

			query.setMaxResults(30);

			query.setParameter("tipo", "%" + busqueda + "%");

			List<Competenciasterminale> list = query.getResultList();

			ArrayList<CompetenciaTerminalBO> retorno = new ArrayList<CompetenciaTerminalBO>();





			if (list.size() > 0) {

				for (Competenciasterminale p : list) {
					boolean contiene=false;
					for (Programa t: p.getProgramas()){
						if(t.getCodigo().equals(programa)){
							contiene=true;
						}

					}
					CompetenciaTerminalBO Bo=p.toBO();
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArrayList<CompetenciaEspecificaBO> buscarLineaDeCompetenciaPorCompetencia(
			String programa, String competencias) {
		try {

			TypedQuery<Competenciasespecifica> query = entityManager
					.createNamedQuery("buscarLineaDeCompetenciaPorCompetencia",
							Competenciasespecifica.class);

			query.setMaxResults(30);

			query.setParameter("id", "%" + competencias + "%");

			List<Competenciasespecifica> list = query.getResultList();

			ArrayList<CompetenciaEspecificaBO> retorno = new ArrayList<CompetenciaEspecificaBO>();


			System.out.println("tamaño Lista linea de comeptencia"+list.size());


			if (list.size() > 0) {

				for (Competenciasespecifica p : list) {
					boolean asociado=false;
					for (Programa q:p.getProgramas()){
						if(q.getCodigo().equals(programa)){
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
					CompetenciaEspecificaBO Bo=p.toBO();

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

	/**
	 * {@inheritDoc}
	 */
	public AsociacionEspecificaBO buscarAsociacionCompetenciaEspecificaMateria (String programa,String bloque, String CompetenciaEspecifica){


		TypedQuery<MateriasCompetenciasespecifica> query = entityManager
				.createNamedQuery("consultaMateriaCompetenciaEspecifica",
						MateriasCompetenciasespecifica.class);

		query.setMaxResults(30);


		query.setParameter("materia", "%" + bloque + "%");

		List<MateriasCompetenciasespecifica> list = query.getResultList();

		boolean encontrado=false;

		AsociacionEspecificaBO bo=null;
		for(int i=0; i<list.size()&&!encontrado;i++){
			MateriasCompetenciasespecifica temporal= list.get(i);
			CompetenciasespecificasPrograma temporal2=temporal.getCompetenciasespecificasPrograma();
			if(temporal2!=null){
				CompetenciasespecificasProgramaPK  temporal3=temporal2.getId();



				if (temporal3!=null){
					if (temporal3.getFK_CodigoPrograma().equals(programa)&&temporal3.getFK_IdCompetenciaEspecifica()==Integer.valueOf(CompetenciaEspecifica)){

						encontrado=true;

						bo=list.get(i).toBo();
					}
				}
			}


		}

		return bo;	
	}

	/**
	 * {@inheritDoc}
	 */
	public AsociacionEspecificaBO buscarAsociacionCompetenciaEspecificaBloque (String programa, String bloque, String CompetenciaEspecifica){



		TypedQuery<BloquesCompetenciasespecifica> query = entityManager
				.createNamedQuery("consultaBloqueCompetenciaEspecifica",
						BloquesCompetenciasespecifica.class);

		query.setMaxResults(30);


		query.setParameter("bloque", "%" + bloque + "%");

		List<BloquesCompetenciasespecifica> list = query.getResultList();

		boolean encontrado=false;

		AsociacionEspecificaBO bo=null;
		for(int i=0; i<list.size()&&!encontrado;i++){
			BloquesCompetenciasespecifica temporal= list.get(i);
			CompetenciasespecificasPrograma temporal2=temporal.getCompetenciasespecificasPrograma();
			if(temporal2!=null){
				CompetenciasespecificasProgramaPK  temporal3=temporal2.getId();



				if (temporal3!=null){
					if (temporal3.getFK_CodigoPrograma().equals(programa)&&temporal3.getFK_IdCompetenciaEspecifica()==Integer.valueOf(CompetenciaEspecifica)){

						encontrado=true;

						bo=list.get(i).toBo();
					}
				}
			}






		}

		return bo;




	}

}
