package co.edu.unicesi.sama.client.busqueda;

import java.util.ArrayList;
import java.util.List;

import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.client.controller.DTEvent;
import co.edu.unicesi.sama.client.model.ProgramaModel;

import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.table.Table;
import com.extjs.gxt.ui.client.widget.table.TableColumnModel;
import com.extjs.gxt.ui.client.widget.table.TableColumn;
import com.extjs.gxt.ui.client.widget.table.TableItem;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import java.util.Collections;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;

@SuppressWarnings("deprecation")
public class ListaProgramas extends LayoutContainer {
	private BusquedaServiceAsync busquedaService = GWT.create(BusquedaService.class);
	private Grid<ProgramaModel> gridProgramas;
	public ListaProgramas() {
		setSize("250", "390");
		setLayout(new BorderLayout());
		
		ContentPanel cntntpnlProgramas = new ContentPanel();
		cntntpnlProgramas.setHeading("Programas");
		
		gridProgramas = new Grid<ProgramaModel>(new ListStore<ProgramaModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		cntntpnlProgramas.add(gridProgramas);
		gridProgramas.setSize("248", "363");
		gridProgramas.setBorders(true);
		add(cntntpnlProgramas, new BorderLayoutData(LayoutRegion.CENTER));
		cntntpnlProgramas.setSize("250", "390");
		eventoSeleccionarPrograma();
	}
	
//	public void llenarTabla(){
//		
//		busquedaService.darProgramasOrdenadosPorNombre(new AsyncCallback<ArrayList<ProgramaBO>>(){
//
//			@Override
//			public void onFailure(Throwable arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void onSuccess(ArrayList<ProgramaBO> result) {
//				
//				if(result != null){
//					
//					for(ProgramaBO bo:result){
//						
//
//					}
//				}
//				
//			}
//		});
//	}
	
	public void actualizarListaProgramas(ListStore<ProgramaModel> lista){

		gridProgramas.reconfigure(lista, getColumnModel());

	}
	
	private ColumnModel getColumnModel( )
    {
        List<ColumnConfig> configs = new ArrayList<ColumnConfig>( );

        ColumnConfig column = new ColumnConfig( "id", 60 );
        column.setHeader("ID");
        configs.add( column );

        column = new ColumnConfig( "nombre", 190 );
        column.setHeader("Nombre");
        column.setAlignment( HorizontalAlignment.LEFT );
        configs.add( column );

        return new ColumnModel( configs );
    }
	
	private void eventoSeleccionarPrograma(){
		
		gridProgramas.addListener(Events.CellClick, new Listener<GridEvent<ProgramaModel>>(){

			@Override
			public void handleEvent(GridEvent<ProgramaModel> be) {
				ProgramaModel pM = be.getGrid().getSelectionModel().getSelectedItem();
				Dispatcher.forwardEvent(DTEvent.SELECCIONAR_PROGRAMA, pM);
				
			}
			
			
		});
	}

}
