package co.edu.unicesi.sama.entidades;

import java.io.Serializable;
import javax.persistence.*;

import co.edu.unicesi.sama.bo.LineaCompetenciaBO;
import co.edu.unicesi.sama.bo.MateriaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;

import java.util.ArrayList;
import java.util.Set;


/**
 * The persistent class for the lineadecompetencias database table.
 * 
 */
@Entity
@Table(name="lineadecompetencias")
@NamedQueries({
	@NamedQuery(name="buscarLineaDeCompetenciaPorCompetencia", query="SELECT c FROM Lineadecompetencia c WHERE c.competencia.id_Competencia LIKE :id"),
	@NamedQuery(name="buscarLineaDeCompetenciaPorIdLinea", query="SELECT c FROM Lineadecompetencia c WHERE c.idLineaDeCompetencia LIKE :id"),
})
public class Lineadecompetencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idLineaDeCompetencia;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to Competencia
    @ManyToOne
	@JoinColumn(name="idCompetencia")
	private Competencia competencia;

	//bi-directional many-to-many association to Programa
    @ManyToMany
	@JoinTable(
		name="lineaprograma"
		, joinColumns={
			@JoinColumn(name="FK_LineaPrograma")
			}
		, inverseJoinColumns={
			@JoinColumn(name="FK_IdPrograma")
			}
		)
	private Set<Programa> programas;

    public Lineadecompetencia() {
    }

	public int getIdLineaDeCompetencia() {
		return this.idLineaDeCompetencia;
	}

	public void setIdLineaDeCompetencia(int idLineaDeCompetencia) {
		this.idLineaDeCompetencia = idLineaDeCompetencia;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Competencia getCompetencia() {
		return this.competencia;
	}

	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}
	
	public Set<Programa> getProgramas() {
		return this.programas;
	}

	public void setProgramas(Set<Programa> programas) {
		this.programas = programas;
	}

	public LineaCompetenciaBO toBO() {
		// TODO Auto-generated method stub
		LineaCompetenciaBO Bo=new LineaCompetenciaBO();
		Bo.setIdLineaDeCompetencia(getIdLineaDeCompetencia());
		Bo.setCompetencia(competencia.toBO());
		Bo.setDescripcion(getDescripcion());
		Bo.setNombre(getNombre());
		
	
		
		return Bo;
	}
	
}