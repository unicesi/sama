package co.edu.unicesi.sama.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


/**
 * Esta clase se encarga de crear un Business Object de una competencia especifica.
 */
public class CompetenciaEspecificaBO implements Serializable {
	
	/**
	 * idLineaDeCompetencia - int - id de la linea de competencias.
	 */
	private int idLineaDeCompetencia;

	/**
	 * descripcion - String - descripcion de la competencia especifica.
	 */
	private String descripcion;

	/**
	 * nombre - String - nombre de la competencia especifica.
	 */
	private String nombre;
	
	/**
	 * asociado - boolean - determina si la competencia esta asociada o no.
	 */
	private boolean asociado;

	public int getIdLineaDeCompetencia() {
		return idLineaDeCompetencia;
	}

	public void setIdLineaDeCompetencia(int idLineaDeCompetencia) {
		this.idLineaDeCompetencia = idLineaDeCompetencia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isAsociado() {
		return asociado;
	}

	public void setAsociado(boolean asociado) {
		this.asociado = asociado;
	}

	public CompetenciaTerminalBO getCompetencia() {
		return competencia;
	}

	public void setCompetencia(CompetenciaTerminalBO competencia) {
		this.competencia = competencia;
	}

	public ArrayList<ProgramaBO> getProgramas() {
		return programas;
	}

	public void setProgramas(ArrayList<ProgramaBO> listaPrograma) {
		this.programas = listaPrograma;
	}

	//bi-directional many-to-one association to Competencia
    @ManyToOne
	@JoinColumn(name="idCompetencia")
	private CompetenciaTerminalBO competencia;

	//bi-directional many-to-many association to Programa
    @ManyToMany
	@JoinTable(
		name="lineaprograma"
		, joinColumns={
			@JoinColumn(name="idLineaCompetencia")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idPrograma")
			}
		)
	private ArrayList<ProgramaBO> programas;

}
