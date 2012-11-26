package co.edu.unicesi.sama.server;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;

import co.edu.unicesi.sama.client.reportes.ReportesService;

import com.extjs.gxt.ui.client.Registry;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.view.JasperViewer;

public class ReportesServiceImpl extends RemoteServiceServlet implements ReportesService{

	private Connection conexion;
	private int contB;
	private int contM;
	
	@SuppressWarnings("serial")
	public ReportesServiceImpl(){
		contB = 0;
		contM = 0;
		System.out.println("Entra al reportesImpl");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_sdac", "root", "root");
		} catch (ClassNotFoundException e) {
			System.out.println("No se encuentra el driver de la BD");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("No se puede conectar a la BD");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String crearReporte(int tipo, String codigoPrograma){
		
		System.out.println("Entra a crear el reporte");
		JasperReport jasperReport;
		JasperPrint jasperPrint;
		//TODO Registrar el c—digo del programa cuando se selecciona
		//String codigoPrograma = Registry.get("codigoPrograma");
		//Reporte Bloques Competencia
		if (tipo == 1 ){
			System.out.println("Entra a crear el reporte");
			Map <String, Object> parametros = new HashMap<String, Object>();
            parametros.put("CodigoPrograma", codigoPrograma);
            try {
            	jasperReport = JasperCompileManager.compileReport("/Users/jdominguez92/Documents/Ingenieria de Software/ReporteBloquesCompetencias1.jrxml");
				jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, conexion);
				String direccion = "/Users/jdominguez92/Desktop/Programas Ingenieria de Software/Glassfish1/glassfish3/glassfish/domains/domain1/eclipseApps/SAMA-WEB/ReporteBloques" + contB +".pdf";
				String direccionWeb = "http://localhost:8080/SAMA-WEB/ReporteBloques"+contB+".pdf";
				contB++;
				JasperExportManager.exportReportToPdfFile(jasperPrint, direccion);
				return direccionWeb;
			} catch (JRException e) {
				e.printStackTrace();
				return "Error";

			}
		}else{
			Map <String, Object> parametros = new HashMap<String, Object>();
            parametros.put("CodigoPrograma", codigoPrograma);
            try {
            	jasperReport = JasperCompileManager.compileReport("/Users/jdominguez92/Documents/Ingenieria de Software/ReporteMateriasCompetencias.jrxml");
				jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, conexion);
				String direccion = "/Users/jdominguez92/Desktop/Programas Ingenieria de Software/Glassfish1/glassfish3/glassfish/domains/domain1/eclipseApps/SAMA-WEB/ReporteMaterias" + contM +".pdf";
				String direccionWeb = "http://localhost:8080/SAMA-WEB/ReporteMaterias"+contB+".pdf";
				contM++;
				JasperExportManager.exportReportToPdfFile(jasperPrint, direccion);
				return direccionWeb;
			} catch (JRException e) {
				e.printStackTrace();
				return "Error";

			}
			
		}
	}
	
}
