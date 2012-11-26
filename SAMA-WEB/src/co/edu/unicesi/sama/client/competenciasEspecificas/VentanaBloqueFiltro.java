package co.edu.unicesi.sama.client.competenciasEspecificas;

import java.util.ArrayList;
import java.util.List;

import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.client.busqueda.BusquedaService;
import co.edu.unicesi.sama.client.busqueda.BusquedaServiceAsync;
import co.edu.unicesi.sama.client.controller.DTEvent;
import co.edu.unicesi.sama.client.model.BloqueModel;
import co.edu.unicesi.sama.client.programas.ProgramaService;
import co.edu.unicesi.sama.client.programas.ProgramaServiceAsync;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import java.util.Collections;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;

public class VentanaBloqueFiltro extends Window {

	private ProgramaServiceAsync programaService = GWT.create(ProgramaService.class);
	private final BusquedaServiceAsync busquedaService = GWT.create(BusquedaService.class);
	private Grid <BloqueModel> grid;
	
	public VentanaBloqueFiltro() {
		setHeading("Escoja Un Bloque");
		setLayout(new TableLayout(4));
		add(new Text());
		add(new Text());
		add(new Text());
		
		LabelField lblfldNombreDelPrograma = new LabelField("Bloques ");
		add(lblfldNombreDelPrograma);
		lblfldNombreDelPrograma.setWidth("60");
		add(new Text());
		add(new Text());
		add(new Text());
		
		 grid = new Grid(new ListStore(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		grid.setAutoExpandMin(500);
		add(grid);
		grid.setSize("360", "173px");
		grid.setBorders(true);
		add(new Text());
		add(new Text());
		add(new Text());
		
		HiddenField hiddenField_1 = new HiddenField();
		add(hiddenField_1);
		add(new Text());
		add(new Text());
		add(new Text());
		
		HiddenField hiddenField_2 = new HiddenField();
		add(hiddenField_2);
		add(new Text());
		add(new Text());
		add(new Text());
		
		ButtonBar buttonBar = new ButtonBar();
		buttonBar.setAlignment(HorizontalAlignment.CENTER);
		
		Button btnAgregar = new Button("Seleccionar");
		btnAgregar.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				Dispatcher.forwardEvent(DTEvent.CERRAR_VENTANA_BLOQUEFILTRO);

				
				
			}
		});
		buttonBar.add(btnAgregar);
		add(buttonBar);
		add(new Text());
		add(new Text());
		
		HiddenField hiddenField = new HiddenField();
		add(hiddenField);
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		
		HiddenField hiddenField_3 = new HiddenField();
		add(hiddenField_3);
		
		eventoSeleccionarBloques();
	}
	
	

	public void actualizarPanel(ListStore<BloqueModel> lista){
		
		if(lista!=null){

			grid.reconfigure(lista, getColumnModel());			
		}else{
			System.out.println("lista esta nulo");
			grid.reconfigure(new ListStore<BloqueModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		}
		
	}
	
 public	 void eventoSeleccionarBloques(){
			
		grid.addListener(Events.CellClick, new Listener<GridEvent<BloqueModel>>(){

			@Override
			public void handleEvent(GridEvent<BloqueModel> be) {
				BloqueModel pM = be.getGrid().getSelectionModel().getSelectedItem();
				Registry.register("bloqueSeleccionadoFiltro",pM);
				
			}
			
			
		});
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

}
