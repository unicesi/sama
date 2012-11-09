package co.edu.unicesi.sama.client.bloques;

import java.util.ArrayList;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.client.busqueda.BusquedaService;
import co.edu.unicesi.sama.client.busqueda.BusquedaServiceAsync;
import co.edu.unicesi.sama.client.controller.DTEvent;
import co.edu.unicesi.sama.client.programas.ProgramaServiceAsync;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.Dialog;
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

public class VentanaBloque extends Window {

	private BloqueServiceAsync bloqueService = GWT.create(BloqueService.class);
	TextField txtfldNombreBloque;
	NumberField nmbrfldCodigoBloque;
	TextArea txtrDescripcionBloque;
	private final BusquedaServiceAsync busquedaService = GWT.create(BusquedaService.class);
	private ProgramaBO programa;
	
	public VentanaBloque() {
		setHeading("Crear Bloque");
		setLayout(new TableLayout(4));
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		
		LabelField lblfldNombreDelPrograma = new LabelField("Nombre\n");
		add(lblfldNombreDelPrograma);
		add(new Text());
		
		txtfldNombreBloque = new TextField();
		add(txtfldNombreBloque);
		txtfldNombreBloque.setWidth("300px");
		txtfldNombreBloque.setFieldLabel("NombrePrograma");
		add(new Text());
		add(new Text());
		add(new Text());
		
		HiddenField hiddenField_1 = new HiddenField();
		add(hiddenField_1);
		add(new Text());
		
		LabelField lblfldCdigo = new LabelField("C\u00F3digo");
		add(lblfldCdigo);
		add(new Text());
		
		nmbrfldCodigoBloque = new NumberField();
		add(nmbrfldCodigoBloque);
		nmbrfldCodigoBloque.setWidth("300px");
		nmbrfldCodigoBloque.setFieldLabel("New NumberField");
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
		
		txtrDescripcionBloque = new TextArea();
		add(txtrDescripcionBloque);
		txtrDescripcionBloque.setSize("300px", "150px");
		txtrDescripcionBloque.setFieldLabel("DescripcionBloque");
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
				
				crearBloque();
				
			}
		});
		buttonBar.add(btnAgregar);
		add(buttonBar);
	}
	
	private void crearBloque(){
		if(validaCampos()){
		BloqueBO bloque = new BloqueBO();
		bloque.setNombre(txtfldNombreBloque.getValue().toString());
		bloque.setIdBloque(nmbrfldCodigoBloque.getValue().intValue());
		bloque.setDescripcion(txtrDescripcionBloque.getValue());
		bloqueService.crearBloque(""+programa.getIdPrograma(), bloque, new AsyncCallback<String>(){

			@Override
			public void onFailure(Throwable caught) {
				
				Info.display("Crear Bloque", "No se pudo crear el bloque");
				txtfldNombreBloque.clear();
				txtrDescripcionBloque.clear();
				nmbrfldCodigoBloque.clear();
				
			}

			@Override
			public void onSuccess(String result) {
				
				Info.display("Crear Bloque", "<ul><li>" + (result.equals("Error") ?
						"Ha ocurrido un error creando el bloque" : "Se ha creado el bloque " + result + " exitosamente") + "</li></ul>");
			
				txtfldNombreBloque.clear();
				txtrDescripcionBloque.clear();
				nmbrfldCodigoBloque.clear();
				actualizarLista();
				if(!result.equals("Error")){
					close();
				}
			}

		});
		}else{
			Dialog dial= new Dialog();
			dial.setHeading("Error de campos");
			dial.addText("Campos vaciós en el formulario");
			dial.show();
		}
	}

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
	
	public void asignarPrograma(){
		
		this.programa = new ProgramaBO();
		programa.setIdPrograma((Integer) Registry.get("idPrograma"));
	}
	
	private boolean validaCampos() {
		// TODO Auto-generated method stub
		if(	txtfldNombreBloque.getValue().toString().trim().equals("") ||nmbrfldCodigoBloque.getValue().toString().trim().equals("")||txtrDescripcionBloque.getValue().toString().trim().equals(""))
//		programa.setIdPrograma(nmbrfldCodigoPrograma.getValue().intValue()) ||
//		programa.setDescripcion(txtrDescripcionPrograma.getValue()))
		{
			return false;
		}else
		{
			return true;
		}
	}
}
