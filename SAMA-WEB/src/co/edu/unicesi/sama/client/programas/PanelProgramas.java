package co.edu.unicesi.sama.client.programas;

import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.client.busqueda.ListaProgramas;

import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.ListView;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.widget.layout.TableData;
import com.extjs.gxt.ui.client.Style.VerticalAlignment;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.ButtonEvent;

public class PanelProgramas extends LayoutContainer {

	private ProgramaServiceAsync programaService = GWT.create(ProgramaService.class);
	private TextField txtfldNombrePrograma;
	private NumberField nmbrfldCodigoPrograma;
	private TextArea txtrDescripcion;
	private ListaProgramas listaProgramas;
	
	public PanelProgramas() {
		setSize("800", "386");
		setLayout(new BorderLayout());
		
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
		
		HiddenField hiddenField_6 = new HiddenField();
		layoutContainer.add(hiddenField_6);
		
		HiddenField hiddenField_5 = new HiddenField();
		layoutContainer.add(hiddenField_5);
		
		HiddenField hiddenField_3 = new HiddenField();
		layoutContainer.add(hiddenField_3);
		
		LabelField lblfldNombreDelPrograma = new LabelField("Nombre del programa");
		layoutContainer.add(lblfldNombreDelPrograma);
		layoutContainer.add(new Text());
		
		txtfldNombrePrograma = new TextField();
		layoutContainer.add(txtfldNombrePrograma);
		txtfldNombrePrograma.setWidth("305px");
		txtfldNombrePrograma.setFieldLabel("New TextField");
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		
		HiddenField hiddenField_1 = new HiddenField();
		layoutContainer.add(hiddenField_1);
		hiddenField_1.setHeight("10");
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		
		LabelField lblfldCdigoDelPrograma = new LabelField("C\u00F3digo del programa");
		layoutContainer.add(lblfldCdigoDelPrograma);
		
		HiddenField hiddenField = new HiddenField();
		layoutContainer.add(hiddenField);
		
		nmbrfldCodigoPrograma = new NumberField();
		layoutContainer.add(nmbrfldCodigoPrograma);
		nmbrfldCodigoPrograma.setWidth("305px");
		nmbrfldCodigoPrograma.setFieldLabel("Codigo Programa");
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		
		HiddenField hiddenField_2 = new HiddenField();
		layoutContainer.add(hiddenField_2);
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		
		LabelField lblfldDescripcin = new LabelField("Descripci\u00F3n del programa");
		TableData td_lblfldDescripcin = new TableData();
		td_lblfldDescripcin.setVerticalAlign(VerticalAlignment.TOP);
		layoutContainer.add(lblfldDescripcin, td_lblfldDescripcin);
		layoutContainer.add(new Text());
		
		txtrDescripcion = new TextArea();
		layoutContainer.add(txtrDescripcion);
		txtrDescripcion.setSize("305px", "125px");
		txtrDescripcion.setFieldLabel("New TextArea");
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		
		HiddenField hiddenField_4 = new HiddenField();
		layoutContainer.add(hiddenField_4);
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		layoutContainer.add(new Text());
		
		ButtonBar buttonBar = new ButtonBar();
		buttonBar.setAlignment(HorizontalAlignment.CENTER);
		
		Button btnLimpiar = new Button("Limpiar");
		btnLimpiar.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
			
				txtfldNombrePrograma.clear();
				nmbrfldCodigoPrograma.clear();
				txtrDescripcion.clear();			
				
			}
		});
		buttonBar.add(btnLimpiar);
		
		Button btnAgregar = new Button("Agregar");
		btnAgregar.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				crearPrograma();
				listaProgramas = new ListaProgramas();
				txtfldNombrePrograma.clear();
				nmbrfldCodigoPrograma.clear();
				txtrDescripcion.clear();
			}
		});
		buttonBar.add(btnAgregar);
		layoutContainer.add(buttonBar);
		add(layoutContainer, new BorderLayoutData(LayoutRegion.EAST, 520.0f));
		layoutContainer.setBorders(true);
		
		listaProgramas = new ListaProgramas();
		add(listaProgramas, new BorderLayoutData(LayoutRegion.WEST, 280.0f));
	}
	
	private void crearPrograma(){
		ProgramaBO programa = new ProgramaBO();
		programa.setNombre(txtfldNombrePrograma.getValue().toString());
		programa.setIdPrograma(nmbrfldCodigoPrograma.getValue().intValue());
		programa.setDescripcion(txtrDescripcion.getValue());
		programaService.crearPrograma(programa, new AsyncCallback<String>(){

			@Override
			public void onFailure(Throwable caught) {
				
				Info.display("Crear Programa", "No se pudo crear el programa");
			}

			@Override
			public void onSuccess(String result) {
				
				Info.display("Crear Programa", "<ul><li>" + (result.equals("Error") ?
						"Ha ocurrido un error creando el programa" : "Se ha creado el programa " + result + " exitosamente") + "</li></ul>");
			}

			
		});
		
	}

}
