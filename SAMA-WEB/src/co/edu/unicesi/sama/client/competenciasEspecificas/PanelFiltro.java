package co.edu.unicesi.sama.client.competenciasEspecificas;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.client.busqueda.BusquedaService;
import co.edu.unicesi.sama.client.busqueda.BusquedaServiceAsync;
import co.edu.unicesi.sama.client.controller.DTEvent;
import co.edu.unicesi.sama.client.model.BloqueModel;
import co.edu.unicesi.sama.client.model.CompetenciaTerminalModel;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
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
		
		Button seleccionarBloque = new Button(">");
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
		
		Button retirarBloque = new Button("<");
		layoutContainer.add(retirarBloque);
		retirarBloque.setSize("34", "22");
		add(layoutContainer);
		layoutContainer.setSize("87", "164px");
		
		 gridBloquesSeleccionados = new Grid(new ListStore(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
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
		
		Button seleccionarProfesional = new Button(">");
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
		
		Button retirarProfesional = new Button("<");
		layoutContainer_1.add(retirarProfesional);
		retirarProfesional.setSize("34", "22");
		add(layoutContainer_1);
		layoutContainer_1.setSize("87", "164");
		
		 gridProfesionalesSeleccionadas = new Grid(new ListStore(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
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
		
		Button seleccionarTransversal = new Button(">");
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
		
		Button retirarTransversal = new Button("<");
		layoutContainer_2.add(retirarTransversal);
		retirarTransversal.setSize("34", "22");
		add(layoutContainer_2);
		layoutContainer_2.setSize("87", "164");
		
		 gridTransversalesSeleccionadas = new Grid(new ListStore(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
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
		add(btnContinuar);
		btnContinuar.setSize("87", "22");
		add(new Text());
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
        


        return new ColumnModel( configs );
    }
	





}
