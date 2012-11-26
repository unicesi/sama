package co.edu.unicesi.sama.client.busqueda;

import java.util.ArrayList;
import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.*;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Esta interfaz provee los servicios de busqueda.
 */
public interface BusquedaServiceAsync {

	/**
	 * Este metodo se encarga de buscar los programas, los convierte en BussinesObject
	 *  y los retorna en un ArrayList<ProgramaBO> ordenados alfabeticamente por nombre.
	 *  
	 *   @param callback the callback to return ArrayList<ProgramaBO> con los programasBO ordenados por nombre. 
	 */
	public void darProgramasOrdenadosPorNombre(AsyncCallback<ArrayList<ProgramaBO>> callback);
	
	/**
	 * Este metodo se encarga de buscar las materias en un bloque especifico,
	 * las convierte en BussinesObject y las devuelve en un ArrayList<MateriaBO> 
	 * ordenados alfabeticamente por nombre.
	 * @param busqueda - String - con el id del bloque donde esta la materia.
	 * @param callback the callback to return ArrayList<MateriaBO> con las materiasBO ordenadas por nombre.
	 */
	public void  darMateriasOrdenadosPorNombre(String id, AsyncCallback<ArrayList<MateriaBO>> callback);

	/**
	 * Este metodo se encarga de buscar los bloques de un Bussiness Object de un programa
	 * @param programa - ProgramaBO - BussinesObject del programa del cual se desea obtener los bloques.
	 * @param callback the callback to return bloques -ArrayList- con los BussinesObject de los bloques del programa.
	 */
	public void darBloqueporPrograma(ProgramaBO programa, AsyncCallback<ArrayList<BloqueBO>> callback);
	
	/**
	 * Este metodo se encarga de buscar un bloque de materias, los convierte en BussinesObject
	 * y los devuelve en un List<BloqueBO>.
	 * @param busqueda - String, es el id del bloque que se quiere buscar.
	 * @param callback the callback to return List<BloqueBo> con los bloqueBO buscados.
	 */
	public void buscarMateriaBloquePorBloque(String busqueda, AsyncCallback<ArrayList<MateriaBO>> callback);
	
	/**
	 * Este metodo se encarga de buscar las competencias de un programa, luego las convierte en Bussiness Object
	 * y las devuelve en un ArrayList<CompetenciaBO>.
	 * @param busqueda - String - es el tipo de competencia que se desea buscar.
	 * @param programa - String - id del programa en el cual se desea buscar.
	 * @param callback the callback to return programas -ArrayList- con los BussinesObject de las competencias profesionales
	 */
	public void buscarCompetenciaPorPrograma(String busqueda,String programa, AsyncCallback<ArrayList<CompetenciaTerminalBO>> callback);
	
	/**
	 * Este metodo se encarga de buscar lineas de competencias de un programa por id, las convierte en BussinesObject
	 * y las devuelve en un ArrayList<LineaCompetenciaBO>.	 
	 * @param programa - String - id del programa en el que se desea buscar.
	 * @param competencias - String - id de la competencia que se quiere buscar.	 
	 * @param callback the callback to return ArrayList<LineaCompetenciaBO> con los BussinesObject de las lineas de competencias.	 
	 */
	public void buscarLineaDeCompetenciaPorCompetencia(String programa, String competencias, AsyncCallback<ArrayList<CompetenciaEspecificaBO>> callback);
	
	/**
	 * Este metodo se encarga de buscar una competencia especifica a partir del id de un programa
	 * ,del id de un bloque, del id de la competencia especifica, la convierte en BussinesObject
	 * y la devuelve.
	 * @param programa - String - id del programa en el que se desea buscar.
	 * @param competencias - String - id de la competencia que se quiere buscar.
	 * @param bloque - String - id del bloque donde esta la competencia.	 
	 * @param callback the callback to return AsociacionEspecificaBO - BussinessObject de la asociacion especifica.	 
	 */
	public void buscarAsociacionCompetenciaEspecificaMateria (String programa, String bloque, String CompetenciaEspecifica, AsyncCallback<AsociacionEspecificaBO> callback);
	
	/**
	 * Este metodo se encarga de buscar una competencia especifica a partir del id de un programa
	 * ,del id de un bloque, del id de la competencia especifica, la convierte en BussinesObject
	 * y la devuelve.
	 * @param programa - String - id del programa en el que se desea buscar.
	 * @param competencias - String - id de la competencia que se quiere buscar.
	 * @param bloque - String - id del bloque donde esta la competencia.	 
	 * @param callback the callback to return AsociacionEspecificaBO - BussinessObject de la asociacion especifica.	 
	 */
	public void buscarAsociacionCompetenciaEspecificaBloque (String programa, String bloque, String CompetenciaEspecifica, AsyncCallback<AsociacionEspecificaBO> callback);
	
	
}
