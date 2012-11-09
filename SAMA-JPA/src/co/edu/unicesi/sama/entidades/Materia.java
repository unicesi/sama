package co.edu.unicesi.sama.entidades;

import java.io.Serializable;
import javax.persistence.*;

import co.edu.unicesi.sama.bo.MateriaBO;

import java.util.Set;


/**
 * The persistent class for the materias database table.
 * 
 */
@Entity
@Table(name="materias")

@NamedQueries({
@NamedQuery(name="listarMateriasOrdenadosPorNombre", query="SELECT m FROM Materia m ORDER BY m.nombre ASC"),
@NamedQuery(name="buscarMateriaPorId", query="SELECT m FROM Materia m Where m.idMateria LIKE :id"),
})

public class Materia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idMateria;

	private int creditos;

	private String descripcion;

	private String nombre;

	private String objetivoMateria;

	private String semestre;

	//bi-directional many-to-many association to Bloque
	@ManyToMany(mappedBy="materias")
	private Set<Bloque> bloques;

	//bi-directional many-to-one association to Facultade
    @ManyToOne
	@JoinColumn(name="FK_idFACULTAD")
	private Facultade facultade;

    public Materia() {
    }

	public int getIdMateria() {
		return this.idMateria;
	}

	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}

	public int getCreditos() {
		return this.creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
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

	public String getObjetivoMateria() {
		return this.objetivoMateria;
	}

	public void setObjetivoMateria(String objetivoMateria) {
		this.objetivoMateria = objetivoMateria;
	}

	public String getSemestre() {
		return this.semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public Set<Bloque> getBloques() {
		return this.bloques;
	}

	public void setBloques(Set<Bloque> bloques) {
		this.bloques = bloques;
	}
	
	public Facultade getFacultade() {
		return this.facultade;
	}

	public void setFacultade(Facultade facultade) {
		this.facultade = facultade;
	}
public MateriaBO toBO() {
		
		MateriaBO materia = new MateriaBO();
		materia.setNombre(getNombre());
		materia.setIdMateria(getIdMateria());
		materia.setDescripcion(getDescripcion());
		return materia;
	}
}