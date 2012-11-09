package co.edu.unicesi.sama.dbutil;

/**
 * Clase encargada de guardar el valor de la unidad de persistencia que utiliza el Entity Manager
 */
public class DBUtil 
{
	
	private static final String PU_DTProduccion = "DTPersistenceUnit";

	private static final String PU_DTTest = "DTPersistenceUnitTest";
	
	/**
	 * Unidad de persistencia que usa el Entity Manager para conectarse a la base de datos
	 * NO MODIFICAR
	 */
	public static final String PU_DT = PU_DTProduccion;
}
