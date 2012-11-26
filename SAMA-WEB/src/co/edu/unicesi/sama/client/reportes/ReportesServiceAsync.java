package co.edu.unicesi.sama.client.reportes;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ReportesServiceAsync {

	/**
	 * Este metodo se encarga de crear el reporte de un programa.
	 * @param tipo - int - tipo de reporte.
	 * @param codigoPrograma - String - id del programa.
	 * @param callback the callback to return String - con el resultado de la ejecucion del metodo.
	 */
	public void crearReporte(int tipo, String codigoPrograma, AsyncCallback<String> callback);

}
