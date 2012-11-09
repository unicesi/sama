package co.edu.unicesi.sama.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

public class CompetenciaBO implements Serializable{

	
	@Id
	private int id_Competencia;

	private String descripcion;

	private String nivel;

	private String nombre;

	private int tipo;
	
	private boolean asociada;

	public boolean isAsociada() {
		return asociada;
	}

	public void setAsociada(boolean asociada) {
		this.asociada = asociada;
	}

	//bi-directional many-to-one association to Lineadecompetencia
	@OneToMany(mappedBy="competencia")
	private Set<LineaCompetenciaBO> lineadecompetencias;

	//bi-directional many-to-many association to Programa
	@ManyToMany(mappedBy="competencias")
	private ArrayList<ProgramaBO> programas;

	public int getId_Competencia() {
		return id_Competencia;
	}

	public void setId_Competencia(int id_Competencia) {
		this.id_Competencia = id_Competencia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public Set<LineaCompetenciaBO> getLineadecompetencias() {
		return lineadecompetencias;
	}

	public void setLineadecompetencias(Set<LineaCompetenciaBO> lineadecompetencias) {
		this.lineadecompetencias = lineadecompetencias;
	}

	public ArrayList<ProgramaBO> getProgramas() {
		return programas;
	}

	public void setProgramas(ArrayList<ProgramaBO> programas) {
		this.programas = programas;
	}
}
