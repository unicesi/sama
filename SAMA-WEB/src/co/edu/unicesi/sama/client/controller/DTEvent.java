package co.edu.unicesi.sama.client.controller;

import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.mvc.AppEvent;

public class DTEvent
{
	
	public static final EventType REFRESCAR_PROGRAMAS = new EventType();
	
	public static final EventType REFRESCAR_MATERIAS = new EventType();

	public static final EventType REFRESCAR_BLOQUES = new EventType();

	public static final EventType REFRESCAR_MATERIAS_BLOQUES = new EventType();

	public static final EventType REFRESCAR_COMPETENCIAS_PROFESIONALES = new EventType();

	public static final EventType REFRESCAR_COMPETENCIAS_TRANSVERSALES= new EventType();
	
	public static final EventType SELECCIONAR_PROGRAMA = new EventType();
	
	public static final EventType SELECCIONAR_BLOQUE = new EventType();
	
	public static final EventType SELECCIONAR_LINEAPROFESIONAL = new EventType();
	
	public static final EventType ASOCIAR_MATERIA = new EventType();
	
	public static final EventType DESASOCIAR_MATERIA = new EventType();
	
	public static final EventType ASOCIAR_LINEA_PROFESIONAL = new EventType();
	
	public static final EventType DESASOCIAR_LINEA_PROFESIONAL = new EventType();
	
	public static final EventType ASOCIAR_LINEA_TRANSVERSAL = new EventType();
	
	public static final EventType DESASOCIAR_LINEA_TRANSVERSAL = new EventType();

	public static final EventType REFRESCAR_MATERIAS_BLOQUESNOASOCIADAS= new EventType();
	
	public static final EventType REFRESCAR_LINEA_PROFESIONALNOASOCIADAS= new EventType();
	
	public static final EventType REFRESCAR_LINEA_PROFESIONAL= new EventType();
	
	public static final EventType REFRESCAR_LINEA_TRANSVERSALNOASOCIADAS= new EventType();
	
	public static final EventType REFRESCAR_LINEA_TRANSVERSAL= new EventType();
	
	public static final EventType SELECCIONAR_COMPETENCIA_PROFESIONAL= new EventType();
	
	public static final EventType SELECCIONAR_COMPETENCIA_TRANSVERSAL= new EventType();
	
	public static final EventType REFRESCAR_COMPETENCIA_ESPECIFICA= new EventType();
	
	public static final EventType REFRESCAR_FILTRO= new EventType();

	public static final EventType FILTRAR_BLOQUE= new EventType();
	
	public static final EventType DESFILTRAR_BLOQUE= new EventType();
	
	public static final EventType FILTRAR_TRANSVERSAL= new EventType();
	
	public static final EventType DESFILTRAR_TRANSVERSAL= new EventType();
	
	public static final EventType FILTRAR_PROFESIONAL= new EventType();
	
	public static final EventType DESFILTRAR_PROFESIONAL= new EventType();
	
	public static final EventType CAMBIAR_PANELES = new EventType();
	
	public static final EventType ACTUALIZAR_BLOQUES_FILTRO = new EventType();
	
	public static final EventType CERRAR_VENTANA_BLOQUEFILTRO = new EventType();
	
	public static final EventType ABRIR_BLOQUE_FILTRO = new EventType();
	
	public static final EventType REFRESCAR_MATERIAS_FILTRO = new EventType();
	
	public static final EventType CERRAR_VENTANA_MATERIAFILTRO = new EventType();
	
	public static final EventType ABRIR_MATERIA_FILTRO = new EventType();
	
	public static final EventType ACTUALIZARCHK_BLOQUE = new EventType();
	
	public static final EventType ACTUALIZARCHK_MATERIA = new EventType();
	
public static final EventType CONSULTAR_MATERIA = new EventType();
	
	public static final EventType CONSULTAR_BLOQUE = new EventType();
	
	public static final EventType CONSULTAR_BLOQUE2 = new EventType();
	
	public static final EventType ACTUALIZAR_REPORTE = new EventType();
	
	public static final EventType ACTUALIZAR_REPORTE_BLOQUES = new EventType();
	

	
	
	public static AppEvent getAppEvent(EventType ev)
	{
		return new AppEvent(ev);
	}
}
