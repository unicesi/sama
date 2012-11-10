package co.edu.unicesi.sama.client.competencias;

import co.edu.unicesi.sama.bo.*;

import co.edu.unicesi.sama.client.bloqueMaterias.BloquesMateriaService;
import co.edu.unicesi.sama.client.bloqueMaterias.BloquesMateriaServiceAsync;
import co.edu.unicesi.sama.client.busqueda.BusquedaService;
import co.edu.unicesi.sama.client.busqueda.BusquedaServiceAsync;
import co.edu.unicesi.sama.client.busqueda.ListaProgramas;
import co.edu.unicesi.sama.client.controller.DTEvent;
import co.edu.unicesi.sama.client.model.BloqueModel;

import co.edu.unicesi.sama.client.model.CompetenciaTerminalModel;
import co.edu.unicesi.sama.client.model.CompetenciaEspecificaModel;
import co.edu.unicesi.sama.client.model.MateriaModel;
import co.edu.unicesi.sama.client.model.ProgramaModel;

import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style.IconAlign;
import com.extjs.gxt.ui.client.widget.layout.TableData;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.DualListField;
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.widget.form.ListField;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class PanelCompetenciasTransversales extends LayoutContainer {

	private final BusquedaServiceAsync busquedaService = GWT.create(BusquedaService.class);
	private final BloquesMateriaServiceAsync bloquesMateriaService = GWT.create(BloquesMateriaService.class);
	private final CompetenciasServiceAsync competenciasService = GWT.create(CompetenciasService.class);
	private ProgramaBO programa;
	
	private Grid<CompetenciaTerminalModel> grid;
	private Grid<CompetenciaEspecificaModel> gridAsociadas;
	private Grid<CompetenciaEspecificaModel> gridNoAsociadas;
	private Button btnQuitarLinea;
	private Button btnAgregarLinea;
	public static ArrayList<MateriaBO> materiasAsociadas;
	public static List<MateriaBO> materias;
	
	public PanelCompetenciasTransversales() {
		setSize("770", "462");
		setLayout(new TableLayout(7));
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		grid = new Grid<CompetenciaTerminalModel>(new ListStore<CompetenciaTerminalModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		Registry.register("gridBloques", grid);
		TableData td_grid = new TableData();
		td_grid.setColspan(3);
		add(grid, td_grid);
		grid.setSize("713px", "184px");
		grid.setBorders(true);
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		
		HiddenField hiddenField_13 = new HiddenField();
		add(hiddenField_13);
		add(new Text());
		
		HiddenField hiddenField = new HiddenField();
		add(hiddenField);
		add(new Text());
		add(new Text());
		
		HiddenField hiddenField_14 = new HiddenField();
		add(hiddenField_14);
		add(new Text());
		add(new Text());
		add(new Text());
		
	
	
		add(new Text());
		add(new Text());
		add(new Text());
		
		HiddenField hiddenField_15 = new HiddenField();
		add(hiddenField_15);
		add(new Text());
		
		HiddenField hiddenField_2 = new HiddenField();
		add(hiddenField_2);
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		
		Text txtMateriasDisponibles = new Text("Lineas transversales disponibles");
		add(txtMateriasDisponibles);
		add(new Text());
		
		Text txtMateriasDelBloque = new Text("Lineas asociadas");
		add(txtMateriasDelBloque);
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		
		HiddenField hiddenField_3 = new HiddenField();
		add(hiddenField_3);
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		
		gridNoAsociadas = new Grid<CompetenciaEspecificaModel>(new ListStore<CompetenciaEspecificaModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		Registry.register("gridNoAsociadas", gridNoAsociadas);
		add(gridNoAsociadas);
		gridNoAsociadas.setSize("315", "147");
		gridNoAsociadas.setBorders(true);
		
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new TableLayout(7));
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		
		HiddenField hiddenField_11 = new HiddenField();
		layoutContainer.add(hiddenField_11);
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		
		HiddenField hiddenField_12 = new HiddenField();
		layoutContainer.add(hiddenField_12);
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		
		btnAgregarLinea = new Button(">");
		btnAgregarLinea.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				Dispatcher.forwardEvent(DTEvent.ASOCIAR_LINEA_TRANSVERSAL);
			}
		});
		btnAgregarLinea.setEnabled(false);
		layoutContainer.add(btnAgregarLinea);
		btnAgregarLinea.setWidth("34px");
		
		HiddenField hiddenField_4 = new HiddenField();
		layoutContainer.add(hiddenField_4);
		
		HiddenField hiddenField_6 = new HiddenField();
		layoutContainer.add(hiddenField_6);
		
		HiddenField hiddenField_7 = new HiddenField();
		layoutContainer.add(hiddenField_7);
		
		HiddenField hiddenField_8 = new HiddenField();
		layoutContainer.add(hiddenField_8);
		
		HiddenField hiddenField_9 = new HiddenField();
		layoutContainer.add(hiddenField_9);
		
		HiddenField hiddenField_5 = new HiddenField();
		layoutContainer.add(hiddenField_5);
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		
		HiddenField hiddenField_10 = new HiddenField();
		layoutContainer.add(hiddenField_10);
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		
		btnQuitarLinea = new Button("<");
		btnQuitarLinea.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				Dispatcher.forwardEvent(DTEvent.DESASOCIAR_LINEA_TRANSVERSAL);
				
			}
		});
		btnQuitarLinea.setEnabled(false);
		layoutContainer.add(btnQuitarLinea);
		btnQuitarLinea.setWidth("34px");
		add(layoutContainer);
		layoutContainer.setSize("87px", "138px");
		
		gridAsociadas = new Grid<CompetenciaEspecificaModel>(new ListStore<CompetenciaEspecificaModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		add(gridAsociadas);
		gridAsociadas.setSize("315", "147");
		gridAsociadas.setBorders(true);
		Registry.register("gridAsociadas", gridAsociadas);
		add(new Text());
		

		
		HiddenField hiddenField_1 = new HiddenField();
		eventoSeleccionarCompetenciaTransversal();
		eventoSeleccionarLineaNoAsociada();
		eventoSeleccionarLineaAsociada();

		
		
	}
	
	private void actualizarLista(){
		
		
		busquedaService.buscarCompetenciaPorPrograma("2", String.valueOf(programa.getIdPrograma()),new AsyncCallback<ArrayList<CompetenciaTerminalBO>> (){
			@Override
			public void onFailure(Throwable arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(ArrayList<CompetenciaTerminalBO> result) {
				// TODO Auto-generated method stub
				
				
				Dispatcher.forwardEvent(DTEvent.REFRESCAR_COMPETENCIAS_TRANSVERSALES, result);
			}
		});
		
	}

	public void asignarPrograma(){
		
		this.programa = new ProgramaBO();
		programa.setIdPrograma((String) Registry.get("idPrograma"));
		actualizarLista();
	}
	
	private ColumnModel getColumnModel( )
    {
        List<ColumnConfig> configs = new ArrayList<ColumnConfig>( );

        ColumnConfig column = new ColumnConfig( "id", 60 );
        column.setHeader("ID");
        configs.add( column );

        column = new ColumnConfig( "nombre", 190 );
        column.setAlignment( HorizontalAlignment.LEFT );
        column.setHeader("Nombre");
        configs.add( column );
        
        column = new ColumnConfig( "descripcion", 467 );
        column.setHeader("Descripcion");
        column.setAlignment( HorizontalAlignment.LEFT );
        configs.add( column );

        return new ColumnModel( configs );
    }
	
	private ColumnModel getColumnModelMaterias( )
    {
        List<ColumnConfig> configs = new ArrayList<ColumnConfig>( );

        ColumnConfig column = new ColumnConfig( "id", 60 );
        column.setHeader("ID");
        configs.add( column );

        column = new ColumnConfig( "nombre", 255);
        column.setAlignment( HorizontalAlignment.LEFT );
        column.setHeader("Nombre");
        configs.add( column );
        
        return new ColumnModel( configs );
    }
	
	
	
	public void actualizarListaLineas(ListStore<CompetenciaTerminalModel> lista){

		if(lista!=null){
			
			grid.reconfigure(lista, getColumnModel());			
		}else{
			
			grid.reconfigure(new ListStore<CompetenciaTerminalModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		}
	}
	
	
	public void actualizarListaCompetenciasAsociadas(ListStore<CompetenciaEspecificaModel> listaAsociados){
		
		
		if(listaAsociados != null){
			
			gridAsociadas.reconfigure(listaAsociados, getColumnModelMaterias());
		//	gridAsociadas = new Grid<MateriaModel>(asociadas,getColumnModelMaterias());
//			gridAsociadas.getStore().getLoader().load();
		}else{
			
			gridAsociadas.reconfigure(new ListStore<CompetenciaEspecificaModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		//	gridAsociadas = new Grid<MateriaModel>(asociadas,getColumnModelMaterias());

		}
	}
	
	public void actualziarListaCompetenciasNoAsociadas(ListStore<CompetenciaEspecificaModel> noAsociadas){
		
		
		if(noAsociadas != null){
			
			gridNoAsociadas.reconfigure(noAsociadas, getColumnModelMaterias());
		//	gridAsociadas = new Grid<MateriaModel>(asociadas,getColumnModelMaterias());
//			gridAsociadas.getStore().getLoader().load();
		}else{
			
			gridNoAsociadas.reconfigure(new ListStore<CompetenciaEspecificaModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		//	gridAsociadas = new Grid<MateriaModel>(asociadas,getColumnModelMaterias());

		}
	}
	 void eventoSeleccionarCompetenciaTransversal(){
		
		grid.addListener(Events.CellClick, new Listener<GridEvent<CompetenciaTerminalModel>>(){

			@Override
			public void handleEvent(GridEvent<CompetenciaTerminalModel> be) {
				CompetenciaTerminalModel pM = be.getGrid().getSelectionModel().getSelectedItem();
				Dispatcher.forwardEvent(DTEvent.SELECCIONAR_COMPETENCIA_TRANSVERSAL, pM);
				
			}
			
			
		});
	}
	
	public void cargarLineasProf(){
		
		
		busquedaService.buscarLineaDeCompetenciaPorCompetencia(Registry.get("idPrograma")+"", Registry.get("idCompetenciaTransversal")+"", new AsyncCallback<ArrayList<CompetenciaEspecificaBO>>() {

			@Override
			public void onFailure(Throwable arg0) {
				
				
				
			}

			@Override
			public void onSuccess(ArrayList<CompetenciaEspecificaBO> result) {
				
				
				if(result != null){
					
					
					Dispatcher.forwardEvent(DTEvent.REFRESCAR_LINEA_TRANSVERSAL, result);
					
				}
			}
		});
		
	}
	
	
	private void eventoSeleccionarLineaNoAsociada(){
		
		gridNoAsociadas.addListener(Events.CellClick, new Listener<GridEvent<CompetenciaEspecificaModel>>(){

			@Override
			public void handleEvent(GridEvent<CompetenciaEspecificaModel> be) {
				System.out.println("eventoNoasociadaLinea");
				CompetenciaEspecificaModel pM = be.getGrid().getSelectionModel().getSelectedItem();
				Registry.register("lineaNoAsociada",pM);
				Registry.register("idLineaNoAsociada", pM.getId());
				btnAgregarLinea.setEnabled(true);
			}
			
			
		});
	}
	
	private void eventoSeleccionarLineaAsociada(){
		
		gridAsociadas.addListener(Events.CellClick, new Listener<GridEvent<CompetenciaEspecificaModel>>(){

			@Override
			public void handleEvent(GridEvent<CompetenciaEspecificaModel> be) {
				System.out.println("eventoasociadaLinea");
				CompetenciaEspecificaModel pM = be.getGrid().getSelectionModel().getSelectedItem();
				Registry.register("lineaAsociada",pM);
				Registry.register("idLineaAsociada",pM.getId());
				btnQuitarLinea.setEnabled(true);	
			}
			
			
		});
	}

	public void asociarLinea() {
		if(Registry.get("idLineaNoAsociada")!=null){
			competenciasService.crearLinea(Registry.get("idLineaNoAsociada")+"",Registry.get("idPrograma")+"", new AsyncCallback<String>(){
	
			@Override
			public void onFailure(Throwable arg0) {
				Info.display("Bloques","Ha ocurrido un error asociando la materia al bloque");
				
			}

			@Override
			public void onSuccess(String result) {

				//TODO 
//				gridAsociadas = new Grid<MateriaModel>(new ListStore<MateriaModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
//				gridNoAsociadas = new Grid<MateriaModel>(new ListStore<MateriaModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
				
				cargarLineasProf();
				Info.display("Materias", "<ul><li>" + (result.equals("Error") ?
						"Ha ocurrido un error asociando la linea al programa" : "Se ha asociado la linea al programa exitosamente") + "</li></ul>");
				Registry.register("idLineaNoAsociada",null);
			}
			
			
		});}else{
			Info.display("Lineas", "<ul><li>" + "Debe escoger una Linea para asociar" + "</li></ul>");
		}
		
	}

	public void desasociarLinea() {
		// TODO Auto-generated method stub
		if(Registry.get("idLineaAsociada")!=null){
			competenciasService.eliminarLinea(Registry.get("idLineaAsociada")+"",Registry.get("idPrograma")+"", new AsyncCallback<String>(){
			
			@Override
			public void onFailure(Throwable arg0) {
				Info.display("Bloques","Ha ocurrido un error elminando la asociacion de la materia al bloque");
				
			}

			@Override
			public void onSuccess(String result) {

				//TODO 
//				gridAsociadas = new Grid<MateriaModel>(new ListStore<MateriaModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
//				gridNoAsociadas = new Grid<MateriaModel>(new ListStore<MateriaModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
				
				cargarLineasProf();
				Info.display("Bloques", "<ul><li>" + (result.equals("Error") ?
						"Ha ocurrido un error desasociando la linea del programa" : "Se ha desasociado la linea al programa exitosamente") + "</li></ul>");
				Registry.register("idLineaAsociada",null);
			}
			
			
		});
		
	}else{
		Info.display("Lineas", "<ul><li>" + "Debe escoger una Linea para desasociar" + "</li></ul>");
	}
	}

	public void limpiar() {
		// TODO Auto-generated method stub
		gridAsociadas.reconfigure(new ListStore<CompetenciaEspecificaModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		gridNoAsociadas.reconfigure(new ListStore<CompetenciaEspecificaModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		
	}


	
	
}
