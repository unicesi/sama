package co.edu.unicesi.sama.client.controller;

import java.util.ArrayList;
import java.util.Collections;

import co.edu.unicesi.sama.bo.BloqueBO;


import co.edu.unicesi.sama.bo.AsociacionEspecificaBO;
import co.edu.unicesi.sama.bo.CompetenciaTerminalBO;
import co.edu.unicesi.sama.bo.CompetenciaEspecificaBO;
import co.edu.unicesi.sama.bo.MateriaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;
import co.edu.unicesi.sama.client.bloques.PanelBloques;
import co.edu.unicesi.sama.client.bloques.VentanaBloque;
import co.edu.unicesi.sama.client.busqueda.ListaProgramas;
import co.edu.unicesi.sama.client.competencias.PanelCompetenciasProfesionales;
import co.edu.unicesi.sama.client.competencias.PanelCompetenciasTransversales;
import co.edu.unicesi.sama.client.competenciasEspecificas.PanelAsociarCompetenciasEspecificas;
import co.edu.unicesi.sama.client.competenciasEspecificas.PanelAsociarCompetenciasEspecificasBloque;
import co.edu.unicesi.sama.client.competenciasEspecificas.PanelFiltro;
import co.edu.unicesi.sama.client.competenciasEspecificas.VentanaBloqueFiltro;
import co.edu.unicesi.sama.client.competenciasEspecificas.VentanaMateriaFiltro;
import co.edu.unicesi.sama.client.model.BloqueModel;
import co.edu.unicesi.sama.client.model.CompetenciaTerminalModel;
import co.edu.unicesi.sama.client.model.CompetenciaEspecificaModel;
import co.edu.unicesi.sama.client.model.MateriaModel;
import co.edu.unicesi.sama.client.model.ProgramaModel;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;

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

		registerEventTypes(DTEvent.REFRESCAR_COMPETENCIA_ESPECIFICA);
		registerEventTypes(DTEvent.REFRESCAR_FILTRO);

		registerEventTypes(DTEvent.FILTRAR_BLOQUE);
		registerEventTypes(DTEvent.DESFILTRAR_BLOQUE);
		registerEventTypes(DTEvent.FILTRAR_TRANSVERSAL);
		registerEventTypes(DTEvent.DESFILTRAR_TRANSVERSAL);
		registerEventTypes(DTEvent.FILTRAR_PROFESIONAL);
		registerEventTypes(DTEvent.DESFILTRAR_PROFESIONAL);
		registerEventTypes(DTEvent.CAMBIAR_PANELES);
		registerEventTypes(DTEvent.ACTUALIZAR_BLOQUES_FILTRO);
		registerEventTypes(DTEvent.CERRAR_VENTANA_BLOQUEFILTRO);

		registerEventTypes(DTEvent.ABRIR_BLOQUE_FILTRO);
		
		
		registerEventTypes(DTEvent.CERRAR_VENTANA_MATERIAFILTRO);
		registerEventTypes(DTEvent.ABRIR_MATERIA_FILTRO);
		
		
		registerEventTypes(DTEvent.REFRESCAR_MATERIAS_FILTRO);
		registerEventTypes(DTEvent.ACTUALIZARCHK_BLOQUE);
		registerEventTypes(DTEvent.ACTUALIZARCHK_MATERIA);

		





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

				Registry.register( "idCompetenciaTransversal", null);
				Registry.register( "idCompetenciaProfesional",null);
				Registry.register("BloqueFiltrado", null);
				Registry.register("BloqueDisponible", null);
				Registry.register("TransversalDisponible",null);
				Registry.register("TransversalFiltrado",null);
				Registry.register("ProfesionalDisponible",null);
				Registry.register("ProfesionalFiltrado",null);

				PanelFiltro panelFiltro = (PanelFiltro) Registry.get("panelFiltro");
				panelFiltro.actualizarListaBloquesFiltrados(null);
				panelFiltro.actualizarListaProfesionalFiltrados(null);
				panelFiltro.actualizarListaTransversalFiltrados(null);






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
						PanelFiltro panelFil = Registry.get("panelFiltro");
						panelFil.actualizarListaBloques(lista);
					}else{

						PanelBloques panelBloques = Registry.get("panelBloques");
						panelBloques.actualizarListaBloques(null);
						PanelFiltro panelFil = Registry.get("panelFiltro");
						panelFil.actualizarListaBloques(null);
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
							PanelFiltro panelFil = Registry.get("panelFiltro");
							panelFil.actualizarListaProfesionales(lista);
						}else{

							PanelCompetenciasProfesionales panelprof = Registry.get("panelProfesionales");
							panelprof.actualizarListaLineas(null);
							PanelFiltro panelFil = Registry.get("panelFiltro");
							panelFil.actualizarListaProfesionales(null);
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
								PanelFiltro panelFil = Registry.get("panelFiltro");
								panelFil.actualizarListaTransversales(lista);
							}else{

								PanelCompetenciasTransversales panelTrans = Registry.get("panelTransversales");
								panelTrans.actualizarListaLineas(null);
								PanelFiltro panelFil = Registry.get("panelFiltro");
								panelFil.actualizarListaTransversales(null);
							}


						}else{

							if(event.getType().equals(DTEvent.SELECCIONAR_BLOQUE)){

								BloqueModel model = (BloqueModel)event.getData();
								Registry.register( "idBloque", model.getId());

								//TODO Asociar a los paneles
								PanelBloques panelBloques = Registry.get("panelBloques");
								panelBloques.cargarMaterias();

								Registry.register( "idCompetenciaTransversal", null);
								Registry.register( "idCompetenciaProfesional",null);
							}else{

								if(event.getType().equals(DTEvent.ACTUALIZARCHK_BLOQUE)){

									AsociacionEspecificaBO bo = (AsociacionEspecificaBO)event.getData();
									//TODO								
									
									PanelAsociarCompetenciasEspecificasBloque panelBloqueEspecifica=Registry.get("panelAsociarBloque");
									if(bo!=null){
									
									panelBloqueEspecifica.actualizarCombos(bo.getIntroduce(),bo.getEnsena(),bo.getAplica());
									}else{
										panelBloqueEspecifica.actualizarCombos(0,0,0);
									}
									
								}else{

									if(event.getType().equals(DTEvent.ACTUALIZARCHK_MATERIA)){

										AsociacionEspecificaBO bo = (AsociacionEspecificaBO)event.getData();
										//TODO								
										
										PanelAsociarCompetenciasEspecificas panelBloqueEspecifica=Registry.get("panelAsociar");
										if(bo!=null){
										
										panelBloqueEspecifica.actualizarCombos(bo.getIntroduce(),bo.getEnsena(),bo.getAplica());
										}else{
											panelBloqueEspecifica.actualizarCombos(0,0,0);
										}

							}else{

								if(event.getType().equals(DTEvent.SELECCIONAR_COMPETENCIA_PROFESIONAL)){

									CompetenciaTerminalModel model =(CompetenciaTerminalModel)event.getData();
									System.out.println("llamando evento selecionar comp profesional" + model.getId());
									Registry.register( "idCompetenciaProfesional", model.getId());

									
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

											if(event.getType().equals(DTEvent.ABRIR_MATERIA_FILTRO)){

												PanelFiltro panelFiltro = (PanelFiltro) Registry.get("panelFiltro");
												VentanaMateriaFiltro materia=Registry.get("materiaFiltro");
												materia.show();





											}else{

												if(event.getType().equals(DTEvent.CERRAR_VENTANA_MATERIAFILTRO)){
													MateriaModel pM=Registry.get("materiaSeleccionadoFiltro");

													if(pM!=null){
														ListStore <MateriaModel> lista=new ListStore();
														lista.add(pM);
												
														PanelAsociarCompetenciasEspecificas panelBloqueEspecifica=Registry.get("panelAsociar");
														panelBloqueEspecifica.actualizarMaterias(lista);
														if(Registry.get("especificaMateria")!=null){
														((PanelAsociarCompetenciasEspecificas) Registry.get("panelAsociar")).consultarChck();

															
														}
														
													}

													VentanaMateriaFiltro materia = Registry.get("materiaFiltro");
													materia.close();
													
												}else{

													if(event.getType().equals(DTEvent.ABRIR_BLOQUE_FILTRO)){

														PanelFiltro panelFiltro = (PanelFiltro) Registry.get("panelFiltro");
														VentanaBloqueFiltro bloque=Registry.get("bloquesFiltro");
														bloque.show();





													}else{

														if(event.getType().equals(DTEvent.CERRAR_VENTANA_BLOQUEFILTRO)){
															BloqueModel pM=Registry.get("bloqueSeleccionadoFiltro");

															if(pM!=null){
																ListStore <BloqueModel> lista=new ListStore();
																lista.add(pM);
																PanelAsociarCompetenciasEspecificasBloque panelBloque=Registry.get("panelAsociarBloque");
																panelBloque.actualizarBloques(lista);
																PanelAsociarCompetenciasEspecificas panelBloqueEspecifica=Registry.get("panelAsociar");
																panelBloqueEspecifica.actualizarBloques(lista);
																panelBloqueEspecifica.cargarMateriasAsociadas();
																											
																panelBloqueEspecifica.actualizarMaterias(null);
																
																if(Registry.get("especificaBloque")!=null){
																	((PanelAsociarCompetenciasEspecificasBloque) Registry.get("panelAsociarBloque")).consultarChck();

																		
																	}
																
																
																	((PanelAsociarCompetenciasEspecificas) Registry.get("panelAsociar")).actualizarCombos(0, 0, 0);
																	
																		

																

															}

															VentanaBloqueFiltro bloque = Registry.get("bloquesFiltro");
															bloque.close();

												}else{

													if(event.getType().equals(DTEvent.FILTRAR_BLOQUE)){

														if (Registry.get("BloqueDisponible")!=null){
															PanelFiltro panelFiltro = Registry.get("panelFiltro");
															ListStore<BloqueModel> listaNoFiltrados = panelFiltro.getGridBloquesDisponibles().getStore();




															listaNoFiltrados.remove((BloqueModel)Registry.get("BloqueDisponible"));





															ListStore<BloqueModel> listaFiltrados = panelFiltro.getGridBloquesSeleccionados().getStore();



															listaFiltrados.add((BloqueModel)Registry.get("BloqueDisponible"));


															Registry.register("BloqueDisponible", null);


															panelFiltro.actualizarListaBloquesDisponibles(listaNoFiltrados);
															panelFiltro.actualizarListaBloquesFiltrados(listaFiltrados);

														}else												
															Info.display("Filtro Bloques", "<ul><li>" + "Debe escoger una bloque para agregar al filtro" + "</li></ul>");


													}else{

														if(event.getType().equals(DTEvent.DESFILTRAR_BLOQUE)){

															if (Registry.get("BloqueFiltrado")!=null){
																PanelFiltro panelFiltro = Registry.get("panelFiltro");
																ListStore<BloqueModel> listaNoFiltrados = panelFiltro.getGridBloquesDisponibles().getStore();




																listaNoFiltrados.add((BloqueModel)Registry.get("BloqueFiltrado"));





																ListStore<BloqueModel> listaFiltrados = panelFiltro.getGridBloquesSeleccionados().getStore();



																listaFiltrados.remove((BloqueModel)Registry.get("BloqueFiltrado"));


																Registry.register("BloqueFiltrado", null);


																panelFiltro.actualizarListaBloquesDisponibles(listaNoFiltrados);
																panelFiltro.actualizarListaBloquesFiltrados(listaFiltrados);

															}else												
																Info.display("Filtro Bloques", "<ul><li>" + "Debe escoger una bloque para eliminar del filtro" + "</li></ul>");




														}else{

															if(event.getType().equals(DTEvent.FILTRAR_PROFESIONAL)){

																if (Registry.get("profesionalDisponible")!=null){
																	PanelFiltro panelFiltro = Registry.get("panelFiltro");
																	ListStore<CompetenciaTerminalModel> listaNoFiltrados = panelFiltro.getGridProfesionalesDisponibles().getStore();




																	listaNoFiltrados.remove((CompetenciaTerminalModel)Registry.get("profesionalDisponible"));





																	ListStore<CompetenciaTerminalModel> listaFiltrados = panelFiltro.getGridProfesionalesSeleccionadas().getStore();



																	listaFiltrados.add((CompetenciaTerminalModel)Registry.get("profesionalDisponible"));


																	Registry.register("profesionalDisponible", null);


																	panelFiltro.actualizarListaProfesionalDisponibles(listaNoFiltrados);
																	panelFiltro.actualizarListaProfesionalFiltrados(listaFiltrados);

																}else												
																	Info.display("Filtro Bloques", "<ul><li>" + "Debe escoger una competencia profesional para agregar al filtro" + "</li></ul>");





															}else{

																if(event.getType().equals(DTEvent.DESFILTRAR_PROFESIONAL)){

																	if (Registry.get("profesionalFiltrado")!=null){
																		PanelFiltro panelFiltro = Registry.get("panelFiltro");
																		ListStore<CompetenciaTerminalModel> listaNoFiltrados = panelFiltro.getGridProfesionalesDisponibles().getStore();




																		listaNoFiltrados.add((CompetenciaTerminalModel)Registry.get("profesionalFiltrado"));





																		ListStore<CompetenciaTerminalModel> listaFiltrados = panelFiltro.getGridProfesionalesSeleccionadas().getStore();



																		listaFiltrados.remove((CompetenciaTerminalModel)Registry.get("profesionalFiltrado"));


																		Registry.register("profesionalFiltrado", null);

																		panelFiltro.actualizarListaProfesionalDisponibles(listaNoFiltrados);
																		panelFiltro.actualizarListaProfesionalFiltrados(listaFiltrados);

																	}else												
																		Info.display("Filtro Bloques", "<ul><li>" + "Debe escoger una competencia Profesional para eliminar del filtro" + "</li></ul>");




																}else{

																	if(event.getType().equals(DTEvent.FILTRAR_TRANSVERSAL)){

																		if (Registry.get("transversalDisponible")!=null){
																			PanelFiltro panelFiltro = Registry.get("panelFiltro");
																			ListStore<CompetenciaTerminalModel> listaNoFiltrados = panelFiltro.getGridTransversalesDisponibles().getStore();




																			listaNoFiltrados.remove((CompetenciaTerminalModel)Registry.get("transversalDisponible"));





																			ListStore<CompetenciaTerminalModel> listaFiltrados = panelFiltro.getGridTransversalesSeleccionadas().getStore();



																			listaFiltrados.add((CompetenciaTerminalModel)Registry.get("transversalDisponible"));


																			Registry.register("transversalDisponible", null);


																			panelFiltro.actualizarListaTransversalDisponibles(listaNoFiltrados);
																			panelFiltro.actualizarListaTransversalFiltrados(listaFiltrados);

																		}else												
																			Info.display("Filtro Bloques", "<ul><li>" + "Debe escoger una competencia transversal para agregar al filtro" + "</li></ul>");





																	}else{

																		if(event.getType().equals(DTEvent.DESFILTRAR_TRANSVERSAL)){

																			if (Registry.get("transversalFiltrado")!=null){
																				PanelFiltro panelFiltro = Registry.get("panelFiltro");
																				ListStore<CompetenciaTerminalModel> listaNoFiltrados = panelFiltro.getGridTransversalesDisponibles().getStore();




																				listaNoFiltrados.add((CompetenciaTerminalModel)Registry.get("transversalFiltrado"));





																				ListStore<CompetenciaTerminalModel> listaFiltrados = panelFiltro.getGridTransversalesSeleccionadas().getStore();



																				listaFiltrados.remove((CompetenciaTerminalModel)Registry.get("transversalFiltrado"));


																				Registry.register("transversalFiltrado", null);


																				panelFiltro.actualizarListaTransversalDisponibles(listaNoFiltrados);
																				panelFiltro.actualizarListaTransversalFiltrados(listaFiltrados);

																			}else												
																				Info.display("Filtro Bloques", "<ul><li>" + "Debe escoger una competencia transversal para eliminar del filtro" + "</li></ul>");




																		}else{
																		}

																		if(event.getType().equals(DTEvent.REFRESCAR_FILTRO)){

																			PanelFiltro panelFiltro = Registry.get("panelFiltro");


																			ArrayList<BloqueBO> bloques = (ArrayList<BloqueBO>)event.getData();

																			ListStore<BloqueModel> lista = new ListStore<BloqueModel>();

																			if(bloques!=null){

																				for(BloqueBO b:bloques){


																					lista.add(BloqueModel.toModelFromBO(b));

																				}


																				panelFiltro.actualizarListaBloques(lista);
																			}else{


																				panelFiltro.actualizarListaBloques(null);
																			}



																		}else{

																			if(event.getType().equals(DTEvent.DESASOCIAR_MATERIA)){

																				PanelBloques panelBloques = Registry.get("panelBloques");
																				panelBloques.desasociarMateria();



																			}else{

																				if(event.getType().equals(DTEvent.ACTUALIZAR_BLOQUES_FILTRO)){
																					ListStore<CompetenciaEspecificaModel> lista=Registry.get("listaEspecificaFiltro");

																					PanelAsociarCompetenciasEspecificas panelAsociar = (PanelAsociarCompetenciasEspecificas) Registry.get("panelAsociar");
																					PanelAsociarCompetenciasEspecificasBloque panelAsociarBloque = (PanelAsociarCompetenciasEspecificasBloque) Registry.get("panelAsociarBloque");
																					panelAsociar.refrescarListaEspecifica(lista);
																					panelAsociarBloque.refrescarListaEspecifica(lista);

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

																					Registry.register( "idCompetenciaTransversal", null);
																					Registry.register( "idCompetenciaProfesional",null);
																					Registry.register("BloqueFiltrado", null);
																					Registry.register("BloqueDisponible", null);
																					Registry.register("TransversalDisponible",null);
																					Registry.register("TransversalFiltrado",null);
																					Registry.register("ProfesionalDisponible",null);
																					Registry.register("ProfesionalFiltrado",null);

																					PanelFiltro panelFiltro = (PanelFiltro) Registry.get("panelFiltro");

																					panelFiltro.actualizarListaBloquesFiltrados(null);
																					panelFiltro.actualizarListaProfesionalFiltrados(null);
																					panelFiltro.actualizarListaTransversalFiltrados(null);
																				}

																				else{

																					if(event.getType().equals(DTEvent.CAMBIAR_PANELES)){

																						TabPanel tabPanel = (TabPanel) Registry.get("tabPanel");
																						TabItem tab = tabPanel.getItemByItemId("Asociar Competencias Especificas");
																						PanelFiltro panelFiltro = (PanelFiltro) Registry.get("panelFiltro");
																						PanelAsociarCompetenciasEspecificas panelAsociar = (PanelAsociarCompetenciasEspecificas) Registry.get("panelAsociar");
																						PanelAsociarCompetenciasEspecificasBloque panelAsociarBloque = (PanelAsociarCompetenciasEspecificasBloque) Registry.get("panelAsociarBloque");
																						VentanaBloqueFiltro VentanaBloqueFiltro=(VentanaBloqueFiltro)Registry.get("bloquesFiltro");

																						String opcion = (String) event.getData();

																						if(opcion.equals("Filtro-Bloques")){

																							if(panelFiltro.getGridBloquesSeleccionados().getStore().getCount()>0 && (panelFiltro.getGridProfesionalesSeleccionadas().getStore().getCount()>0 ||panelFiltro.getGridTransversalesSeleccionadas().getStore().getCount()>0)){
																								panelFiltro.setVisible(false);
																								panelAsociarBloque.setVisible(true);

																								//TODO
																								ListStore<BloqueModel> listaFiltrados = panelFiltro.getGridBloquesSeleccionados().getStore();

																								//																				panelAsociarBloque.getCmbxBloques().setStore(listaFiltrados);
																								//																				panelAsociarBloque.getCmbxBloques().refresh();

																								//																								panelAsociarBloque.actualizarBloques(listaFiltrados);
																								VentanaBloqueFiltro.actualizarPanel(listaFiltrados);



																								ListStore<CompetenciaTerminalModel> listaFiltradosTrans = panelFiltro.getGridTransversalesSeleccionadas().getStore();
																								ListStore<CompetenciaTerminalModel> listaFiltradosProfe = panelFiltro.getGridProfesionalesSeleccionadas().getStore();


																								int var=0;
																								//TODO
																								Registry.register("var",var);
																								Registry.register("listaEspecificaFiltro", null);
																								for(int i =0;i<listaFiltradosTrans.getCount();i++){
																									panelFiltro.cargarEspecifica(listaFiltradosTrans.getAt(i).getId(),var);



																								}

																								for(int i =0;i<listaFiltradosProfe.getCount();i++){
																									panelFiltro.cargarEspecifica(listaFiltradosProfe.getAt(i).getId(),var);

																									if(i==listaFiltradosProfe.getCount()-1){
																										var=1;
																										System.out.println("FINAL DE ESTO");
																										Registry.register("var", var);
																									}



																								}



																								tabPanel.repaint();
																							}else{
																								Info.display("Filtro","Por favor escoja bloques y algunas competencias especificas para filtrar");
																							}
																						}else{

																							if(opcion.equals("Bloques-Filtro")){

																								panelFiltro.setVisible(true);
																								panelAsociarBloque.setVisible(false);


																								//TODO
																								panelFiltro.actualizarListaBloquesFiltrados(null);
																								panelFiltro.actualizarListaProfesionalFiltrados(null);
																								panelFiltro.actualizarListaTransversalFiltrados(null);


																								tabPanel.repaint();
																							}else{

																								if(opcion.equals("Bloques-Materias")){

																									panelAsociarBloque.setVisible(false);
																									panelAsociar.setVisible(true);
																									tabPanel.repaint();
																								}else{

																									panelAsociarBloque.setVisible(true);
																									panelAsociar.setVisible(false);
																									tabPanel.repaint();
																								}
																							}
																						}


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
																											}else{

																												if(event.getType().equals(DTEvent.REFRESCAR_MATERIAS_FILTRO)){

																													ArrayList<MateriaBO> lineas = (ArrayList<MateriaBO>)event.getData();

																													ListStore<MateriaModel> listaAsociados = new ListStore<MateriaModel>();
																													


																													if(lineas!=null){
																														for(MateriaBO b:lineas){
																														
																																listaAsociados.add(MateriaModel.toModelFromBO(b));
																														


																														}
																														VentanaMateriaFiltro filtroMateria = Registry.get("materiaFiltro");
																														filtroMateria.actualizarPanel(listaAsociados);
																														

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
																													}else{

																													}
																												}
																											}
																										}
																									}
																								}
																							}

																						}
																					}
																				}

																			}
																		}
																	}
																}
																}
															}
														}
													}
												}
											}	
										}
									}
								}
							}
						}
					}
				}
			}
		}
			}
		}
	}	
}
}

