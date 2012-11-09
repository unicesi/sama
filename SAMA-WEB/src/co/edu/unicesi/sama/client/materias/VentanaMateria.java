package co.edu.unicesi.sama.client.materias;

import co.edu.unicesi.sama.bo.MateriaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.client.bloques.PanelBloques;

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

public class VentanaMateria extends Window {

	private MateriaServiceAsync materiaService = GWT.create(MateriaService.class);
	TextField txtfldNombreMateria;
	NumberField nmbrfldCodigoMateria;
	TextArea txtrDescripcionMateria;
	
	public VentanaMateria() {
		setHeading("Crear Materia");
		setLayout(new TableLayout(4));
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		
		LabelField lblfldNombreDelPrograma = new LabelField("Nombre\n");
		add(lblfldNombreDelPrograma);
		add(new Text());
		
		txtfldNombreMateria = new TextField();
		add(txtfldNombreMateria);
		txtfldNombreMateria.setWidth("300px");
		txtfldNombreMateria.setFieldLabel("NombrePrograma");
		add(new Text());
		add(new Text());
		add(new Text());
		
		HiddenField hiddenField_1 = new HiddenField();
		add(hiddenField_1);
		add(new Text());
		
		LabelField lblfldCdigo = new LabelField("C\u00F3digo");
		add(lblfldCdigo);
		add(new Text());
		
		nmbrfldCodigoMateria = new NumberField();
		add(nmbrfldCodigoMateria);
		nmbrfldCodigoMateria.setWidth("300px");
		nmbrfldCodigoMateria.setFieldLabel("New NumberField");
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
		
		txtrDescripcionMateria = new TextArea();
		add(txtrDescripcionMateria);
		txtrDescripcionMateria.setSize("300px", "150px");
		txtrDescripcionMateria.setFieldLabel("DescripcionPrograma");
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
				
				crearMateria();
				
				
			}
		});
		buttonBar.add(btnAgregar);
		add(buttonBar);
	}
	
	private void crearMateria(){
		if(validaCampos()){
		MateriaBO materia = new MateriaBO();
		materia.setNombre(txtfldNombreMateria.getValue().toString());
		materia.setIdMateria(nmbrfldCodigoMateria.getValue().intValue());
		materia.setDescripcion(txtrDescripcionMateria.getValue());
		materiaService.crearMateria(materia, new AsyncCallback<String>(){

			@Override
			public void onFailure(Throwable caught) {
				
				Info.display("Crear Materia", "Ha ocurrido un error creando la materia");
				txtfldNombreMateria.clear();
				txtrDescripcionMateria.clear();
				nmbrfldCodigoMateria.clear();
			}

			@SuppressWarnings("deprecation")
			@Override
			public void onSuccess(String result) {
				
				
				Info.display("Crear Materia", "<ul><li>" + (result.equals("Error") ?
						"Ha ocurrido un error creando la materia" : "Se ha creado la materia " + result + " exitosamente") + "</li></ul>");
				
				txtfldNombreMateria.clear();
				txtrDescripcionMateria.clear();
				nmbrfldCodigoMateria.clear();
				PanelBloques panelBloques = (PanelBloques)Registry.get("panelBloques");
				panelBloques.cargarMaterias();
				
				if(!result.equals("Error")){
					panelBloques = (PanelBloques)Registry.get("panelBloques");
					panelBloques.cargarMaterias();
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
	private boolean validaCampos() {
		// TODO Auto-generated method stub
		if(	txtfldNombreMateria.getValue().toString().trim().equals("") ||nmbrfldCodigoMateria.getValue().toString().trim().equals("")||txtrDescripcionMateria.getValue().toString().trim().equals(""))
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
