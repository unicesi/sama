package co.edu.unicesi.sama.client.bloques;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.BloquesMateriaPKBO;
import co.edu.unicesi.sama.bo.MateriaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.client.bloqueMaterias.BloquesMateriaService;
import co.edu.unicesi.sama.client.bloqueMaterias.BloquesMateriaServiceAsync;
import co.edu.unicesi.sama.client.busqueda.BusquedaService;
import co.edu.unicesi.sama.client.busqueda.BusquedaServiceAsync;
import co.edu.unicesi.sama.client.busqueda.ListaProgramas;
import co.edu.unicesi.sama.client.controller.DTEvent;
import co.edu.unicesi.sama.client.model.BloqueModel;
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

public class PanelBloques extends LayoutContainer {

	private final BusquedaServiceAsync busquedaService = GWT.create(BusquedaService.class);
	private final BloquesMateriaServiceAsync bloquesMateriaService = GWT.create(BloquesMateriaService.class);
	private ProgramaBO programa;
	private VentanaBloque ventanaBloque;
	private Grid<BloqueModel> grid;
	private Grid<MateriaModel> gridAsociadas;
	private Grid<MateriaModel> gridNoAsociadas;
	private Button btnQuitarMateriaBloque;
	private Button btnAgregarMateriaBloque;
	public static ArrayList<MateriaBO> materiasAsociadas;
	public static List<MateriaBO> materias;

	/**
	 * Constructor del panel. Se inicializan los elementos , se agregan y se manejan los eventos.
	 */
	public PanelBloques() {
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
		ventanaBloque = new VentanaBloque();
		ventanaBloque.setVisible(false);
		Registry.register("ventanaBloque", ventanaBloque);
		add(new Text());
		add(new Text());
		add(new Text());
		grid = new Grid<BloqueModel>(new ListStore<BloqueModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		Registry.register("gridBloques", grid);
		TableData td_grid = new TableData();
		td_grid.setColspan(3);
		add(grid, td_grid);
		grid.setSize("717px", "184px");
		grid.setBorders(true);
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

		Button btnAgregarBloque = new Button("Agregar Bloque");
		btnAgregarBloque.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {

				ventanaBloque.setVisible(true);
			}
		});
		add(btnAgregarBloque);
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

		Text txtMateriasDisponibles = new Text("Materias disponibles");
		add(txtMateriasDisponibles);
		add(new Text());

		Text txtMateriasDelBloque = new Text("Materias del bloque");
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

		gridNoAsociadas = new Grid<MateriaModel>(new ListStore<MateriaModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
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

		btnAgregarMateriaBloque = new Button(">");
		btnAgregarMateriaBloque.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {

				Dispatcher.forwardEvent(DTEvent.ASOCIAR_MATERIA);
			}
		});
		btnAgregarMateriaBloque.setEnabled(false);
		layoutContainer.add(btnAgregarMateriaBloque);
		btnAgregarMateriaBloque.setWidth("34px");

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

		btnQuitarMateriaBloque = new Button("<");
		btnQuitarMateriaBloque.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				Dispatcher.forwardEvent(DTEvent.DESASOCIAR_MATERIA);

			}
		});
		btnQuitarMateriaBloque.setEnabled(false);
		layoutContainer.add(btnQuitarMateriaBloque);
		btnQuitarMateriaBloque.setWidth("34px");
		add(layoutContainer);
		layoutContainer.setSize("87px", "138px");

		gridAsociadas = new Grid<MateriaModel>(new ListStore<MateriaModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		add(gridAsociadas);
		gridAsociadas.setSize("315", "147");
		gridAsociadas.setBorders(true);
		Registry.register("gridAsociadas", gridAsociadas);



		HiddenField hiddenField_1 = new HiddenField();
		eventoSeleccionarBloques();
		eventoSeleccionarMateriaNoAsociada();
		eventoSeleccionarMateriaAsociada();



	}

	/**
	 * Este metodo se encarga de actualizar las listas.
	 */
	private void actualizarLista(){

		busquedaService.darBloqueporPrograma(programa,new AsyncCallback<ArrayList<BloqueBO>> (){
			@Override
			public void onFailure(Throwable arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(ArrayList<BloqueBO> result) {
				// TODO Auto-generated method stub
				Dispatcher.forwardEvent(DTEvent.REFRESCAR_BLOQUES, result);
			}
		});

	}

	/**
	 * Este metodo se encarga de asignar un programa al panel.
	 */
	public void asignarPrograma(){

		this.programa = new ProgramaBO();
		programa.setIdPrograma( (String)Registry.get("idPrograma"));
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


	/**
	 * Este metodo se encarga de actualizar la lista de bloques del panel.
	 * 
	 * @param lista con los bloques que se quieren mostrar en el panel.
	 */
	public void actualizarListaBloques(ListStore<BloqueModel> lista){

		if(lista!=null){

			grid.reconfigure(lista, getColumnModel());			
		}else{

			grid.reconfigure(new ListStore<BloqueModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		}
	}

	/**
	 * Este metodo se encarga de actualizar la lista de bloques del panel.
	 * 
	 * @param asociadas Lista de materias asociadas al programa.
	 * @param noAsociadas Lista de materias no asociadas.
	 */
	public void actualizarListaMaterias(ListStore<MateriaModel> asociadas, ListStore<MateriaModel> noAsociadas){

		if(asociadas != null){

			gridAsociadas.reconfigure(asociadas, getColumnModelMaterias());
			//	gridAsociadas = new Grid<MateriaModel>(asociadas,getColumnModelMaterias());
			//			gridAsociadas.getStore().getLoader().load();
		}else{

			gridAsociadas.reconfigure(new ListStore<MateriaModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
			//	gridAsociadas = new Grid<MateriaModel>(asociadas,getColumnModelMaterias());

		}
		//		
		//		
		if(noAsociadas != null){

			gridNoAsociadas.reconfigure(noAsociadas, getColumnModelMaterias());
			//	gridNoAsociadas = new Grid<MateriaModel>(noAsociadas,getColumnModelMaterias());
			//			gridNoAsociadas.getStore().getLoader().load();
		}else{

			gridNoAsociadas.reconfigure(new ListStore<MateriaModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
			//gridNoAsociadas = new Grid<MateriaModel>(noAsociadas,getColumnModelMaterias());
		}


	}
	public void actualizarListaMateriasAsociadas(ListStore<MateriaModel> asociadas){


		if(asociadas != null){

			gridAsociadas.reconfigure(asociadas, getColumnModelMaterias());
			//	gridAsociadas = new Grid<MateriaModel>(asociadas,getColumnModelMaterias());
			//			gridAsociadas.getStore().getLoader().load();
		}else{

			gridAsociadas.reconfigure(new ListStore<MateriaModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
			//	gridAsociadas = new Grid<MateriaModel>(asociadas,getColumnModelMaterias());

		}
	}

	public void actualziarListaMateriasNoAsociadas(ListStore<MateriaModel> noAsociadas){


		if(noAsociadas != null){

			gridNoAsociadas.reconfigure(noAsociadas, getColumnModelMaterias());
			//	gridAsociadas = new Grid<MateriaModel>(asociadas,getColumnModelMaterias());
			//			gridAsociadas.getStore().getLoader().load();
		}else{

			gridNoAsociadas.reconfigure(new ListStore<MateriaModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
			//	gridAsociadas = new Grid<MateriaModel>(asociadas,getColumnModelMaterias());

		}
	}
	void eventoSeleccionarBloques(){

		grid.addListener(Events.CellClick, new Listener<GridEvent<BloqueModel>>(){

			@Override
			public void handleEvent(GridEvent<BloqueModel> be) {
				BloqueModel pM = be.getGrid().getSelectionModel().getSelectedItem();
				Dispatcher.forwardEvent(DTEvent.SELECCIONAR_BLOQUE, pM);

			}


		});
	}

	/**
	 * Este metodo se encarga de cargar las materias y mostrarlas en el panel. 
	 */
	public void cargarMaterias(){

		busquedaService.darMateriasOrdenadosPorNombre(Registry.get("idBloque")+"",new AsyncCallback<ArrayList<MateriaBO>>() {

			@Override
			public void onFailure(Throwable arg0) {



			}

			@Override
			public void onSuccess(ArrayList<MateriaBO> result) {

				if(result != null){


					Dispatcher.forwardEvent(DTEvent.REFRESCAR_MATERIAS_BLOQUESNOASOCIADAS, result);

				}
			}
		});
		cargarMateriasAsociadas();
	}

	public void cargarMateriasAsociadas(){

		busquedaService.buscarMateriaBloquePorBloque(Registry.get("idBloque")+"", new AsyncCallback<ArrayList<MateriaBO>>() {

			@Override
			public void onFailure(Throwable arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(ArrayList<MateriaBO> result) {

				if(result != null){
					//					materiasAsociadas = new ArrayList<MateriaBO>();

					//					llenarListas();
					Dispatcher.forwardEvent(DTEvent.REFRESCAR_MATERIAS_BLOQUES, result);

				}


			}
		});	
	}
	public void llenarListas(){


		if(materias != null){

			ArrayList<MateriaBO> materias1 = new ArrayList<MateriaBO>();
			for(MateriaBO m:materias){

				materias1.add(m);
			}
			for(MateriaBO m:materias1){

				if(materiasAsociadas != null){

					for(MateriaBO pk : materiasAsociadas){

						if(m.getIdMateria()==pk.getIdMateria()){

							materias.remove(m);
						}
					}
				}
			}

			ListStore<MateriaModel> storeNoAsociadas = null;
			ListStore<MateriaModel> storeAsociadas = null;

			if(materias.size()>0){

				storeNoAsociadas = new ListStore<MateriaModel>();
				for(MateriaBO a: materias){

					MateriaModel model = MateriaModel.toModelFromBO(a);
					storeNoAsociadas.add(model);
				}
			}

			if(materiasAsociadas.size()>0){

				storeAsociadas = new ListStore<MateriaModel>();
				for(MateriaBO b: materiasAsociadas){

					MateriaModel model = MateriaModel.toModelFromBO(b);
					storeAsociadas.add(model);
				}
			}

			actualizarListaMaterias(storeAsociadas, storeNoAsociadas);

		}


	}

	private void eventoSeleccionarMateriaNoAsociada(){

		gridNoAsociadas.addListener(Events.CellClick, new Listener<GridEvent<MateriaModel>>(){

			@Override
			public void handleEvent(GridEvent<MateriaModel> be) {
				MateriaModel pM = be.getGrid().getSelectionModel().getSelectedItem();
				Registry.register("materiaNoAsociada",pM);
				Registry.register("idMateriaNoAsociada", pM.getId());
				btnAgregarMateriaBloque.setEnabled(true);
			}


		});
	}

	private void eventoSeleccionarMateriaAsociada(){

		gridAsociadas.addListener(Events.CellClick, new Listener<GridEvent<MateriaModel>>(){

			@Override
			public void handleEvent(GridEvent<MateriaModel> be) {
				MateriaModel pM = be.getGrid().getSelectionModel().getSelectedItem();
				Registry.register("materiaAsociada",pM);
				Registry.register("idMateriaAsociada",pM.getId());
				btnQuitarMateriaBloque.setEnabled(true);	
			}


		});
	}

	public void asociarMateria() {
		if(Registry.get("idMateriaNoAsociada")!=null){
			bloquesMateriaService.crearBloquesMateria(""+Registry.get("idBloque"), ""+ Registry.get("idMateriaNoAsociada"), new AsyncCallback<String>(){

				@Override
				public void onFailure(Throwable arg0) {
					Info.display("Bloques","Ha ocurrido un error asociando la materia al bloque");

				}

				@Override
				public void onSuccess(String result) {

					//TODO 
					//				gridAsociadas = new Grid<MateriaModel>(new ListStore<MateriaModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
					//				gridNoAsociadas = new Grid<MateriaModel>(new ListStore<MateriaModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));

					cargarMaterias();
					Info.display("Materias", "<ul><li>" + (result.equals("Error") ?
							"Ha ocurrido un error asociando la materia al bloque" : "Se ha asociado la materia al bloque exitosamente") + "</li></ul>");
					Registry.register("idMateriaNoAsociada",null);
				}


			});}else{
				Info.display("Materias", "<ul><li>" + "Debe escoger una materia pra asociar" + "</li></ul>");
			}

	}

	public void desasociarMateria() {
		// TODO Auto-generated method stub
		if(Registry.get("idMateriaAsociada")!=null){
			bloquesMateriaService.eliminarBloquesMateria(""+Registry.get("idBloque"), ""+ Registry.get("idMateriaAsociada"), new AsyncCallback<String>(){

				@Override
				public void onFailure(Throwable arg0) {
					Info.display("Bloques","Ha ocurrido un error elminando la asociacion de la materia al bloque");

				}

				@Override
				public void onSuccess(String result) {

					//TODO 
					//				gridAsociadas = new Grid<MateriaModel>(new ListStore<MateriaModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
					//				gridNoAsociadas = new Grid<MateriaModel>(new ListStore<MateriaModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));

					cargarMaterias();
					Info.display("Bloques", "<ul><li>" + (result.equals("Error") ?
							"Ha ocurrido un error desasociando la materia al bloque" : "Se ha desasociado la materia al bloque exitosamente") + "</li></ul>");
					Registry.register("idMateriaAsociada",null);
				}


			});

		}else{
			Info.display("Materias", "<ul><li>" + "Debe escoger una materia para desasociar" + "</li></ul>");
		}
	}

	public void limpiar() {
		// TODO Auto-generated method stub
		gridNoAsociadas.reconfigure(new ListStore<MateriaModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		gridAsociadas.reconfigure(new ListStore<MateriaModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
	}


}
