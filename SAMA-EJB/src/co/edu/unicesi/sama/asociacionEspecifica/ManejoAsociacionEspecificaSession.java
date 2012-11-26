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
import co.edu.unicesi.sama.entidades.MateriasCompetenciasespecifica;
import co.edu.unicesi.sama.entidades.MateriasCompetenciasespecificaPK;
import co.edu.unicesi.sama.entidades.Programa;
import co.edu.unicesi.sama.exception.SamaException;

/**
 * Bean de sesion encargado del manejo de las asociaciones de las competencias.
 */
@Stateless
public class ManejoAsociacionEspecificaSession implements ManejoAsociacionEspecificaRemote, ManejoAsociacionEspecificaLocal  {

	@PersistenceContext(unitName = DBUtil.PU_DT)
	protected EntityManager entityManager;
	/**
	 * Constructor. 
	 */
	public ManejoAsociacionEspecificaSession() {
		// TODO Auto-generated constructor stub
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public String crearAsociacionBloque(String programa, String bloque,
			String competencia, int opc) throws SamaException {





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
			comp.setPuntaje(0);
			TypedQuery<Bloque> query2 = entityManager
					.createNamedQuery("buscarBloqueporId",
							Bloque.class);
			query2.setMaxResults(30);
			query2.setParameter("id", "%" + Integer.parseInt(bloque) + "%");

			List<Bloque> list2 = query2.getResultList();
			Bloque bloq = list2.get(0);

			comp.setBloque(bloq);



			TypedQuery<CompetenciasespecificasPrograma> query3 = entityManager
					.createNamedQuery("buscarCompetenciaEspecificaProgramaporPK",
							CompetenciasespecificasPrograma.class);
			query3.setMaxResults(30);
			query3.setParameter("programa", "%" + programa + "%");
			query3.setParameter("compeEspe", "%" + Integer.parseInt(competencia) + "%");



			List<CompetenciasespecificasPrograma> list3 = query3.getResultList();
			CompetenciasespecificasPrograma compe = list3.get(0);

			comp.setCompetenciasespecificasPrograma(compe);
			comp.setBloque(bloq);

		}



		entityManager.persist(comp);
		entityManager.flush();

		return "Asociacion exitosa";

	}
	
	/**
     * {@inheritDoc}
     */
	@Override
	public String eliminarAsociacionBloque(String programa, String bloque,
			String competencia, int opc) throws SamaException {

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


		TypedQuery<Bloque> query2 = entityManager
				.createNamedQuery("buscarBloqueporId",
						Bloque.class);
		query2.setMaxResults(30);
		query2.setParameter("id", "%" + Integer.parseInt(bloque) + "%");

		List<Bloque> list2 = query2.getResultList();
		Bloque bloq = list2.get(0);

		boolean problema=false;

		for(Materia d:bloq.getMaterias()){
			TypedQuery<MateriasCompetenciasespecifica> query3 = entityManager
					.createNamedQuery("consultaMateriaCompetenciaEspecifica",
							MateriasCompetenciasespecifica.class);

			query3.setMaxResults(30);


			query3.setParameter("materia", "%" + d.getCodigo() + "%");

			List<MateriasCompetenciasespecifica> list3 = query3.getResultList();


			encontrado=false;
			MateriasCompetenciasespecifica comp2=null;

			for(int i=0; i<list3.size()&&!encontrado;i++){
				MateriasCompetenciasespecifica temporal= list3.get(i);
				CompetenciasespecificasPrograma temporal2=temporal.getCompetenciasespecificasPrograma();
				if(temporal2!=null){
					CompetenciasespecificasProgramaPK  temporal3=temporal2.getId();

					if (temporal3!=null){
						if (temporal3.getFK_CodigoPrograma().equals(programa)&&temporal3.getFK_IdCompetenciaEspecifica()==Integer.valueOf(competencia)){

							encontrado=true;

							comp2=list3.get(i);
							if (comp2==null )
								problema=true;
							if(comp2.getIntroduce()==1&&opc==1)
								problema=true;
							if(comp2.getEnseña()==1&&opc==2)
								problema=true;
							if(comp2.getAplica()==1&&opc==3)
								problema=true;

						}
					}
				}

			}

		}

		if(!problema){

			if(comp!=null){
				if(opc==1){
					comp.setIntroduce(0);
				}else if (opc==2){
					comp.setEnseña(0);
				}else{
					comp.setAplica(0);
				}
			}

		}else{
			System.out.println("DEBERIA MOSTRAR EL ERROR");
			throw new SamaException("No se puede borrar la asociacion, hay materias asociadas para este bloque y competencia");


		}

		entityManager.persist(comp);
		entityManager.flush();

		return "Desasociacion exitosa";
	}
	
	/**
     * {@inheritDoc}
     */
	@Override
	public String crearAsociacionMateria(String programa, String bloque,
			String competencia, int opc) throws SamaException {
		// TODO Auto-generated method stub

		TypedQuery<MateriasCompetenciasespecifica> query = entityManager
				.createNamedQuery("consultaMateriaCompetenciaEspecifica",
						MateriasCompetenciasespecifica.class);

		query.setMaxResults(30);


		query.setParameter("materia", "%" + bloque + "%");

		List<MateriasCompetenciasespecifica> list = query.getResultList();


		boolean encontrado=false;
		MateriasCompetenciasespecifica comp=null;

		for(int i=0; i<list.size()&&!encontrado;i++){
			MateriasCompetenciasespecifica temporal= list.get(i);
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



		TypedQuery<Materia> query4 = entityManager
				.createNamedQuery("buscarMateriaPorId",
						Materia.class);
		query4.setMaxResults(30);
		query4.setParameter("id", "%" + bloque + "%");

		List<Materia> list4 = query4.getResultList();
		Materia mat = list4.get(0);




		//		
		//		TypedQuery<Bloque> query2 = entityManager
		//				.createNamedQuery("buscarBloqueporId",
		//						Bloque.class);
		//		query2.setMaxResults(30);
		//		query2.setParameter("id", "%" + Integer.parseInt(bloque) + "%");
		//		
		//		List<Bloque> list2 = query2.getResultList();
		//		Bloque bloq = list2.get(0);


		boolean problema=false;

		TypedQuery<Bloque> query2 = entityManager
				.createNamedQuery("buscarBloqueporPrograma",
						Bloque.class);
		query2.setMaxResults(30);
		query2.setParameter("programa", "%" + programa + "%");
		BloquesCompetenciasespecifica comp2=null;
		List<Bloque> list1 = query2.getResultList();
		for(Bloque k:list1){
			
			for(Materia s:k.getMaterias()){
				System.out.println(s.getCodigo());
				if(s.getCodigo().equals(bloque)){
					

					TypedQuery<BloquesCompetenciasespecifica> query5 = entityManager
							.createNamedQuery("consultaBloqueCompetenciaEspecifica",
									BloquesCompetenciasespecifica.class);

					query5.setMaxResults(30);


					query5.setParameter("bloque", "%" + k.getId() + "%");

					List<BloquesCompetenciasespecifica> list2 = query5.getResultList();

					
					boolean encontrado2=false;


					for(int i=0; i<list2.size()&&!encontrado2;i++){
						BloquesCompetenciasespecifica temporal= list2.get(i);
						CompetenciasespecificasPrograma temporal2=temporal.getCompetenciasespecificasPrograma();
						if(temporal2!=null){
							CompetenciasespecificasProgramaPK  temporal3=temporal2.getId();




							if (temporal3!=null){
								if (temporal3.getFK_CodigoPrograma().equals(programa)&&temporal3.getFK_IdCompetenciaEspecifica()==Integer.valueOf(competencia)){
									System.out.println("Encontro otro");
									encontrado2=true;

									comp2=list2.get(i);
								}
							}
						}


					}

				}
			}
				if(comp2!=null){
					if (comp2.getIntroduce()==0&&opc==1){
						problema=true;
					}
					if (comp2.getEnseña()==0&&opc==2){
						problema=true;
					}

					if (comp2.getAplica()==0&&opc==3){
						problema=true;
					}

				}
				if(!problema){
					
					if(comp!=null){
						
						if(opc==1){
							comp.setIntroduce(1);
							comp.setPuntaje(comp.getPuntaje()+1);
							comp2.setPuntaje(comp2.getPuntaje()+1);
						}else if (opc==2){
							comp.setEnseña(1);
							comp.setPuntaje(comp.getPuntaje()+2);
							comp2.setPuntaje(comp2.getPuntaje()+2);
						}else{
							comp.setAplica(1);
							comp.setPuntaje(comp.getPuntaje()+3);
							comp2.setPuntaje(comp2.getPuntaje()+3);
						}
					}else{

						System.out.println("Creando+  " + comp2.getAplica());

						MateriasCompetenciasespecificaPK pk=new MateriasCompetenciasespecificaPK();
						pk.setFK_CodigoPrograma(programa);
						pk.setFK_CodigoMateria(bloque);
						pk.setFK_IdCompetenciaEspecifica(Integer.valueOf(competencia));


						comp= new MateriasCompetenciasespecifica();
						if(opc==1){
							comp.setIntroduce(1);
							comp.setPuntaje(1);
						}else if (opc==2){
							comp.setEnseña(1);
							comp.setPuntaje(2);
						}else{
							comp.setAplica(1);
							comp.setPuntaje(3);
						}
						comp.setId(pk);
						TypedQuery<Materia> query3 = entityManager
								.createNamedQuery("buscarMateriaPorId",
										Materia.class);
						query3.setMaxResults(30);
						query3.setParameter("id", "%" + Integer.parseInt(bloque) + "%");

						List<Materia> list2 = query3.getResultList();
						Materia mate = list2.get(0);

						comp.setMateria(mate);



						TypedQuery<CompetenciasespecificasPrograma> query5 = entityManager
								.createNamedQuery("buscarCompetenciaEspecificaProgramaporPK",
										CompetenciasespecificasPrograma.class);
						query5.setMaxResults(30);
						query5.setParameter("programa", "%" + programa + "%");
						query5.setParameter("compeEspe", "%" + Integer.parseInt(competencia) + "%");



						List<CompetenciasespecificasPrograma> list3 = query5.getResultList();
						CompetenciasespecificasPrograma compe = list3.get(0);

						comp.setCompetenciasespecificasPrograma(compe);


					}
					entityManager.persist(comp);
					entityManager.flush();

					return "Asociacion exitosa";
				}
				else
				{
					System.out.println("con problema ASOSIACIÓN MATERIA ultimo =??????+  " + comp2.getAplica());
					throw new SamaException("No se puede crear la asociacion,no hay bloque asociado para esta materia y competencia");
				}

		}
		return "Asociacion exitosa";

	}
	
	/**
     * {@inheritDoc}
     */
	@Override
	public String elminarAsociacionMateria(String programa, String bloque,
			String competencia, int opc) throws SamaException {
		// TODO Auto-generated method stub
		TypedQuery<MateriasCompetenciasespecifica> query = entityManager
				.createNamedQuery("consultaMateriaCompetenciaEspecifica",
						MateriasCompetenciasespecifica.class);

		query.setMaxResults(30);


		query.setParameter("materia", "%" + bloque + "%");

		List<MateriasCompetenciasespecifica> list = query.getResultList();


		boolean encontrado=false;
		MateriasCompetenciasespecifica comp=null;

		for(int i=0; i<list.size()&&!encontrado;i++){
			MateriasCompetenciasespecifica temporal= list.get(i);
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
			
		TypedQuery<Bloque> query2 = entityManager
				.createNamedQuery("buscarBloqueporPrograma",
						Bloque.class);
		query2.setMaxResults(30);
		query2.setParameter("programa", "%" + programa + "%");
		BloquesCompetenciasespecifica comp2=null;
		List<Bloque> list1 = query2.getResultList();
		for(Bloque k:list1){
			System.out.println(k.getMaterias().size()+"LONGITUD");
			for(Materia s:k.getMaterias()){
				System.out.println(s.getCodigo());
				if(s.getCodigo().equals(bloque)){
					System.out.println("ENCONTRO UNO");

					TypedQuery<BloquesCompetenciasespecifica> query5 = entityManager
							.createNamedQuery("consultaBloqueCompetenciaEspecifica",
									BloquesCompetenciasespecifica.class);

					query5.setMaxResults(30);


					query5.setParameter("bloque", "%" + k.getId() + "%");

					List<BloquesCompetenciasespecifica> list2 = query5.getResultList();

					System.out.println(list2.size()+"LONGITUD2");
					boolean encontrado2=false;


					for(int i=0; i<list2.size()&&!encontrado2;i++){
						BloquesCompetenciasespecifica temporal= list2.get(i);
						CompetenciasespecificasPrograma temporal2=temporal.getCompetenciasespecificasPrograma();
						if(temporal2!=null){
							CompetenciasespecificasProgramaPK  temporal3=temporal2.getId();




							if (temporal3!=null){
								if (temporal3.getFK_CodigoPrograma().equals(programa)&&temporal3.getFK_IdCompetenciaEspecifica()==Integer.valueOf(competencia)){
									System.out.println("Encontro otro");
									encontrado2=true;

									comp2=list2.get(i);
								}
							}
						}


					}

				}
			}
		}
	
		
		

		if(comp!=null){
			if(opc==1){
				comp.setIntroduce(0);
				comp.setPuntaje(comp.getPuntaje()-1);
				comp2.setPuntaje(comp2.getPuntaje()-1);
			}else if (opc==2){
				comp.setEnseña(0);
				comp.setPuntaje(comp.getPuntaje()-2);
				comp2.setPuntaje(comp2.getPuntaje()-2);
			}else{
				comp.setAplica(0);
				comp.setPuntaje(comp.getPuntaje()-3);
				comp2.setPuntaje(comp2.getPuntaje()-3);
			}
			
			
		}
		return "Desasosiacion exitosa";
	}
	

}
