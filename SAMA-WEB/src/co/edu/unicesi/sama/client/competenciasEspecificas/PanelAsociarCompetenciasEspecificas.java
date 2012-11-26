package co.edu.unicesi.sama.client.competenciasEspecificas;

import co.edu.unicesi.sama.bo.AsociacionEspecificaBO;
import co.edu.unicesi.sama.bo.MateriaBO;
import co.edu.unicesi.sama.client.asociacionEspecifica.AsociacionEspecificaService;
import co.edu.unicesi.sama.client.asociacionEspecifica.AsociacionEspecificaServiceAsync;
import co.edu.unicesi.sama.client.busqueda.BusquedaService;
import co.edu.unicesi.sama.client.busqueda.BusquedaServiceAsync;
import co.edu.unicesi.sama.client.controller.DTEvent;
import co.edu.unicesi.sama.client.model.BloqueModel;
import co.edu.unicesi.sama.client.model.CompetenciaEspecificaModel;
import co.edu.unicesi.sama.client.model.MateriaModel;
import co.edu.unicesi.sama.client.reportes.ReportesService;
import co.edu.unicesi.sama.client.reportes.ReportesServiceAsync;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.event.BaseEvent;
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
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.ListField;
import com.extjs.gxt.ui.client.widget.layout.TableData;
import com.extjs.gxt.ui.client.Style.VerticalAlignment;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.form.CheckBoxGroup;
import com.extjs.gxt.ui.client.widget.layout.FillData;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.ComboBox;

public class PanelAsociarCompetenciasEspecificas extends LayoutContainer {
private Grid grid;
private Grid grid_2;
private Grid grid_1;
private final BusquedaServiceAsync busquedaService = GWT.create(BusquedaService.class);
private CheckBox chckbxAplica;
private CheckBox chckbxIntroduce;
private CheckBox chckbxEnsea;
private ContentPanel cntntpnlReporteDeCambios;
private final AsociacionEspecificaServiceAsync asociacionServices = GWT.create(AsociacionEspecificaService.class);
private final ReportesServiceAsync reportesService = GWT.create(ReportesService.class);

	public PanelAsociarCompetenciasEspecificas() {
		setSize("750px", "860px");
		setLayout(new TableLayout(12));
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
		add(new Text());
		add(new Text());
		add(new Text());
		
		Text txtCompetencias = new Text("Competencias");
		add(txtCompetencias);
		add(new Text());
		
		HiddenField hiddenField_9 = new HiddenField();
		add(hiddenField_9);
		
		HiddenField hiddenField_8 = new HiddenField();
		add(hiddenField_8);
		
		HiddenField hiddenField_7 = new HiddenField();
		add(hiddenField_7);
		
		Text txtBloques = new Text("Bloque");
		add(txtBloques);
		
		HiddenField hiddenField_11 = new HiddenField();
		add(hiddenField_11);
		
		 grid_1 = new Grid(new ListStore(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		add(grid_1);
		grid_1.setHeight("62px");
		grid_1.setBorders(true);
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		
		 grid = new Grid(new ListStore(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		TableData td_grid = new TableData();
		td_grid.setRowspan(7);
		add(grid, td_grid);
		grid.setSize("404px", "123px");
		grid.setBorders(true);
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
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
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
		add(new Text());
		add(new Text());
		
		Text txtMaterias = new Text("Materia");
		add(txtMaterias);
		add(new Text());
		
		grid_2 = new Grid(new ListStore(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		add(grid_2);
		grid_2.setHeight("67px");
		grid_2.setBorders(true);
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
		add(new Text());
		
		HiddenField hiddenField_1 = new HiddenField();
		add(hiddenField_1);
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
		
		ContentPanel cntntpnlAlcance = new ContentPanel();
		cntntpnlAlcance.setHeading("Alcance");
		TableData td_cntntpnlAlcance = new TableData();
		td_cntntpnlAlcance.setHorizontalAlign(HorizontalAlignment.CENTER);
		
		CheckBoxGroup chckbxgrpAlcance = new CheckBoxGroup();
		
		 chckbxIntroduce = new CheckBox();
		chckbxgrpAlcance.add(chckbxIntroduce);
		chckbxIntroduce.addListener(Events.OnChange, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent e) {
				
				MateriaModel bloque= Registry.get("materiaSeleccionadoFiltro");
				CompetenciaEspecificaModel competencia= Registry.get("especificaMateria");

				if(bloque!=null && competencia!=null){
					
					if(chckbxIntroduce.getValue()){
					
						asociacionServices.crearAsociacionMateria(Registry.get("idPrograma")+"", ((MateriaModel) Registry.get("materiaSeleccionadoFiltro")).getId()+"", ((CompetenciaEspecificaModel)Registry.get("especificaMateria")).getId()+"", 1, new AsyncCallback<String>() {
							public void onFailure(Throwable arg0) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void onSuccess(String result) {
								
								// TODO Auto-generated method stub
								
								Info.display("Asociacion Especifica",result);
								if(!result.equals("Asociacion exitosa")){
									chckbxIntroduce.setValue(!chckbxIntroduce.getValue());
								}
								
							}
							
							
							
							
						});
						
					}else{
						
						asociacionServices.elminarAsociacionMateria(Registry.get("idPrograma")+"", ((MateriaModel) Registry.get("materiaSeleccionadoFiltro")).getId()+"", ((CompetenciaEspecificaModel)Registry.get("especificaMateria")).getId()+"", 1, new AsyncCallback<String>() {
							public void onFailure(Throwable arg0) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void onSuccess(String result) {
								
								// TODO Auto-generated method stub
								Info.display("Asociacion Especifica",result);
							
							}
							
							
							
							
						});
						

						
						
					
						
					}
				}else{
					
					chckbxIntroduce.setValue(!chckbxIntroduce.getValue());
					Info.display("Filtro","Debe seleccionar una materia y una competencia especifica para poder modificar");
					
				}
			
				
				
			}
		});
		chckbxIntroduce.setBoxLabel("Introduce");
		chckbxIntroduce.setHideLabel(true);
		
		chckbxEnsea = new CheckBox();
		chckbxgrpAlcance.add(chckbxEnsea);
		chckbxEnsea.addListener(Events.OnChange, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent e) {
				
				MateriaModel bloque= Registry.get("materiaSeleccionadoFiltro");
				CompetenciaEspecificaModel competencia= Registry.get("especificaMateria");
				
				if(bloque!=null && competencia!=null){
					
					if(chckbxEnsea.getValue()){
					
						asociacionServices.crearAsociacionMateria(Registry.get("idPrograma")+"", ((MateriaModel) Registry.get("materiaSeleccionadoFiltro")).getId()+"", ((CompetenciaEspecificaModel)Registry.get("especificaMateria")).getId()+"", 2, new AsyncCallback<String>() {
							public void onFailure(Throwable arg0) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void onSuccess(String result) {
								
								// TODO Auto-generated method stub
								Info.display("Asociacion Especifica",result);
								if(!result.equals("Asociacion exitosa")){
									chckbxEnsea.setValue(!chckbxEnsea.getValue());
								}
							}
							
							
							
							
						});
						
					}else{
						
						
						asociacionServices.elminarAsociacionMateria(Registry.get("idPrograma")+"", ((MateriaModel) Registry.get("materiaSeleccionadoFiltro")).getId()+"", ((CompetenciaEspecificaModel)Registry.get("especificaMateria")).getId()+"", 2, new AsyncCallback<String>() {
							public void onFailure(Throwable arg0) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void onSuccess(String result) {
								
								// TODO Auto-generated method stub
								Info.display("Asociacion Especifica",result);
							
							}
							
							
							
							
						});

						
						
					
						
					}
				}else{
					
					chckbxEnsea.setValue(!chckbxEnsea.getValue());
					Info.display("Filtro","Debe seleccionar una materia y una competencia especifica para poder modificar");
					
				}
		
				
				
				
			}
		});
		chckbxEnsea.setBoxLabel("Ense\u00F1a");
		chckbxEnsea.setHideLabel(true);
		
		 chckbxAplica = new CheckBox();
		chckbxgrpAlcance.add(chckbxAplica);
		chckbxAplica.addListener(Events.OnChange, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent e) {
				
				MateriaModel bloque= Registry.get("materiaSeleccionadoFiltro");
				CompetenciaEspecificaModel competencia= Registry.get("especificaMateria");
				
				if(bloque!=null && competencia!=null){
					
					if(chckbxAplica.getValue()){
					
						

						asociacionServices.crearAsociacionMateria(Registry.get("idPrograma")+"", ((MateriaModel) Registry.get("materiaSeleccionadoFiltro")).getId()+"", ((CompetenciaEspecificaModel)Registry.get("especificaMateria")).getId()+"", 3, new AsyncCallback<String>() {
							public void onFailure(Throwable arg0) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void onSuccess(String result) {
								
								// TODO Auto-generated method stub
								Info.display("Asociacion Especifica",result);
								if(!result.equals("Asociacion exitosa")){
									chckbxAplica.setValue(!chckbxAplica.getValue());
								}
							}
							
							
							
							
						});
						
					}else{
						
						
						asociacionServices.elminarAsociacionMateria(Registry.get("idPrograma")+"", ((MateriaModel) Registry.get("materiaSeleccionadoFiltro")).getId()+"", ((CompetenciaEspecificaModel)Registry.get("especificaMateria")).getId()+"", 3, new AsyncCallback<String>() {
							public void onFailure(Throwable arg0) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void onSuccess(String result) {
								
								// TODO Auto-generated method stub
								Info.display("Asociacion Especifica",result);
							
							}
							
							
							
							
						});
						
					
						
					}
				}else{
					
					chckbxAplica.setValue(!chckbxAplica.getValue());
					Info.display("Filtro","Debe seleccionar una materia y una competencia especifica para poder modificar");
					
				}
		
				
				
				
			}
		});
		chckbxAplica.setBoxLabel("Aplica");
		chckbxAplica.setHideLabel(true);
		cntntpnlAlcance.add(chckbxgrpAlcance);
		chckbxgrpAlcance.setFieldLabel("Alcance");
		add(cntntpnlAlcance, td_cntntpnlAlcance);
		cntntpnlAlcance.setHeight("49px");
		
		HiddenField hiddenField_5 = new HiddenField();
		add(hiddenField_5);
		
		HiddenField hiddenField_6 = new HiddenField();
		add(hiddenField_6);
		
		HiddenField hiddenField_4 = new HiddenField();
		add(hiddenField_4);
		
		HiddenField hiddenField_3 = new HiddenField();
		add(hiddenField_3);
		add(new Text());
		add(new Text());
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
		
		Button btnActualizarReporte = new Button("Actualizar Reporte");
		btnActualizarReporte.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				crearReporte(2,(String)Registry.get("idPrograma"));
			}
		});
		TableData td_btnActualizarReporte = new TableData();
		td_btnActualizarReporte.setColspan(12);
		td_btnActualizarReporte.setHorizontalAlign(HorizontalAlignment.CENTER);
		add(btnActualizarReporte, td_btnActualizarReporte);
		btnActualizarReporte.setWidth("150px");
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
		add(new Text());
		
		HiddenField hiddenField_10 = new HiddenField();
		add(hiddenField_10);
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		
		cntntpnlReporteDeCambios = new ContentPanel();
		cntntpnlReporteDeCambios.setHeading("Reporte de Cambios");
		Registry.register("panelReporteMateria",cntntpnlReporteDeCambios);
		cntntpnlReporteDeCambios.setLayout(new TableLayout(1));
		TableData td_cntntpnlReporteDeCambios = new TableData();
		td_cntntpnlReporteDeCambios.setColspan(8);
		add(cntntpnlReporteDeCambios, td_cntntpnlReporteDeCambios);
		cntntpnlReporteDeCambios.setSize("724px", "601px");
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
		add(new Text());
		
		HiddenField hiddenField_12 = new HiddenField();
		add(hiddenField_12);
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		
		Button btnRegresar = new Button("Regresar");
		btnRegresar.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				Dispatcher.forwardEvent(DTEvent.CAMBIAR_PANELES,"Materias-Bloques");
			}
		});
		TableData td_btnRegresar = new TableData();
		td_btnRegresar.setHorizontalAlign(HorizontalAlignment.CENTER);
		td_btnRegresar.setColspan(8);
		add(btnRegresar, td_btnRegresar);
		eventoSeleccionarBloques();
		eventoSeleccionarCompetencias();
		eventoSeleccionarMaterias();
		
	}
	public void actualizarBloques(ListStore<BloqueModel> lista) {
		// TODO Auto-generated method stub
		if(lista!=null){

		
			grid_1.reconfigure(lista,getColumnModel());
			
			
		}else{

			grid_1.reconfigure(new ListStore<BloqueModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		}
	}
	
	
	public void actualizarMaterias(ListStore<MateriaModel> lista) {
		// TODO Auto-generated method stub
		if(lista!=null){

		
			grid_2.reconfigure(lista,getColumnModel());
			
			
		}else{

			grid_2.reconfigure(new ListStore<MateriaModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
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
	public void refrescarListaEspecifica(
			ListStore<CompetenciaEspecificaModel> lista) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if(lista!=null){

			grid.reconfigure(lista, getColumnModel());			
		}else{

			grid.reconfigure(new ListStore<CompetenciaEspecificaModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		}
	}
	public Grid getGrid() {
		return grid;
	}
	public void setGrid(Grid grid) {
		this.grid = grid;
	}
	public Grid getGrid_2() {
		return grid_2;
	}
	public void setGrid_2(Grid grid_2) {
		this.grid_2 = grid_2;
	}
	
public void cargarMateriasAsociadas(){
		
		busquedaService.buscarMateriaBloquePorBloque(((BloqueModel) Registry.get("bloqueSeleccionadoFiltro2")).getId()+"", new AsyncCallback<ArrayList<MateriaBO>>() {

			@Override
			public void onFailure(Throwable arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(ArrayList<MateriaBO> result) {
				
				if(result != null){
//					materiasAsociadas = new ArrayList<MateriaBO>();
					
//					llenarListas();
					Dispatcher.forwardEvent(DTEvent.REFRESCAR_MATERIAS_FILTRO, result);
					
				}
				
				
			}
		});	
	}

public void actualizarReporte(String url){
	
	cntntpnlReporteDeCambios.setUrl(url);
}

public void crearReporte(int tipo, String codigoPrograma){
	reportesService.crearReporte(tipo, codigoPrograma,  new AsyncCallback<String>() {

		@Override
		public void onFailure(Throwable arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(String arg0) {
			
			if(!arg0.equals("Error")){
				
				actualizarReporte(arg0);
			}
			
		}
	});
	
}
public	 void eventoSeleccionarCompetencias(){
	
	grid.addListener(Events.CellClick, new Listener<GridEvent<CompetenciaEspecificaModel>>(){

		@Override
		public void handleEvent(GridEvent<CompetenciaEspecificaModel> be) {
			CompetenciaEspecificaModel pM = be.getGrid().getSelectionModel().getSelectedItem();
			Registry.register("especificaMateria",pM);
			if(Registry.get("materiaSeleccionadoFiltro")!=null){
				consultarChck();

				
			}
			
			
		}
		
		
	});
}
public void consultarChck(){
	busquedaService.buscarAsociacionCompetenciaEspecificaMateria(Registry.get("idPrograma")+"",((MateriaModel) Registry.get("materiaSeleccionadoFiltro")).getId()+"",((CompetenciaEspecificaModel)Registry.get("especificaMateria")).getId()+"", new AsyncCallback<AsociacionEspecificaBO>() {

		@Override
		public void onFailure(Throwable arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(AsociacionEspecificaBO result) {
			// TODO Auto-generated method stub
			Dispatcher.forwardEvent(DTEvent.ACTUALIZARCHK_MATERIA,result);
		}
		
		
		
		
	});
}

public void actualizarCombos(int a, int b, int c){
	if(a==1){
		chckbxIntroduce.setValue(true);
	}else{
		chckbxIntroduce.setValue(false);
	}
	if(b==1){
		chckbxEnsea.setValue(true);
	}else{
		chckbxEnsea.setValue(false);
	}
	if(c==1){
		chckbxAplica.setValue(true);
	}else{
		chckbxAplica.setValue(false);
	}
}
void eventoSeleccionarMaterias(){
	
	grid_2.addListener(Events.CellClick, new Listener<GridEvent<MateriaModel>>(){

		@Override
		public void handleEvent(GridEvent<MateriaModel> be) {
			MateriaModel pM = be.getGrid().getSelectionModel().getSelectedItem();
			Registry.register("materiaSeleccionadoFiltro",pM);
			if(Registry.get("especificaMateria")!=null)
				consultarChck();
			
		}
		
		
	});
}

public CheckBox getChckbxAplica() {
	return chckbxAplica;
}
public void setChckbxAplica(CheckBox chckbxAplica) {
	this.chckbxAplica = chckbxAplica;
}
public CheckBox getChckbxIntroduce() {
	return chckbxIntroduce;
}
public void setChckbxIntroduce(CheckBox chckbxIntroduce) {
	this.chckbxIntroduce = chckbxIntroduce;
}
public CheckBox getChckbxEnsea() {
	return chckbxEnsea;
}
public void setChckbxEnsea(CheckBox chckbxEnsea) {
	this.chckbxEnsea = chckbxEnsea;
}
public	 void eventoSeleccionarBloques(){
	
	grid_1.addListener(Events.CellClick, new Listener<GridEvent<BloqueModel>>(){

			@Override
			public void handleEvent(GridEvent<BloqueModel> be) {
				BloqueModel pM = be.getGrid().getSelectionModel().getSelectedItem();
				Registry.register("bloqueSeleccionadoFiltro2",pM);
				Dispatcher.forwardEvent(DTEvent.CONSULTAR_BLOQUE2);
			}
			
			
		});
	}




}

