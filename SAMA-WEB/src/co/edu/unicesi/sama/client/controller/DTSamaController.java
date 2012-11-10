package co.edu.unicesi.sama.client.controller;

import java.util.ArrayList;

import co.edu.unicesi.sama.bo.BloqueBO;


import co.edu.unicesi.sama.bo.CompetenciaTerminalBO;
import co.edu.unicesi.sama.bo.CompetenciaEspecificaBO;
import co.edu.unicesi.sama.bo.MateriaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.client.bloques.PanelBloques;
import co.edu.unicesi.sama.client.bloques.VentanaBloque;
import co.edu.unicesi.sama.client.busqueda.ListaProgramas;
import co.edu.unicesi.sama.client.competencias.PanelCompetenciasProfesionales;
import co.edu.unicesi.sama.client.competencias.PanelCompetenciasTransversales;
import co.edu.unicesi.sama.client.model.BloqueModel;
import co.edu.unicesi.sama.client.model.CompetenciaTerminalModel;
import co.edu.unicesi.sama.client.model.CompetenciaEspecificaModel;
import co.edu.unicesi.sama.client.model.MateriaModel;
import co.edu.unicesi.sama.client.model.ProgramaModel;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.TabPanel;

public class DTSamaController extends Controller{

	public DTSamaController(){

		registerEventTypes(DTEvent.REFRESCAR_PROGRAMAS);
		registerEventTypes(DTEvent.REFRESCAR_MATERIAS);
		registerEventTypes(DTEvent.REFRESCAR_BLOQUES);
		registerEventTypes(DTEvent.REFRESCAR_COMPETENCIAS_PROFESIONALES);
		registerEventTypes(DTEvent.REFRESCAR_COMPETENCIAS_TRANSVERSALES);
		registerEventTypes(DTEvent.SELECCIONAR_PROGRAMA);
		registerEventTypes(DTEvent.SELECCIONAR_BLOQUE);
		registerEventTypes(DTEvent.SELECCIONAR_COMPETENCIA_PROFESIONAL);
		registerEventTypes(DTEvent.SELECCIONAR_COMPETENCIA_TRANSVERSAL);
		registerEventTypes(DTEvent.ASOCIAR_MATERIA);
		registerEventTypes(DTEvent.DESASOCIAR_MATERIA);
		registerEventTypes(DTEvent.ASOCIAR_LINEA_PROFESIONAL);
		registerEventTypes(DTEvent.DESASOCIAR_LINEA_PROFESIONAL);
		registerEventTypes(DTEvent.ASOCIAR_LINEA_TRANSVERSAL);
		registerEventTypes(DTEvent.DESASOCIAR_LINEA_TRANSVERSAL);
		registerEventTypes(DTEvent.REFRESCAR_MATERIAS_BLOQUESNOASOCIADAS);
		registerEventTypes(DTEvent.REFRESCAR_MATERIAS_BLOQUES);

		registerEventTypes(DTEvent.REFRESCAR_LINEA_PROFESIONAL);
		registerEventTypes(DTEvent.REFRESCAR_LINEA_TRANSVERSALNOASOCIADAS);
		registerEventTypes(DTEvent.REFRESCAR_LINEA_TRANSVERSAL);


	}
	@Override
	public void handleEvent(AppEvent event) {
		if(event.getType().equals(DTEvent.REFRESCAR_PROGRAMAS)){

			ArrayList<ProgramaBO> programas = (ArrayList<ProgramaBO>)event.getData();

			ListStore<ProgramaModel> lista = new ListStore<ProgramaModel>();
			for(ProgramaBO p:programas){

				lista.add(ProgramaModel.toModelFromBO(p));

			}
			ListaProgramas listaProgramas = Registry.get("listaProgramas");
			listaProgramas.actualizarListaProgramas(lista);
		}else{

			if(event.getType().equals(DTEvent.SELECCIONAR_PROGRAMA)){

				ProgramaModel model = (ProgramaModel)event.getData();
				Registry.register( "idPrograma", model.getId());

				//TODO Asociar a los paneles
				PanelBloques panelBloques = Registry.get("panelBloques");
				panelBloques.limpiar();
				panelBloques.asignarPrograma();
				PanelCompetenciasProfesionales panelProf = Registry.get("panelProfesionales");
				panelProf.limpiar();
				panelProf.asignarPrograma();
				
				PanelCompetenciasTransversales panelTrans = Registry.get("panelTransversales");
				panelTrans.limpiar();
				panelTrans.asignarPrograma();

				VentanaBloque ventanaBloque = Registry.get("ventanaBloque");
				ventanaBloque.asignarPrograma();

				TabPanel tabs = Registry.get( "tabPanel");
				tabs.enable( );



			}else{

				if(event.getType().equals(DTEvent.REFRESCAR_BLOQUES)){

					ArrayList<BloqueBO> bloques = (ArrayList<BloqueBO>)event.getData();

					ListStore<BloqueModel> lista = new ListStore<BloqueModel>();
					if(bloques!=null){
						for(BloqueBO b:bloques){

							lista.add(BloqueModel.toModelFromBO(b));

						}
						PanelBloques panelBloques = Registry.get("panelBloques");
						panelBloques.actualizarListaBloques(lista);
					}else{

						PanelBloques panelBloques = Registry.get("panelBloques");
						panelBloques.actualizarListaBloques(null);
					}


				}else{

					if(event.getType().equals(DTEvent.REFRESCAR_COMPETENCIAS_PROFESIONALES)){

						ArrayList<CompetenciaTerminalBO> competencias = (ArrayList<CompetenciaTerminalBO>)event.getData();

						ListStore<CompetenciaTerminalModel> lista = new ListStore<CompetenciaTerminalModel>();

						if(competencias!=null){

							for(CompetenciaTerminalBO b:competencias){


								lista.add(CompetenciaTerminalModel.toModelFromBO(b));

							}

							PanelCompetenciasProfesionales panelprof = Registry.get("panelProfesionales");
							panelprof.actualizarListaLineas(lista);
						}else{

							PanelCompetenciasProfesionales panelprof = Registry.get("panelProfesionales");
							panelprof.actualizarListaLineas(null);
						}


					}else{
						
						if(event.getType().equals(DTEvent.REFRESCAR_COMPETENCIAS_TRANSVERSALES)){

							ArrayList<CompetenciaTerminalBO> competencias = (ArrayList<CompetenciaTerminalBO>)event.getData();

							ListStore<CompetenciaTerminalModel> lista = new ListStore<CompetenciaTerminalModel>();

							if(competencias!=null){

								for(CompetenciaTerminalBO b:competencias){


									lista.add(CompetenciaTerminalModel.toModelFromBO(b));

								}

								PanelCompetenciasTransversales panelTrans = Registry.get("panelTransversales");
								panelTrans.actualizarListaLineas(lista);
							}else{

								PanelCompetenciasTransversales panelTrans = Registry.get("panelTransversales");
								panelTrans.actualizarListaLineas(null);
							}


						}else{

						if(event.getType().equals(DTEvent.SELECCIONAR_BLOQUE)){

							BloqueModel model = (BloqueModel)event.getData();
							Registry.register( "idBloque", model.getId());

							//TODO Asociar a los paneles
							PanelBloques panelBloques = Registry.get("panelBloques");
							panelBloques.cargarMaterias();


						}else{

							if(event.getType().equals(DTEvent.SELECCIONAR_COMPETENCIA_PROFESIONAL)){
								
								CompetenciaTerminalModel model =(CompetenciaTerminalModel)event.getData();
								System.out.println("llamando evento selecionar comp profesional" + model.getId());
								Registry.register( "idCompetenciaProfesional", model.getId());

								//TODO Asociar a los paneles
								PanelCompetenciasProfesionales panelProf  =Registry.get("panelProfesionales");
								panelProf.cargarLineasProf();

							}else{
								
								if(event.getType().equals(DTEvent.SELECCIONAR_COMPETENCIA_TRANSVERSAL)){
									
									CompetenciaTerminalModel model =(CompetenciaTerminalModel)event.getData();
									System.out.println("llamando evento selecionar comp profesional" + model.getId());
									Registry.register( "idCompetenciaTransversal", model.getId());

									//TODO Asociar a los paneles
									PanelCompetenciasTransversales panelTrans = Registry.get("panelTransversales");
									panelTrans.cargarLineasProf();

								}else{
								
								if(event.getType().equals(DTEvent.ASOCIAR_MATERIA)){

									PanelBloques panelBloques = Registry.get("panelBloques");
									panelBloques.asociarMateria();



								}else{

									if(event.getType().equals(DTEvent.DESASOCIAR_MATERIA)){

										PanelBloques panelBloques = Registry.get("panelBloques");
										panelBloques.desasociarMateria();



									}else{

								if(event.getType().equals(DTEvent.ASOCIAR_LINEA_PROFESIONAL)){

									PanelCompetenciasProfesionales panelProf  =Registry.get("panelProfesionales");
									panelProf.asociarLinea();



								}else{

									if(event.getType().equals(DTEvent.DESASOCIAR_LINEA_PROFESIONAL)){

										PanelCompetenciasProfesionales panelProf  =Registry.get("panelProfesionales");
										panelProf.desasociarLinea();



									}else{
								
								if(event.getType().equals(DTEvent.ASOCIAR_LINEA_TRANSVERSAL)){

									PanelCompetenciasTransversales panelTrans = Registry.get("panelTransversales");
									panelTrans.asociarLinea();



								}else{

									if(event.getType().equals(DTEvent.DESASOCIAR_LINEA_TRANSVERSAL)){

										PanelCompetenciasTransversales panelTrans = Registry.get("panelTransversales");
										panelTrans.desasociarLinea();



									}else{
										if(event.getType().equals(DTEvent.REFRESCAR_LINEA_PROFESIONAL)){
											System.out.println("entrando a refrescar linea profesional");
											ArrayList<CompetenciaEspecificaBO> lineas = (ArrayList<CompetenciaEspecificaBO>)event.getData();

											ListStore<CompetenciaEspecificaModel> listaAsociados = new ListStore<CompetenciaEspecificaModel>();
											ListStore<CompetenciaEspecificaModel> listaNoAsociados = new ListStore<CompetenciaEspecificaModel>();
											
											for(CompetenciaEspecificaBO b:lineas){
												System.out.println(b.getIdLineaDeCompetencia()+"-"+String.valueOf(b.isAsociado()));
												
											}
											if(lineas!=null){
												for(CompetenciaEspecificaBO b:lineas){
													if(b.isAsociado()){
														listaAsociados.add(CompetenciaEspecificaModel.toModelFromBO(b));
													}else{
														listaNoAsociados.add(CompetenciaEspecificaModel.toModelFromBO(b));
													}
													

												}
												PanelCompetenciasProfesionales panelCompetenciasProf = Registry.get("panelProfesionales");
												panelCompetenciasProf.actualizarListaCompetenciasAsociadas(listaAsociados);
												panelCompetenciasProf.actualziarListaCompetenciasNoAsociadas(listaNoAsociados);

											}else{

												PanelCompetenciasProfesionales panelCompetenciasProf = Registry.get("panelProfesionales");
												panelCompetenciasProf.actualizarListaCompetenciasAsociadas(null);
												panelCompetenciasProf.actualziarListaCompetenciasNoAsociadas(null);

											}
										}

										else{
										
										if(event.getType().equals(DTEvent.REFRESCAR_LINEA_TRANSVERSAL)){
											
											ArrayList<CompetenciaEspecificaBO> lineas = (ArrayList<CompetenciaEspecificaBO>)event.getData();

											ListStore<CompetenciaEspecificaModel> listaAsociados = new ListStore<CompetenciaEspecificaModel>();
											ListStore<CompetenciaEspecificaModel> listaNoAsociados = new ListStore<CompetenciaEspecificaModel>();
											
										
											if(lineas!=null){
												for(CompetenciaEspecificaBO b:lineas){
													if(b.isAsociado()){
														listaAsociados.add(CompetenciaEspecificaModel.toModelFromBO(b));
													}else{
														listaNoAsociados.add(CompetenciaEspecificaModel.toModelFromBO(b));
													}
													

												}
												PanelCompetenciasTransversales panelTrans = Registry.get("panelTransversales");
												panelTrans.actualizarListaCompetenciasAsociadas(listaAsociados);
												panelTrans.actualziarListaCompetenciasNoAsociadas(listaNoAsociados);

											}else{

												PanelCompetenciasTransversales panelTrans = Registry.get("panelTransversales");
												panelTrans.actualizarListaCompetenciasAsociadas(null);
												panelTrans.actualziarListaCompetenciasNoAsociadas(null);

											}
										}

										else{
											if(event.getType().equals(DTEvent.REFRESCAR_MATERIAS_BLOQUES)){
												
												ArrayList<MateriaBO> materias = (ArrayList<MateriaBO>)event.getData();

												ListStore<MateriaModel> lista = new ListStore<MateriaModel>();
												if(materias!=null){
													for(MateriaBO b:materias){
														System.out.println(b.getIdMateria() + " " + b.getNombre());
														lista.add(MateriaModel.toModelFromBO(b));

													}
													PanelBloques panelBloques = Registry.get("panelBloques");
													panelBloques.actualizarListaMateriasAsociadas(lista);

												}else{

													PanelBloques panelBloques = Registry.get("panelBloques");
													panelBloques.actualizarListaMateriasAsociadas(null);

												}
											}if(event.getType().equals(DTEvent.REFRESCAR_MATERIAS_BLOQUESNOASOCIADAS)){
												System.out.println("entrando a refrescar materia bloques no asociadas");
												ArrayList<MateriaBO> materias = (ArrayList<MateriaBO>)event.getData();



												ListStore<MateriaModel> lista = new ListStore<MateriaModel>();
												if(materias!=null){
													for(MateriaBO b:materias){
														System.out.println(b.getIdMateria() + " " + b.getNombre());
														lista.add(MateriaModel.toModelFromBO(b));

													}
													PanelBloques panelBloques = Registry.get("panelBloques");
													panelBloques.actualziarListaMateriasNoAsociadas(lista);

												}else{

													PanelBloques panelBloques = Registry.get("panelBloques");
													panelBloques.actualziarListaMateriasNoAsociadas(null);

												}
											}
										}
									}
								}
							}
						}
					}

				}}}
					
						}
						}
					}}
				}}
		}
	}
}