package co.edu.unicesi.sama.busqueda;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

import co.edu.unicesi.sama.bo.AsociacionEspecificaBO;
import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.BloquesMateriaPKBO;
import co.edu.unicesi.sama.bo.CompetenciaTerminalBO;
import co.edu.unicesi.sama.bo.CompetenciaEspecificaBO;
import co.edu.unicesi.sama.bo.MateriaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;

/**
 * Esta interfaz provee los metodos para realizar las consultas sobre los programas, materias, bloques y bloquesMateria de manera local
 */
@Local
public interface BusquedaServiceLocal {

	/**
	 * Este metodo se encarga de buscar los programas, los convierte en BussinesObject
	 *  y los retorna en un ArrayList<ProgramaBO> ordenados alfabeticamente por nombre.
	 *  
	 *   @return ArrayList<ProgramaBO> con los programasBO ordenados por nombre. 
	 */
	public ArrayList<ProgramaBO> darProgramasOrdenadosPorNombre();

	/**
	 * Este metodo se encarga de buscar las materias en un bloque especifico,
	 * las convierte en BussinesObject y las devuelve en un ArrayList<MateriaBO> 
	 * ordenados alfabeticamente por nombre.
	 * @param busqueda - String - con el id del bloque donde esta la materia.
	 * @return ArrayList<MateriaBO> con las materiasBO ordenadas por nombre.
	 */
	public ArrayList<MateriaBO> darMateriasOrdenadosPorNombre(String busqueda);

	/**
	 * Este metodo se encarga de buscar los bloques de un Bussiness Object de un programa
	 * @param programa - ProgramaBO - BussinesObject del programa del cual se desea obtener los bloques.
	 * @return bloques -ArrayList- con los BussinesObject de los bloques del programa.
	 */
	public ArrayList<BloqueBO> darBloqueporPrograma(ProgramaBO programa);

	/**
	 * Este metodo se encarga de buscar un bloque de materias, los convierte en BussinesObject
	 * y los devuelve en un List<BloqueBO>.
	 * @param busqueda - String, es el id del bloque que se quiere buscar.
	 * @return List<BloqueBo> con los bloqueBO buscados.
	 */
	public List<BloqueBO> buscarMateriaBloquePorBloque(String busqueda);

	/**
	 * Este metodo se encarga de buscar las competencias de un programa, luego las convierte en Bussiness Object
	 * y las devuelve en un ArrayList<CompetenciaBO>.
	 * @param busqueda - String - es el tipo de competencia que se desea buscar.
	 * @param programa - String - id del programa en el cual se desea buscar.
	 * @return programas -ArrayList- con los BussinesObject de las competencias profesionales
	 */
	public ArrayList<CompetenciaTerminalBO> buscarCompetenciaPorPrograma(String busqueda, String programa);

	/**
	 * Este metodo se encarga de buscar lineas de competencias de un programa por id, las convierte en BussinesObject
	 * y las devuelve en un ArrayList<LineaCompetenciaBO>.	 
	 * @param programa - String - id del programa en el que se desea buscar.
	 * @param competencias - String - id de la competencia que se quiere buscar.	 
	 * @return ArrayList<LineaCompetenciaBO> con los BussinesObject de las lineas de competencias.	 
	 */
	public ArrayList<CompetenciaEspecificaBO> buscarLineaDeCompetenciaPorCompetencia(String programa, String competencias);

	/**
	 * Este metodo se encarga de buscar una competencia especifica a partir del id de un programa
	 * ,del id de un bloque, del id de la competencia especifica, la convierte en BussinesObject
	 * y la devuelve.
	 * @param programa - String - id del programa en el que se desea buscar.
	 * @param competencias - String - id de la competencia que se quiere buscar.
	 * @param bloque - String - id del bloque donde esta la competencia.	 
	 * @return AsociacionEspecificaBO - BussinessObject de la asociacion especifica.	 
	 */
	public AsociacionEspecificaBO buscarAsociacionCompetenciaEspecificaMateria (String programa, String bloque, String CompetenciaEspecifica);

	/**
	 * Este metodo se encarga de buscar una competencia especifica a partir del id de un programa
	 * ,del id de un bloque, del id de la competencia especifica, la convierte en BussinesObject
	 * y la devuelve.
	 * @param programa - String - id del programa en el que se desea buscar.
	 * @param competencias - String - id de la competencia que se quiere buscar.
	 * @param bloque - String - id del bloque donde esta la competencia.	 
	 * @return AsociacionEspecificaBO - BussinessObject de la asociacion especifica.	 
	 */
	public AsociacionEspecificaBO buscarAsociacionCompetenciaEspecificaBloque (String programa, String bloque, String CompetenciaEspecifica);


}
