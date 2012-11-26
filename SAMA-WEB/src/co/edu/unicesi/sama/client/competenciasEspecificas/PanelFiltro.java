package co.edu.unicesi.sama.client.competenciasEspecificas;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.CompetenciaEspecificaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.client.busqueda.BusquedaService;
import co.edu.unicesi.sama.client.busqueda.BusquedaServiceAsync;
import co.edu.unicesi.sama.client.controller.DTEvent;
import co.edu.unicesi.sama.client.model.BloqueModel;
import co.edu.unicesi.sama.client.model.CompetenciaEspecificaModel;
import co.edu.unicesi.sama.client.model.CompetenciaTerminalModel;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class PanelFiltro extends LayoutContainer {

	private Grid gridBloquesDisponibles;
	private Grid gridProfesionalesDisponibles;
	private Grid gridTransversalesDisponibles;
	private Grid gridBloquesSeleccionados;
	private Grid gridProfesionalesSeleccionadas;
	private Grid gridTransversalesSeleccionadas;
	private Button retirarBloque;
	private Button seleccionarProfesional;
	private Button retirarProfesional;
	private Button seleccionarTransversal;
	private Button seleccionarBloque;
	private Button retirarTransversal ;

	private final BusquedaServiceAsync busquedaService = GWT.create(BusquedaService.class);
	private ProgramaBO programa;
	public PanelFiltro() {
		setSize("760", "795px");
		setLayout(new TableLayout(7));
		add(new Text());
		add(new Text());
		add(new Text());

		HiddenField hiddenField_5 = new HiddenField();
		add(hiddenField_5);
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());

		HiddenField hiddenField_6 = new HiddenField();
		add(hiddenField_6);
		add(new Text());

		Text txtBloquesDisponibles = new Text("Bloques disponibles");
		add(txtBloquesDisponibles);
		add(new Text());

		Text txtBloquesSeleccionados = new Text("Bloques seleccionados");
		add(txtBloquesSeleccionados);
		add(new Text());

		HiddenField hiddenField_7 = new HiddenField();
		add(hiddenField_7);
		add(new Text());
		add(new Text());

		HiddenField hiddenField = new HiddenField();
		add(hiddenField);
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());

		gridBloquesDisponibles = new Grid(new ListStore(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		Registry.register("gridBloquesDisponibles", gridBloquesDisponibles);
		add(gridBloquesDisponibles);
		gridBloquesDisponibles.setSize("315", "200");
		gridBloquesDisponibles.setBorders(true);

		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new TableLayout(7));
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());

		HiddenField hiddenField_10 = new HiddenField();
		layoutContainer.add(hiddenField_10);

		HiddenField hiddenField_9 = new HiddenField();
		layoutContainer.add(hiddenField_9);

		HiddenField hiddenField_19 = new HiddenField();
		layoutContainer.add(hiddenField_19);

		HiddenField hiddenField_18 = new HiddenField();
		layoutContainer.add(hiddenField_18);

		HiddenField hiddenField_20 = new HiddenField();
		layoutContainer.add(hiddenField_20);

		HiddenField hiddenField_17 = new HiddenField();
		layoutContainer.add(hiddenField_17);

		HiddenField hiddenField_16 = new HiddenField();
		layoutContainer.add(hiddenField_16);

		seleccionarBloque = new Button(">");
		seleccionarBloque.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {

				Dispatcher.forwardEvent(DTEvent.FILTRAR_BLOQUE);
			}
		});
		layoutContainer.add(seleccionarBloque);
		seleccionarBloque.setSize("34", "22");
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());

		HiddenField hiddenField_15 = new HiddenField();
		layoutContainer.add(hiddenField_15);
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());

		retirarBloque = new Button("<");
		retirarBloque.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {

				Dispatcher.forwardEvent(DTEvent.DESFILTRAR_BLOQUE);
			}
		});
		layoutContainer.add(retirarBloque);
		retirarBloque.setSize("34", "22");
		add(layoutContainer);
		layoutContainer.setSize("87", "164px");

		gridBloquesSeleccionados = new Grid(new ListStore(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		Registry.register("gridBloquesSeleccionados", gridBloquesSeleccionados);
		add(gridBloquesSeleccionados);
		gridBloquesSeleccionados.setSize("315", "200");
		gridBloquesSeleccionados.setBorders(true);
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());

		HiddenField hiddenField_1 = new HiddenField();
		add(hiddenField_1);
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());

		Text txtCompetenciasProfesionalesDisponibles = new Text("Competencias profesionales disponibles");
		add(txtCompetenciasProfesionalesDisponibles);
		add(new Text());

		Text txtCompetenciasProfesionalesSeleccionadas = new Text("Competencias profesionales seleccionadas");
		add(txtCompetenciasProfesionalesSeleccionadas);
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());

		HiddenField hiddenField_2 = new HiddenField();
		add(hiddenField_2);
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());

		gridProfesionalesDisponibles = new Grid(new ListStore(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		Registry.register("gridProfesionalesDisponibles", gridProfesionalesDisponibles);
		add(gridProfesionalesDisponibles);
		gridProfesionalesDisponibles.setSize("315", "200");
		gridProfesionalesDisponibles.setBorders(true);

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_1.setLayout(new TableLayout(7));
		layoutContainer_1.add(new Text());
		layoutContainer_1.add(new Text());
		layoutContainer_1.add(new Text());
		layoutContainer_1.add(new Text());
		layoutContainer_1.add(new Text());
		layoutContainer_1.add(new Text());
		layoutContainer_1.add(new Text());
		layoutContainer_1.add(new Text());
		layoutContainer_1.add(new Text());
		layoutContainer_1.add(new Text());
		layoutContainer_1.add(new Text());
		layoutContainer_1.add(new Text());
		layoutContainer_1.add(new Text());

		HiddenField hiddenField_11 = new HiddenField();
		layoutContainer_1.add(hiddenField_11);

		HiddenField hiddenField_21 = new HiddenField();
		layoutContainer_1.add(hiddenField_21);

		HiddenField hiddenField_26 = new HiddenField();
		layoutContainer_1.add(hiddenField_26);

		HiddenField hiddenField_25 = new HiddenField();
		layoutContainer_1.add(hiddenField_25);

		HiddenField hiddenField_24 = new HiddenField();
		layoutContainer_1.add(hiddenField_24);

		HiddenField hiddenField_23 = new HiddenField();
		layoutContainer_1.add(hiddenField_23);

		HiddenField hiddenField_22 = new HiddenField();
		layoutContainer_1.add(hiddenField_22);

		seleccionarProfesional = new Button(">");
		seleccionarProfesional.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {

				Dispatcher.forwardEvent(DTEvent.FILTRAR_PROFESIONAL);
			}
		});
		layoutContainer_1.add(seleccionarProfesional);
		seleccionarProfesional.setSize("34", "22");
		layoutContainer_1.add(new Text());
		layoutContainer_1.add(new Text());
		layoutContainer_1.add(new Text());
		layoutContainer_1.add(new Text());
		layoutContainer_1.add(new Text());
		layoutContainer_1.add(new Text());
		layoutContainer_1.add(new Text());
		layoutContainer_1.add(new Text());
		layoutContainer_1.add(new Text());
		layoutContainer_1.add(new Text());
		layoutContainer_1.add(new Text());
		layoutContainer_1.add(new Text());
		layoutContainer_1.add(new Text());

		HiddenField hiddenField_12 = new HiddenField();
		layoutContainer_1.add(hiddenField_12);
		layoutContainer_1.add(new Text());
		layoutContainer_1.add(new Text());
		layoutContainer_1.add(new Text());
		layoutContainer_1.add(new Text());
		layoutContainer_1.add(new Text());
		layoutContainer_1.add(new Text());

		retirarProfesional = new Button("<");
		retirarProfesional.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {

				Dispatcher.forwardEvent(DTEvent.DESFILTRAR_PROFESIONAL);
			}
		});
		layoutContainer_1.add(retirarProfesional);
		retirarProfesional.setSize("34", "22");
		add(layoutContainer_1);
		layoutContainer_1.setSize("87", "164");

		gridProfesionalesSeleccionadas = new Grid(new ListStore(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		Registry.register("gridProfesionalesSeleccionadas", gridProfesionalesSeleccionadas);
		add(gridProfesionalesSeleccionadas);
		gridProfesionalesSeleccionadas.setSize("315", "200");
		gridProfesionalesSeleccionadas.setBorders(true);
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

		Text txtCompetenciasTransversalesDisponibles = new Text("Competencias transversales disponibles");
		add(txtCompetenciasTransversalesDisponibles);
		add(new Text());

		Text txtCompetenciasTransversalesSeleccionadas = new Text("Competencias transversales seleccionadas");
		add(txtCompetenciasTransversalesSeleccionadas);
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());

		HiddenField hiddenField_4 = new HiddenField();
		add(hiddenField_4);
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());

		gridTransversalesDisponibles = new Grid(new ListStore(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		Registry.register("gridTransversalesDisponibles", gridTransversalesDisponibles);
		add(gridTransversalesDisponibles);
		gridTransversalesDisponibles.setSize("315", "200");
		gridTransversalesDisponibles.setBorders(true);

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new TableLayout(7));
		layoutContainer_2.add(new Text());
		layoutContainer_2.add(new Text());
		layoutContainer_2.add(new Text());
		layoutContainer_2.add(new Text());
		layoutContainer_2.add(new Text());
		layoutContainer_2.add(new Text());
		layoutContainer_2.add(new Text());
		layoutContainer_2.add(new Text());
		layoutContainer_2.add(new Text());
		layoutContainer_2.add(new Text());
		layoutContainer_2.add(new Text());
		layoutContainer_2.add(new Text());
		layoutContainer_2.add(new Text());

		HiddenField hiddenField_13 = new HiddenField();
		layoutContainer_2.add(hiddenField_13);

		HiddenField hiddenField_27 = new HiddenField();
		layoutContainer_2.add(hiddenField_27);

		HiddenField hiddenField_30 = new HiddenField();
		layoutContainer_2.add(hiddenField_30);

		HiddenField hiddenField_32 = new HiddenField();
		layoutContainer_2.add(hiddenField_32);

		HiddenField hiddenField_31 = new HiddenField();
		layoutContainer_2.add(hiddenField_31);

		HiddenField hiddenField_29 = new HiddenField();
		layoutContainer_2.add(hiddenField_29);

		HiddenField hiddenField_28 = new HiddenField();
		layoutContainer_2.add(hiddenField_28);

		seleccionarTransversal = new Button(">");
		seleccionarTransversal.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {

				Dispatcher.forwardEvent(DTEvent.FILTRAR_TRANSVERSAL);
			}
		});
		layoutContainer_2.add(seleccionarTransversal);
		seleccionarTransversal.setSize("34", "22");
		layoutContainer_2.add(new Text());
		layoutContainer_2.add(new Text());
		layoutContainer_2.add(new Text());
		layoutContainer_2.add(new Text());
		layoutContainer_2.add(new Text());
		layoutContainer_2.add(new Text());
		layoutContainer_2.add(new Text());
		layoutContainer_2.add(new Text());
		layoutContainer_2.add(new Text());
		layoutContainer_2.add(new Text());
		layoutContainer_2.add(new Text());
		layoutContainer_2.add(new Text());
		layoutContainer_2.add(new Text());

		HiddenField hiddenField_14 = new HiddenField();
		layoutContainer_2.add(hiddenField_14);
		layoutContainer_2.add(new Text());
		layoutContainer_2.add(new Text());
		layoutContainer_2.add(new Text());
		layoutContainer_2.add(new Text());
		layoutContainer_2.add(new Text());
		layoutContainer_2.add(new Text());

		retirarTransversal = new Button("<");
		retirarTransversal.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {

				Dispatcher.forwardEvent(DTEvent.DESFILTRAR_TRANSVERSAL);
			}
		});
		layoutContainer_2.add(retirarTransversal);
		retirarTransversal.setSize("34", "22");
		add(layoutContainer_2);
		layoutContainer_2.setSize("87", "164");

		gridTransversalesSeleccionadas = new Grid(new ListStore(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		Registry.register("gridTransversalesSeleccionadas", gridTransversalesSeleccionadas);
		add(gridTransversalesSeleccionadas);
		gridTransversalesSeleccionadas.setSize("315", "200");
		gridTransversalesSeleccionadas.setBorders(true);
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());

		HiddenField hiddenField_8 = new HiddenField();
		add(hiddenField_8);
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());

		Button btnContinuar = new Button("Continuar");
		btnContinuar.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				Dispatcher.forwardEvent(DTEvent.CAMBIAR_PANELES,"Filtro-Bloques");
				System.out.println("entra al evento filtro bloques");
			}
		});
		add(btnContinuar);
		btnContinuar.setSize("87", "22");
		add(new Text());
		eventoSeleccionarBloqueDisponible();
		eventoSeleccionarBloqueFiltrado();
		eventoSeleccionarProfesionalDisponible();
		eventoSeleccionarProfesionalFiltrado();
		eventoSeleccionarTransversalDisponible();
		eventoSeleccionarTransversalFiltrado();
	}

	public Grid getGridBloquesDisponibles() {
		return gridBloquesDisponibles;
	}

	public void setGridBloquesDisponibles(Grid gridBloquesDisponibles) {
		this.gridBloquesDisponibles = gridBloquesDisponibles;
	}

	public Grid getGridProfesionalesDisponibles() {
		return gridProfesionalesDisponibles;
	}

	public void setGridProfesionalesDisponibles(Grid gridProfesionalesDisponibles) {
		this.gridProfesionalesDisponibles = gridProfesionalesDisponibles;
	}

	public Grid getGridTransversalesDisponibles() {
		return gridTransversalesDisponibles;
	}

	public void setGridTransversalesDisponibles(Grid gridTransversalesDisponibles) {
		this.gridTransversalesDisponibles = gridTransversalesDisponibles;
	}

	public Grid getGridBloquesSeleccionados() {
		return gridBloquesSeleccionados;
	}

	public void setGridBloquesSeleccionados(Grid gridBloquesSeleccionados) {
		this.gridBloquesSeleccionados = gridBloquesSeleccionados;
	}

	public Grid getGridProfesionalesSeleccionadas() {
		return gridProfesionalesSeleccionadas;
	}

	public void setGridProfesionalesSeleccionadas(
			Grid gridProfesionalesSeleccionadas) {
		this.gridProfesionalesSeleccionadas = gridProfesionalesSeleccionadas;
	}

	public Grid getGridTransversalesSeleccionadas() {
		return gridTransversalesSeleccionadas;
	}

	public void setGridTransversalesSeleccionadas(
			Grid gridTransversalesSeleccionadas) {
		this.gridTransversalesSeleccionadas = gridTransversalesSeleccionadas;
	}

	public void recargarPanel() {
		// TODO Auto-generated method stub



	}

	public void actualizarListaBloques(ListStore<BloqueModel> lista){

		if(lista!=null){

			gridBloquesDisponibles.reconfigure(lista, getColumnModel());			
		}else{

			gridBloquesDisponibles.reconfigure(new ListStore<BloqueModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		}
	}

	public void actualizarListaTransversales(ListStore<CompetenciaTerminalModel> lista){

		if(lista!=null){

			gridTransversalesDisponibles.reconfigure(lista, getColumnModel());			
		}else{

			gridTransversalesDisponibles.reconfigure(new ListStore<CompetenciaTerminalModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		}
	}

	public void actualizarListaProfesionales(ListStore<CompetenciaTerminalModel> lista){

		if(lista!=null){

			gridProfesionalesDisponibles.reconfigure(lista, getColumnModel());			
		}else{

			gridProfesionalesDisponibles.reconfigure(new ListStore<CompetenciaTerminalModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		}
	}

	public ColumnModel getColumnModel( )
	{
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>( );

		ColumnConfig column = new ColumnConfig( "id", 60 );
		column.setHeader("ID");
		configs.add( column );

		column = new ColumnConfig( "nombre", 190 );
		column.setAlignment( HorizontalAlignment.LEFT );
		column.setHeader("Nombre");
		configs.add( column );



		return new ColumnModel( configs );
	}


	private void eventoSeleccionarBloqueDisponible(){

		gridBloquesDisponibles.addListener(Events.CellClick, new Listener<GridEvent<BloqueModel>>(){

			@Override
			public void handleEvent(GridEvent<BloqueModel> be) {

				BloqueModel pM = be.getGrid().getSelectionModel().getSelectedItem();
				Registry.register("bloqueDisponible",pM);
				Registry.register( "idCompetenciaTransversal", null);
				Registry.register( "idCompetenciaProfesional",null);
				Registry.register("idBloqueFiltrado", null);
				Registry.register("idBloqueDisponible", null);
				Registry.register("idTransversalDisponible",null);
				Registry.register("idTransversalFiltrado",null);
				Registry.register("idProfesionalDisponible",null);
				Registry.register("idProfesionalFiltrado",null);
				Registry.register("idBloqueDisponible", pM.getId());
				Registry.register("BloqueDisponible", pM);
				
				//btnAgregarLinea.setEnabled(true);
			}


		});
	}

	private void eventoSeleccionarBloqueFiltrado(){

		gridBloquesSeleccionados.addListener(Events.CellClick, new Listener<GridEvent<BloqueModel>>(){

			@Override
			public void handleEvent(GridEvent<BloqueModel> be) {

				BloqueModel pM = be.getGrid().getSelectionModel().getSelectedItem();
				Registry.register("bloqueFiltrado",pM);
				Registry.register( "idCompetenciaTransversal", null);
				Registry.register( "idCompetenciaProfesional",null);
				Registry.register("idBloqueFiltrado", null);
				Registry.register("idBloqueDisponible", null);
				Registry.register("idTransversalDisponible",null);
				Registry.register("idTransversalFiltrado",null);
				Registry.register("idProfesionalDisponible",null);
				Registry.register("idProfesionalFiltrado",null);
				Registry.register("idBloqueFiltrado", pM.getId());
				Registry.register("BloqueFiltrado", pM);
				//	btnAgregarLinea.setEnabled(true);
			}


		});
	}

	private void eventoSeleccionarTransversalDisponible(){

		gridTransversalesDisponibles.addListener(Events.CellClick, new Listener<GridEvent<CompetenciaTerminalModel>>(){

			@Override
			public void handleEvent(GridEvent<CompetenciaTerminalModel> be) {

				CompetenciaTerminalModel pM = be.getGrid().getSelectionModel().getSelectedItem();
				Registry.register("transversalDisponible",pM);
				Registry.register( "idCompetenciaTransversal", null);
				Registry.register( "idCompetenciaProfesional",null);
				Registry.register("idBloqueFiltrado", null);
				Registry.register("idBloqueDisponible", null);
				Registry.register("idTransversalDisponible",null);
				Registry.register("idTransversalFiltrado",null);
				Registry.register("idProfesionalDisponible",null);
				Registry.register("idProfesionalFiltrado",null);
				Registry.register("idTransversalDisponible", pM.getId());
				//			btnAgregarLinea.setEnabled(true);
			}


		});
	}
	private void eventoSeleccionarTransversalFiltrado(){

		gridTransversalesSeleccionadas.addListener(Events.CellClick, new Listener<GridEvent<CompetenciaTerminalModel>>(){

			@Override
			public void handleEvent(GridEvent<CompetenciaTerminalModel> be) {

				CompetenciaTerminalModel pM = be.getGrid().getSelectionModel().getSelectedItem();
				Registry.register("transversalFiltrado",pM);
				Registry.register( "idCompetenciaTransversal", null);
				Registry.register( "idCompetenciaProfesional",null);
				Registry.register("idBloqueFiltrado", null);
				Registry.register("idBloqueDisponible", null);
				Registry.register("idTransversalDisponible",null);
				Registry.register("idTransversalFiltrado",null);
				Registry.register("idProfesionalDisponible",null);
				Registry.register("idProfesionalFiltrado",null);
				Registry.register("idTransversalFiltrado", pM.getId());
				//btnAgregarLinea.setEnabled(true);
			}


		});

	}
	private void eventoSeleccionarProfesionalDisponible(){

		gridProfesionalesDisponibles.addListener(Events.CellClick, new Listener<GridEvent<CompetenciaTerminalModel>>(){

			@Override
			public void handleEvent(GridEvent<CompetenciaTerminalModel> be) {

				CompetenciaTerminalModel pM = be.getGrid().getSelectionModel().getSelectedItem();
				Registry.register("profesionalDisponible",pM);
				Registry.register( "idCompetenciaTransversal", null);
				Registry.register( "idCompetenciaProfesional",null);
				Registry.register("idBloqueFiltrado", null);
				Registry.register("idBloqueDisponible", null);
				Registry.register("idTransversalDisponible",null);
				Registry.register("idTransversalFiltrado",null);
				Registry.register("idProfesionalDisponible",null);
				Registry.register("idProfesionalFiltrado",null);
				Registry.register("idProfesionalDisponible", pM.getId());
				//btnAgregarLinea.setEnabled(true);
			}


		});
	}
	private void eventoSeleccionarProfesionalFiltrado(){

		gridProfesionalesSeleccionadas.addListener(Events.CellClick, new Listener<GridEvent<CompetenciaTerminalModel>>(){

			@Override
			public void handleEvent(GridEvent<CompetenciaTerminalModel> be) {

				CompetenciaTerminalModel pM = be.getGrid().getSelectionModel().getSelectedItem();
				Registry.register("profesionalFiltrado",pM);
				Registry.register( "idCompetenciaTransversal", null);
				Registry.register( "idCompetenciaProfesional",null);
				Registry.register("idBloqueFiltrado", null);
				Registry.register("idBloqueDisponible", null);
				Registry.register("idTransversalDisponible",null);
				Registry.register("idTransversalFiltrado",null);
				Registry.register("idProfesionalDisponible",null);
				Registry.register("idProfesionalFiltrado",null);
				Registry.register("idProfesionalFiltrado", pM.getId());
				//btnAgregarLinea.setEnabled(true);
			}


		});





	}

	public void actualizarListaBloquesDisponibles(ListStore<BloqueModel> lista){

		if(lista!=null){

			gridBloquesDisponibles.reconfigure(lista, getColumnModel());			
		}else{

			gridBloquesDisponibles.reconfigure(new ListStore<BloqueModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		}
	}

	public void actualizarListaBloquesFiltrados(ListStore<BloqueModel> lista){

		if(lista!=null){

			gridBloquesSeleccionados.reconfigure(lista, getColumnModel());			
		}else{

			gridBloquesSeleccionados.reconfigure(new ListStore<BloqueModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		}
	}

	public void actualizarListaProfesionalFiltrados(
			ListStore<CompetenciaTerminalModel> lista) {
		// TODO Auto-generated method stub
		if(lista!=null){

			gridProfesionalesSeleccionadas.reconfigure(lista, getColumnModel());			
		}else{

			gridProfesionalesSeleccionadas.reconfigure(new ListStore<BloqueModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		}
	}

	public void actualizarListaProfesionalDisponibles(
			ListStore<CompetenciaTerminalModel> lista) {
		// TODO Auto-generated method stub
		if(lista!=null){

			gridProfesionalesDisponibles.reconfigure(lista, getColumnModel());			
		}else{

			gridProfesionalesDisponibles.reconfigure(new ListStore<BloqueModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		}
	}

	public void actualizarListaTransversalDisponibles(
			ListStore<CompetenciaTerminalModel> lista) {
		// TODO Auto-generated method stub
		if(lista!=null){

			gridTransversalesSeleccionadas.reconfigure(lista, getColumnModel());			
		}else{

			gridTransversalesSeleccionadas.reconfigure(new ListStore<BloqueModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		}
	}

	public void actualizarListaTransversalFiltrados(
			ListStore<CompetenciaTerminalModel> lista) {
		// TODO Auto-generated method stub
		if(lista!=null){

			gridTransversalesSeleccionadas.reconfigure(lista, getColumnModel());			
		}else{

			gridTransversalesSeleccionadas.reconfigure(new ListStore<BloqueModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		}
	}
	
	public void cargarEspecifica(int competencia , int var){
		

		busquedaService.buscarLineaDeCompetenciaPorCompetencia(Registry.get("idPrograma")+"", competencia+"", new AsyncCallback<ArrayList<CompetenciaEspecificaBO>>() {

			@Override
			public void onFailure(Throwable arg0) {
				
				
				
			}

			@Override
			public void onSuccess(ArrayList<CompetenciaEspecificaBO> result) {
				
				
				if(result != null){
					ListStore<CompetenciaEspecificaModel> lista=Registry.get("listaEspecificaFiltro");
					if(lista==null)
						lista=new ListStore<CompetenciaEspecificaModel>();
						
									
					for(CompetenciaEspecificaBO c:result){
						CompetenciaEspecificaModel d=new CompetenciaEspecificaModel();
						d.setId(c.getIdLineaDeCompetencia());
						d.setNombre(c.getNombre());
						d.setDescripcion(c.getDescripcion());
						lista.add(d);
						
						
					}
					
					Registry.register("listaEspecificaFiltro",lista);
					
					
					int var=(Integer)Registry.get("var");
					if(var==1){
						Dispatcher.forwardEvent(DTEvent.ACTUALIZAR_BLOQUES_FILTRO);
					}
					//
					
				}
			}
		});
		
	}
}

