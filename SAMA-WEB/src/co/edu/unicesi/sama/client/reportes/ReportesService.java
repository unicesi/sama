package co.edu.unicesi.sama.client.reportes;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("servletReportes")
public interface ReportesService extends RemoteService {

	/**
	 * Este metodo se encarga de crear el reporte de un programa.
	 * @param tipo - int - tipo de reporte.
	 * @param codigoPrograma - String - id del programa.
	 * @return String - con el resultado de la ejecucion del metodo.
	 */
	public String crearReporte(int tipo, String codigoPrograma);

}
