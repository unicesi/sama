package co.edu.unicesi.sama.entidades;

import java.io.Serializable;
import javax.persistence.*;

import co.edu.unicesi.sama.bo.MateriaBO;

import java.util.Set;


/**
 * Clase encargada de la persistencia de la tabla materias en la base de datos.
 */
@Entity
@Table(name="materias")
@NamedQueries({
@NamedQuery(name="listarMateriasOrdenadosPorNombre", query="SELECT m FROM Materia m ORDER BY m.nombre ASC"),
@NamedQuery(name="buscarMateriaPorId", query="SELECT m FROM Materia m Where m.codigo LIKE :id"),
})
public class Materia implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * codigo - String - codigo de la materia.
	 */
	@Id
	private String codigo;

	/**
	 * creditos - int - creditos de la materia.
	 */
	private int creditos;

	/**
	 * descripcion - String - descripcion de la materia.
	 */
	private String descripcion;

	/**
	 * nombre - String - nombre de la materia.
	 */
	private String nombre;

	/**
	 * semestre - String - semestre en el que se deberia ver la materia.
	 */
	private String semestre;

	//bi-directional many-to-many association to Bloque
	@ManyToMany(mappedBy="materias")
	private Set<Bloque> bloques;

	//bi-directional many-to-one association to MateriasCompetenciasespecifica
	@OneToMany(mappedBy="materia")
	private Set<MateriasCompetenciasespecifica> materiasCompetenciasespecificas;

    public Materia() {
    }

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	
	public Set<MateriasCompetenciasespecifica> getMateriasCompetenciasespecificas() {
		return this.materiasCompetenciasespecificas;
	}

	public void setMateriasCompetenciasespecificas(Set<MateriasCompetenciasespecifica> materiasCompetenciasespecificas) {
		this.materiasCompetenciasespecificas = materiasCompetenciasespecificas;
	}
	
public MateriaBO toBO() {
		
		MateriaBO materia = new MateriaBO();
		materia.setNombre(getNombre());
		materia.setIdMateria(getCodigo());
		materia.setDescripcion(getDescripcion());
		return materia;
	}
	
}