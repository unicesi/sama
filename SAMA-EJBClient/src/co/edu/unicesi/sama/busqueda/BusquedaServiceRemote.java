package co.edu.unicesi.sama.busqueda;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remote;

import co.edu.unicesi.sama.bo.AsociacionEspecificaBO;
import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.BloquesMateriaPKBO;
import co.edu.unicesi.sama.bo.CompetenciaTerminalBO;
import co.edu.unicesi.sama.bo.CompetenciaEspecificaBO;
import co.edu.unicesi.sama.bo.MateriaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;

/**
 * Esta interfaz provee los metodos para realizar las consultas sobre los programas, materias, bloques y bloquesMateria de manera remota
 */
@Remote
public interface BusquedaServiceRemote {

	/**
	 * Este metodo se encarga de buscar los programas, los convierte en BussinesObject
	 *  y los retorna en un ArrayList<ProgramaBO> ordenados alfabeticamente por nombre.
	 *  @return ArrayList<ProgramaBO> con los programasBO ordenados por nombre. 
	 */
	public ArrayList<ProgramaBO> darProgramasOrdenadosPorNombre();

	/**
	 * Este metodo se encarga de buscar los bloques por programa, los convierte en BussinesObject
	 * y los devuelve en un ArrayList<BloqueBo>.
	 * @param programa - ProgramaBO , es el BussinesObject del programa del cual se desea obtener sus bloques.
	 * @return ArrayList<BloqueBO> con los bloqueBO del programa dado por parametro. 
	 */
	public ArrayList<BloqueBO> darBloqueporPrograma(ProgramaBO programa);

	/**
	 * Este metodo se encarga de buscar los bloques, los convierte en Bussiness Object y los
	 * devuelve en un ArrayList<BloqueBO>.
	 * @param busqueda - String - id del bloque que se desea buscar.
	 * @return ArrayList<BloqueBO> con los Bussiness Object de los bloques encontrados.
	 */
	public List<BloqueBO> buscarMateriaBloquePorBloque(String busqueda);

	/**
	 * Este metodo se encarga de buscar las materias en un bloque especifico,
	 * las convierte en BussinesObject y las devuelve en un ArrayList<MateriaBO> 
	 * ordenados alfabeticamente por nombre.
	 * @param busqueda - String - con el id del bloque donde esta la materia.
	 * @return ArrayList<MateriaBO> con las materiasBO ordenadas por nombre.
	 */
	public ArrayList<MateriaBO> darMateriasOrdenadosPorNombre(String busqueda);

	/**
	 * Este metodo se encarga de buscar competencias en un programa por tipo, las competencias encontradas se
	 *  convierten en BussinesObject y las devuelve en un ArrayList<CompetenciaBO>.
	 * @param busqueda - String - tipo de la competencia que se desea buscar.
	 * @param programa - String - id del programa en el cual se desea buscar la competencia.
	 * @return ArrayList<CompetenciaBO> con las competencias del programa. 
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
