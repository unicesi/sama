/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package co.edu.unicesi.sama.client;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.client.bloques.PanelBloques;
import co.edu.unicesi.sama.client.busqueda.BusquedaService;
import co.edu.unicesi.sama.client.busqueda.BusquedaServiceAsync;
import co.edu.unicesi.sama.client.busqueda.ListaProgramas;
import co.edu.unicesi.sama.client.competencias.PanelCompetenciasProfesionales;
import co.edu.unicesi.sama.client.competencias.PanelCompetenciasTransversales;
import co.edu.unicesi.sama.client.competenciasEspecificas.PanelAsociarCompetenciasEspecificas;
import co.edu.unicesi.sama.client.competenciasEspecificas.PanelAsociarCompetenciasEspecificasBloque;
import co.edu.unicesi.sama.client.competenciasEspecificas.PanelFiltro;
import co.edu.unicesi.sama.client.controller.DTEvent;
import co.edu.unicesi.sama.client.controller.DTSamaController;
import co.edu.unicesi.sama.client.materias.VentanaMateria;
import co.edu.unicesi.sama.client.model.ProgramaModel;
import co.edu.unicesi.sama.client.programas.PanelProgramas;
import co.edu.unicesi.sama.client.programas.VentanaPrograma;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;

import java.util.ArrayList;
import java.util.Collections;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.Html;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.google.gwt.user.client.ui.Hyperlink;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.google.gwt.event.logical.shared.AttachEvent.Handler;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.user.client.ui.InlineHyperlink;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.google.gwt.user.client.ui.ScrollPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SAMA_WEB implements EntryPoint {
	
	private VentanaPrograma programa;
	private VentanaMateria materia;
	private ListaProgramas listaProgramas;
	private PanelBloques panelBloques;
	private PanelCompetenciasProfesionales panelProfesionales;
	private PanelCompetenciasTransversales panelTransversales;
	private PanelFiltro panelFiltro;
	private PanelAsociarCompetenciasEspecificasBloque panelAsociarBloque;
	private PanelAsociarCompetenciasEspecificas panelAsociar;
	private final BusquedaServiceAsync busquedaService = GWT.create(BusquedaService.class);
	
	public void onModuleLoad() {

		Dispatcher.get( ).addController( new DTSamaController( ) );
		RootPanel rootPanel = RootPanel.get();
		rootPanel.setSize("800\t\n", "600");
		
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new BorderLayout());
		
		VerticalPanel verticalPanel = new VerticalPanel();
		
		listaProgramas = new ListaProgramas();
		Registry.register("listaProgramas", listaProgramas);
		verticalPanel.add(listaProgramas);
		
		
		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_1.setLayout(new TableLayout(2));
		layoutContainer_1.add(new Text());
		layoutContainer_1.add(new Text());
		layoutContainer_1.add(new Text());
		
		Button btnAgregarPrograma = new Button("Agregar Programa");
		btnAgregarPrograma.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				programa = new VentanaPrograma();
				programa.setSize(430, 340);
				programa.show();
				
			}
		});
		layoutContainer_1.add(btnAgregarPrograma);
		btnAgregarPrograma.setWidth("197px");
		layoutContainer_1.add(new Text());
		
		HiddenField hiddenField = new HiddenField();
		layoutContainer_1.add(hiddenField);
		layoutContainer_1.add(new Text());
		
		Button btnAgregarMateria = new Button("Agregar Materia");
		btnAgregarMateria.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				materia = new VentanaMateria();
				materia.setSize(430, 340);
				materia.show();
			}
		});
		layoutContainer_1.add(btnAgregarMateria);
		btnAgregarMateria.setWidth("197px");
		verticalPanel.add(layoutContainer_1);
		layoutContainer_1.setSize("250", "100");
		layoutContainer_1.setBorders(true);
		layoutContainer.add(verticalPanel, new BorderLayoutData(LayoutRegion.WEST, 250.0f));
		
		Html htmlnewhtmlcomponent = new Html("<b>New</b><br><i>Html<i><br><u>Component</>");
		layoutContainer.add(htmlnewhtmlcomponent, new BorderLayoutData(LayoutRegion.NORTH, 150.0f));
		
		TabPanel tabPanel = new TabPanel();
		tabPanel.setEnabled(false);
		Registry.register("tabPanel", tabPanel);
		
		TabItem tbtmBloques = new TabItem("Bloques");
		panelBloques = new PanelBloques();
		Registry.register("panelBloques", panelBloques);
		tbtmBloques.add(panelBloques);
		tabPanel.add(tbtmBloques);
		

		
		TabItem tbtmCompetenciasProfesionales = new TabItem("Competencias Profesionales");
		panelProfesionales=new PanelCompetenciasProfesionales();
		Registry.register("panelProfesionales", panelProfesionales);
		
		TableLayout tableLayout = (TableLayout) panelProfesionales.getLayout();

		tbtmCompetenciasProfesionales.add(panelProfesionales);
		tabPanel.add(tbtmCompetenciasProfesionales);

		

		
		TabItem tbtmCompetenciasTransversales = new TabItem("Competencias Transversales");
		panelTransversales=new PanelCompetenciasTransversales();
		Registry.register("panelTransversales", panelTransversales);
		tbtmCompetenciasTransversales.add(panelTransversales);
		tabPanel.add(tbtmCompetenciasTransversales);
		
		TabItem tbtmAsociarCompetenciasEspecificas = new TabItem("Asociar Competencias Especificas");
		panelFiltro = new PanelFiltro();
		tbtmAsociarCompetenciasEspecificas.setScrollMode(Scroll.AUTOY);
		Registry.register("panelFiltro", panelFiltro);
		
		panelAsociar = new PanelAsociarCompetenciasEspecificas();
		Registry.register("panelAsociar", panelAsociar);
		
		panelAsociarBloque = new PanelAsociarCompetenciasEspecificasBloque();
		Registry.register("panelAsociarBloque", panelAsociarBloque);
		
		tbtmAsociarCompetenciasEspecificas.add(panelFiltro);
		tabPanel.add(tbtmAsociarCompetenciasEspecificas);
		layoutContainer.add(tabPanel, new BorderLayoutData(LayoutRegion.CENTER));
		rootPanel.add(layoutContainer);
		rootPanel.setWidgetPosition(layoutContainer, 0, 0);
		layoutContainer.setSize("1022px", "640px");
		layoutContainer.setBorders(true);
		actualizarPanel();

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

