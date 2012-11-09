package co.edu.unicesi.sama.entidades;

import java.io.Serializable;
import javax.persistence.*;

import co.edu.unicesi.sama.bo.ProgramaBO;

import java.util.Set;


/**
 * The persistent class for the programas database table.
 * 
 */
@Entity
@Table(name="programas")
@NamedQueries({
@NamedQuery(name="listarProgramasOrdenadosPorNombre", query="SELECT p FROM Programa p ORDER BY p.nombre ASC"),
@NamedQuery(name="buscarProgramaporId", query="SELECT c FROM Programa c WHERE c.idPrograma LIKE :programa"),
})

public class Programa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPrograma;

    @Lob()
	private byte[] competenciasAsociadas;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to Bloque
	@OneToMany(mappedBy="programa")
	private Set<Bloque> bloques;

	//bi-directional many-to-many association to Lineadecompetencia
	@ManyToMany(mappedBy="programas")
	private Set<Lineadecompetencia> lineadecompetencias;

	//bi-directional many-to-many association to Competencia
    @ManyToMany
	@JoinTable(
		name="competenciaprograma"
		, joinColumns={
			@JoinColumn(name="FK_programa")
			}
		, inverseJoinColumns={
			@JoinColumn(name="FK_competencia")
			}
		)
	private Set<Competencia> competencias;

	//bi-directional many-to-one association to Facultade
    @ManyToOne
	@JoinColumn(name="FK_idFACULTAD")
	private Facultade facultade;
    
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
   	private Set<Programa> programas;

    public Programa() {
    }

	public int getIdPrograma() {
		return this.idPrograma;
	}

	public void setIdPrograma(int idPrograma) {
		this.idPrograma = idPrograma;
	}

	public byte[] getCompetenciasAsociadas() {
		return this.competenciasAsociadas;
	}

	public void setCompetenciasAsociadas(byte[] competenciasAsociadas) {
		this.competenciasAsociadas = competenciasAsociadas;
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

	public Set<Bloque> getBloques() {
		return this.bloques;
	}

	public void setBloques(Set<Bloque> bloques) {
		this.bloques = bloques;
	}
	
	public Set<Lineadecompetencia> getLineadecompetencias() {
		return this.lineadecompetencias;
	}

	public void setLineadecompetencias(Set<Lineadecompetencia> lineadecompetencias) {
		this.lineadecompetencias = lineadecompetencias;
	}
	
	public Set<Competencia> getCompetencias() {
		return this.competencias;
	}

	public void setCompetencias(Set<Competencia> competencias) {
		this.competencias = competencias;
	}
	
	public Facultade getFacultade() {
		return this.facultade;
	}

	public void setFacultade(Facultade facultade) {
		this.facultade = facultade;
	}
public ProgramaBO toBO() {
		
		ProgramaBO programa = new ProgramaBO();
		programa.setNombre(getNombre());
		programa.setIdPrograma(getIdPrograma());
		programa.setDescripcion(getDescripcion());
		return programa;
		
		
	}
}