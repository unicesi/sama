package co.edu.unicesi.sama.client.programas;

import java.util.ArrayList;

import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.client.busqueda.BusquedaService;
import co.edu.unicesi.sama.client.busqueda.BusquedaServiceAsync;
import co.edu.unicesi.sama.client.controller.DTEvent;

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
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.mvc.Dispatcher;

public class VentanaPrograma extends Window {

	private ProgramaServiceAsync programaService = GWT.create(ProgramaService.class);
	TextField txtfldNombrePrograma;
	NumberField nmbrfldCodigoPrograma;
	TextArea txtrDescripcionPrograma;
	private final BusquedaServiceAsync busquedaService = GWT.create(BusquedaService.class);
	
	public VentanaPrograma() {
		setHeading("Crear Programa");
		setLayout(new TableLayout(4));
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		
		LabelField lblfldNombreDelPrograma = new LabelField("Nombre\n");
		add(lblfldNombreDelPrograma);
		add(new Text());
		
		txtfldNombrePrograma = new TextField();
		add(txtfldNombrePrograma);
		txtfldNombrePrograma.setWidth("300px");
		txtfldNombrePrograma.setFieldLabel("NombrePrograma");
		add(new Text());
		add(new Text());
		add(new Text());
		
		HiddenField hiddenField_1 = new HiddenField();
		add(hiddenField_1);
		add(new Text());
		
		LabelField lblfldCdigo = new LabelField("C\u00F3digo");
		add(lblfldCdigo);
		add(new Text());
		
		nmbrfldCodigoPrograma = new NumberField();
		add(nmbrfldCodigoPrograma);
		nmbrfldCodigoPrograma.setWidth("300px");
		nmbrfldCodigoPrograma.setFieldLabel("New NumberField");
		add(new Text());
		add(new Text());
		add(new Text());
		
		HiddenField hiddenField_2 = new HiddenField();
		add(hiddenField_2);
		add(new Text());
		
		LabelField lblfldDescripcin = new LabelField("Descripci\u00F3n");
		add(lblfldDescripcin);
		
		HiddenField hiddenField = new HiddenField();
		add(hiddenField);
		
		txtrDescripcionPrograma = new TextArea();
		add(txtrDescripcionPrograma);
		txtrDescripcionPrograma.setSize("300px", "150px");
		txtrDescripcionPrograma.setFieldLabel("DescripcionPrograma");
		add(new Text());
		add(new Text());
		add(new Text());
		
		HiddenField hiddenField_3 = new HiddenField();
		add(hiddenField_3);
		add(new Text());
		add(new Text());
		add(new Text());
		
		ButtonBar buttonBar = new ButtonBar();
		buttonBar.setAlignment(HorizontalAlignment.CENTER);
		
		Button btnLimpiar = new Button("Limpiar");
		btnLimpiar.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
			}
		});
		buttonBar.add(btnLimpiar);
		
		Button btnAgregar = new Button("Agregar");
		btnAgregar.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				crearPrograma();
				
			}
		});
		buttonBar.add(btnAgregar);
		add(buttonBar);
	}
	
	private void crearPrograma(){
		ProgramaBO programa = new ProgramaBO();
		programa.setNombre(txtfldNombrePrograma.getValue().toString());
		programa.setIdPrograma(nmbrfldCodigoPrograma.getValue().intValue());
		programa.setDescripcion(txtrDescripcionPrograma.getValue());
		programaService.crearPrograma(programa, new AsyncCallback<String>(){

			@Override
			public void onFailure(Throwable caught) {
				
				Info.display("Crear Programa", "No se pudo crear el programa");
				txtfldNombrePrograma.clear();
				txtrDescripcionPrograma.clear();
				nmbrfldCodigoPrograma.clear();
				
			}

			@Override
			public void onSuccess(String result) {
				
				Info.display("Crear Programa", "<ul><li>" + (result.equals("Error") ?
						"Ha ocurrido un error creando el programa" : "Se ha creado el programa " + result + " exitosamente") + "</li></ul>");
			
				txtfldNombrePrograma.clear();
				txtrDescripcionPrograma.clear();
				nmbrfldCodigoPrograma.clear();
				actualizarPanel();
				if(!result.equals("Error")){
					
					close();
				}
			}

		});

	}

	private void actualizarPanel(){
		
		busquedaService.darProgramasOrdenadosPorNombre(new AsyncCallback<ArrayList<ProgramaBO>>(){

			@Override
			public void onFailure(Throwable arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(ArrayList<ProgramaBO> result) {
				System.out.println("Resultado en Ventana");
				for(ProgramaBO bo:result){
					
					System.out.println("Nombre: " + bo.getNombre());
				}
				Dispatcher.forwardEvent(DTEvent.REFRESCAR_PROGRAMAS, result);
			}
		});
		
	}
}
