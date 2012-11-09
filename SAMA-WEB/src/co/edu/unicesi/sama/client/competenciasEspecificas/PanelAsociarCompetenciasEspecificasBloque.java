package co.edu.unicesi.sama.client.competenciasEspecificas;

import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import java.util.Collections;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.layout.TableData;
import com.extjs.gxt.ui.client.Style.VerticalAlignment;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
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

public class PanelAsociarCompetenciasEspecificasBloque extends LayoutContainer {

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
		
		ComboBox cmbxBloques = new ComboBox();
		cmbxBloques.setStore(new ListStore());
		add(cmbxBloques);
		cmbxBloques.setSize("250", "22");
		cmbxBloques.setFieldLabel("comboBloques");
		add(new Text());
		add(new Text());
		add(new Text());
		add(new Text());
		
		Grid grid = new Grid(new ListStore(), new ColumnModel(Collections.<ColumnConfig>emptyList()));
		TableData td_grid = new TableData();
		td_grid.setRowspan(3);
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
		
		ContentPanel cntntpnlAlcance = new ContentPanel();
		cntntpnlAlcance.setHeading("Alcance");
		TableData td_cntntpnlAlcance = new TableData();
		td_cntntpnlAlcance.setHorizontalAlign(HorizontalAlignment.CENTER);
		
		CheckBoxGroup chckbxgrpAlcance = new CheckBoxGroup();
		
		CheckBox chckbxIntroduce = new CheckBox();
		chckbxgrpAlcance.add(chckbxIntroduce);
		chckbxIntroduce.setBoxLabel("Introduce");
		chckbxIntroduce.setHideLabel(true);
		
		CheckBox chckbxEnsea = new CheckBox();
		chckbxgrpAlcance.add(chckbxEnsea);
		chckbxEnsea.setBoxLabel("Ense\u00F1a");
		chckbxEnsea.setHideLabel(true);
		
		CheckBox chckbxAplica = new CheckBox();
		chckbxgrpAlcance.add(chckbxAplica);
		chckbxAplica.setBoxLabel("Aplica");
		chckbxAplica.setHideLabel(true);
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
		
		ContentPanel cntntpnlReporteDeCambios = new ContentPanel();
		cntntpnlReporteDeCambios.setHeading("Reporte de Cambios");
		cntntpnlReporteDeCambios.setLayout(new TableLayout(1));
		TableData td_cntntpnlReporteDeCambios = new TableData();
		td_cntntpnlReporteDeCambios.setColspan(8);
		add(cntntpnlReporteDeCambios, td_cntntpnlReporteDeCambios);
		cntntpnlReporteDeCambios.setSize("724px", "611px");
		
	}

}
