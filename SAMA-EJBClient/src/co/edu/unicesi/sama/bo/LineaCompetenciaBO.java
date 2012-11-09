package co.edu.unicesi.sama.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;



public class LineaCompetenciaBO implements Serializable {
	private int idLineaDeCompetencia;

	private String descripcion;

	private String nombre;
	
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

	public CompetenciaBO getCompetencia() {
		return competencia;
	}

	public void setCompetencia(CompetenciaBO competencia) {
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
	private CompetenciaBO competencia;

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
