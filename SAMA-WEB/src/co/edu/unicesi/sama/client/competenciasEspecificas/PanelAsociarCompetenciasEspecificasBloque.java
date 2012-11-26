package co.edu.unicesi.sama.client.competenciasEspecificas;

import co.edu.unicesi.sama.bo.AsociacionEspecificaBO;
import co.edu.unicesi.sama.client.asociacionEspecifica.AsociacionEspecificaService;
import co.edu.unicesi.sama.client.asociacionEspecifica.AsociacionEspecificaServiceAsync;
import co.edu.unicesi.sama.client.bloqueMaterias.BloquesMateriaService;
import co.edu.unicesi.sama.client.bloqueMaterias.BloquesMateriaServiceAsync;
import co.edu.unicesi.sama.client.busqueda.BusquedaService;
import co.edu.unicesi.sama.client.busqueda.BusquedaServiceAsync;
import co.edu.unicesi.sama.client.controller.DTEvent;
import co.edu.unicesi.sama.client.model.BloqueModel;
import co.edu.unicesi.sama.client.model.CompetenciaEspecificaModel;
import co.edu.unicesi.sama.client.programas.VentanaPrograma;
import co.edu.unicesi.sama.client.reportes.ReportesService;
import co.edu.unicesi.sama.client.reportes.ReportesServiceAsync;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.ListView;
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
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.Style.ButtonArrowAlign;

public class PanelAsociarCompetenciasEspecificasBloque extends LayoutContainer {
	private final BusquedaServiceAsync busquedaServices = GWT.create(BusquedaService.class);
	private final AsociacionEspecificaServiceAsync asociacionServices = GWT.create(AsociacionEspecificaService.class);
	private final ReportesServiceAsync reportesService = GWT.create(ReportesService.class);
	private ContentPanel cntntpnlReporteDeCambios;
	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public Grid getCmbxBloques() {
		return grid_Bloquebloque;
	}

	public void setCmbxBloques(Grid grid_Bloquebloque) {
		this.grid_Bloquebloque = grid_Bloquebloque;
	}
	private Grid grid_Bloquebloque;
		private Grid grid;
		private CheckBox chckbxIntroduce;
		private CheckBox chckbxEnsea;
		private CheckBox chckbxAplica;

	public PanelAsociarCompetenciasEspecificasBloque() {
		setSize("750px", "836px");
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
		
		Text txtBloques = new Text("Bloques");
		add(txtBloques);
		
		HiddenField hiddenField_11 = new HiddenField();
		add(hiddenField_11);
		
		 grid_Bloquebloque = new Grid(new ListStore(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		grid_Bloquebloque.addListener(Events.CellClick, new Listener<BaseEvent>(){
			public void handleEvent (BaseEvent be){
		
			}
		});
		add(grid_Bloquebloque);
		grid_Bloquebloque.setSize("260", "89px");
		grid_Bloquebloque.setBorders(true);
		//cmbxBloques.setFieldLabel("comboBloques");
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		
		grid = new Grid(new ListStore(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		TableData td_grid = new TableData();
		
		td_grid.setRowspan(4);
		add(grid, td_grid);
		grid.setSize("404px", "86px");
		grid.setBorders(true);
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
		
		ContentPanel cntntpnlAlcance = new ContentPanel();
		cntntpnlAlcance.setHeading("Alcance");
		TableData td_cntntpnlAlcance = new TableData();
		td_cntntpnlAlcance.setHorizontalAlign(HorizontalAlignment.CENTER);
		
		CheckBoxGroup chckbxgrpAlcance = new CheckBoxGroup();
		Registry.register("var2",0);
		
		chckbxIntroduce = new CheckBox();
		
		chckbxIntroduce.addListener(Events.OnChange, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent e) {
				
				BloqueModel bloque= Registry.get("bloqueSeleccionadoFiltro");
				CompetenciaEspecificaModel competencia= Registry.get("especificaBloque");
				
				if(bloque!=null && competencia!=null){
					
					if(chckbxIntroduce.getValue()){
					
						
						
						asociacionServices.crearAsociacionBloque(Registry.get("idPrograma")+"", ((BloqueModel) Registry.get("bloqueSeleccionadoFiltro")).getId()+"", ((CompetenciaEspecificaModel)Registry.get("especificaBloque")).getId()+"", 1, new AsyncCallback<String>() {
							public void onFailure(Throwable arg0) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void onSuccess(String result) {
								
								// TODO Auto-generated method stub
								Info.display("Asociacion Especifica",result);
							
							}
							
							
							
							
						});
						
						
					}else{
						
						
						asociacionServices.eliminarAsociacionBloque(Registry.get("idPrograma")+"", ((BloqueModel) Registry.get("bloqueSeleccionadoFiltro")).getId()+"", ((CompetenciaEspecificaModel)Registry.get("especificaBloque")).getId()+"", 1, new AsyncCallback<String>() {
							public void onFailure(Throwable arg0) {
								// TODO Auto-generated method stub
								Info.display ("Asociacion Especifica",arg0.getMessage());
							}

							@Override
							public void onSuccess(String result) {
								
								// TODO Auto-generated method stub
								Info.display("Asociacion Especifica",result);
								if(!result.equals("Desasociacion exitosa")){
									chckbxIntroduce.setValue(!chckbxIntroduce.getValue());
								}
							}
							
							
							
							
						});		
						
					}
				}else{
					
					chckbxIntroduce.setValue(!chckbxIntroduce.getValue());
					Info.display("Filtro","Debe seleccionar una materia y una competencia especifica para poder modificar");
					
				}
	
				
				
				
			}
		});
		chckbxgrpAlcance.add(chckbxIntroduce);
		chckbxIntroduce.setBoxLabel("Introduce");
		chckbxIntroduce.setHideLabel(true);
		
		
		
		
		
		 chckbxEnsea = new CheckBox();
		chckbxgrpAlcance.add(chckbxEnsea);
		chckbxEnsea.setBoxLabel("Ense\u00F1a");
		chckbxEnsea.setHideLabel(true);
		chckbxEnsea.addListener(Events.OnChange, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent e) {
				BloqueModel bloque= Registry.get("bloqueSeleccionadoFiltro");
				CompetenciaEspecificaModel competencia= Registry.get("especificaBloque");
				
					
				if(bloque!=null && competencia!=null){
					if(chckbxEnsea.getValue()){
						asociacionServices.crearAsociacionBloque(Registry.get("idPrograma")+"", ((BloqueModel) Registry.get("bloqueSeleccionadoFiltro")).getId()+"", ((CompetenciaEspecificaModel)Registry.get("especificaBloque")).getId()+"", 2, new AsyncCallback<String>() {
							public void onFailure(Throwable arg0) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void onSuccess(String result) {
								
								// TODO Auto-generated method stub
								Info.display("Asociacion Especifica","Asociacion especifica con exito");
							}
							
							
							
							
						});

						
			
					}else{
						asociacionServices.eliminarAsociacionBloque(Registry.get("idPrograma")+"", ((BloqueModel) Registry.get("bloqueSeleccionadoFiltro")).getId()+"", ((CompetenciaEspecificaModel)Registry.get("especificaBloque")).getId()+"", 2, new AsyncCallback<String>() {
							public void onFailure(Throwable arg0) {
								// TODO Auto-generated method stub
								Info.display ("Asociacion Especifica",arg0.getMessage());
							}

							@Override
							public void onSuccess(String result) {
								
								// TODO Auto-generated method stub
								Info.display("Asociacion Especifica",result);
								if(!result.equals("Desasociacion exitosa")){
									chckbxEnsea.setValue(!chckbxEnsea.getValue());
								}
							}
							
							
							
							
						});
						
											}
				}else{
					
					chckbxEnsea.setValue(!chckbxIntroduce.getValue());
					Info.display("Filtro","Debe seleccionar una materia y una competencia especifica para poder modificar");
					
				}
		
				
				
				
			}
		});
		
		
		
		 chckbxAplica = new CheckBox();
		chckbxgrpAlcance.add(chckbxAplica);
		chckbxAplica.setBoxLabel("Aplica");
		chckbxAplica.setHideLabel(true);
		chckbxAplica.addListener(Events.OnChange, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent e) {
				BloqueModel bloque= Registry.get("bloqueSeleccionadoFiltro");
				CompetenciaEspecificaModel competencia= Registry.get("especificaBloque");
				
				if(bloque!=null && competencia!=null){
					if(chckbxAplica.getValue()){
						

						asociacionServices.crearAsociacionBloque(Registry.get("idPrograma")+"", ((BloqueModel) Registry.get("bloqueSeleccionadoFiltro")).getId()+"", ((CompetenciaEspecificaModel)Registry.get("especificaBloque")).getId()+"", 3, new AsyncCallback<String>() {
							public void onFailure(Throwable arg0) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void onSuccess(String result) {
								
								// TODO Auto-generated method stub
								Info.display("Asociacion Especifica","Asociacion especifica con exito");
							}
							
							
							
							
						});
			
					}else{
						asociacionServices.eliminarAsociacionBloque(Registry.get("idPrograma")+"", ((BloqueModel) Registry.get("bloqueSeleccionadoFiltro")).getId()+"", ((CompetenciaEspecificaModel)Registry.get("especificaBloque")).getId()+"", 3, new AsyncCallback<String>() {
							public void onFailure(Throwable arg0) {
								// TODO Auto-generated method stub
								Info.display ("Asociacion Especifica",arg0.getMessage());
							}

							@Override
							public void onSuccess(String result) {
								
								// TODO Auto-generated method stub
								Info.display("Asociacion Especifica",result);
								if(!result.equals("Desasociacion exitosa")){
									chckbxAplica.setValue(!chckbxAplica.getValue());
								}
							}
							
							
							
							
						});
						
					}
				}else{
					
					chckbxAplica.setValue(!chckbxIntroduce.getValue());
					Info.display("Filtro","Debe seleccionar una materia y una competencia especifica para poder modificar");
					
				}
	
				
				
				
			}
		});
		
		
		cntntpnlAlcance.add(chckbxgrpAlcance);
		chckbxgrpAlcance.setFieldLabel("Alcance");
		add(cntntpnlAlcance, td_cntntpnlAlcance);
		cntntpnlAlcance.setHeight("49px");
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
		
		HiddenField hiddenField_5 = new HiddenField();
		add(hiddenField_5);
		
		HiddenField hiddenField_6 = new HiddenField();
		add(hiddenField_6);
		
		HiddenField hiddenField_4 = new HiddenField();
		add(hiddenField_4);
		
		HiddenField hiddenField_3 = new HiddenField();
		add(hiddenField_3);
		add(new Text());
		
		Button btnActualizarReporte = new Button("Actualizar Reporte");
		btnActualizarReporte.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				crearReporte(1,(String)Registry.get("idPrograma"));
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
		Registry.register("panelReporteBloques", cntntpnlReporteDeCambios);
		cntntpnlReporteDeCambios.setLayout(new TableLayout(1));
		TableData td_cntntpnlReporteDeCambios = new TableData();
		td_cntntpnlReporteDeCambios.setColspan(8);
		add(cntntpnlReporteDeCambios, td_cntntpnlReporteDeCambios);
		cntntpnlReporteDeCambios.setSize("724px", "611px");
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
		
		ButtonBar buttonBar = new ButtonBar();
		buttonBar.setAlignment(HorizontalAlignment.CENTER);
		TableData td_buttonBar = new TableData();
		td_buttonBar.setColspan(8);
		
		Button btnRegresarAlFiltro = new Button("Regresar");
		btnRegresarAlFiltro.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				Dispatcher.forwardEvent(DTEvent.CAMBIAR_PANELES, "Bloques-Filtro");
			}
		});
		buttonBar.add(btnRegresarAlFiltro);
		
		Button btnContinuar = new Button("Continuar");
		btnContinuar.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				Dispatcher.forwardEvent(DTEvent.CAMBIAR_PANELES, "Bloques-Materias");
			}
		});
		buttonBar.add(btnContinuar);
		btnContinuar.setWidth("63");
		add(buttonBar, td_buttonBar);
		eventoSeleccionarCompetencias();
		eventoSeleccionarBloques();
		
	}
	public void actualizarReporte(String url){
		
		System.out.println("Entra a ActualizarReporte");
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
//		System.out.println("Entra a crear reporte - ID: " + codigoPrograma);
//		actualizarReporte("http://localhost:8080/SAMA-WEB/Unidad1.pdf");
	}
	public void actualizarBloques(ListStore<BloqueModel> lista) {
		// TODO Auto-generated method stub
		if(lista!=null){
//			cmbxBloques.setStore(lista);
//			cmbxBloques.getListView().refresh();
//			cmbxBloques.setStore(lista);	
//			cmbxBloques.setVisible(false);
//			cmbxBloques.setVisible(true);
			
			grid_Bloquebloque.reconfigure(lista,getColumnModel());
		}else{

			grid_Bloquebloque.reconfigure(new ListStore<BloqueModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		}
	}

	public void refrescarListaEspecifica(
			ListStore<CompetenciaEspecificaModel> lista) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if(lista!=null){

			grid.reconfigure(lista, getColumnModel());			
		}else{

			grid.reconfigure(new ListStore<BloqueModel>(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
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
	
	public	 void eventoSeleccionarCompetencias(){
		
		grid.addListener(Events.CellClick, new Listener<GridEvent<CompetenciaEspecificaModel>>(){

			@Override
			public void handleEvent(GridEvent<CompetenciaEspecificaModel> be) {
				CompetenciaEspecificaModel pM = be.getGrid().getSelectionModel().getSelectedItem();
				Registry.register("especificaBloque",pM);
				if(Registry.get("bloqueSeleccionadoFiltro")!=null){
					chckbxAplica.setValue(false);
					chckbxEnsea.setValue(false);
					chckbxIntroduce.setValue(false);
					consultarChck();

					
				}
				
			}
			
			
		});
	}
	 public	 void eventoSeleccionarBloques(){
			
		 grid_Bloquebloque.addListener(Events.CellClick, new Listener<GridEvent<BloqueModel>>(){

				@Override
				public void handleEvent(GridEvent<BloqueModel> be) {
					BloqueModel pM = be.getGrid().getSelectionModel().getSelectedItem();
					Registry.register("bloqueSeleccionadoFiltro",pM);
					
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
	
	public void consultarChck(){
		busquedaServices.buscarAsociacionCompetenciaEspecificaBloque(Registry.get("idPrograma")+"",((BloqueModel) Registry.get("bloqueSeleccionadoFiltro")).getId()+"",((CompetenciaEspecificaModel)Registry.get("especificaBloque")).getId()+"", new AsyncCallback<AsociacionEspecificaBO>() {

			@Override
			public void onFailure(Throwable arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(AsociacionEspecificaBO result) {
				// TODO Auto-generated method stub
				Dispatcher.forwardEvent(DTEvent.ACTUALIZARCHK_BLOQUE,result);
			}
			
			
			
			
		});
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

	public CheckBox getChckbxAplica() {
		return chckbxAplica;
	}

	public void setChckbxAplica(CheckBox chckbxAplica) {
		this.chckbxAplica = chckbxAplica;
	}

}
