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
@NamedQuery(name="buscarProgramaporId", query="SELECT c FROM Programa c WHERE c.codigo LIKE :programa"),
})
public class Programa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String codigo;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to Bloque
	@OneToMany(mappedBy="programa")
	private Set<Bloque> bloques;

	//bi-directional many-to-many association to Competenciasespecifica
	@ManyToMany(mappedBy="programas")
	private Set<Competenciasespecifica> competenciasespecificas;

	//bi-directional many-to-many association to Competenciasgenerale
	@ManyToMany(mappedBy="programas")
	private Set<Competenciasgenerale> competenciasgenerales;

	//bi-directional many-to-many association to Competenciasterminale
	@ManyToMany(mappedBy="programas")
	private Set<Competenciasterminale> competenciasterminales;

    public Programa() {
    }

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	
	public Set<Competenciasespecifica> getCompetenciasespecificas() {
		return this.competenciasespecificas;
	}

	public void setCompetenciasespecificas(Set<Competenciasespecifica> competenciasespecificas) {
		this.competenciasespecificas = competenciasespecificas;
	}
	
	public Set<Competenciasgenerale> getCompetenciasgenerales() {
		return this.competenciasgenerales;
	}

	public void setCompetenciasgenerales(Set<Competenciasgenerale> competenciasgenerales) {
		this.competenciasgenerales = competenciasgenerales;
	}
	
	public Set<Competenciasterminale> getCompetenciasterminales() {
		return this.competenciasterminales;
	}

	public void setCompetenciasterminales(Set<Competenciasterminale> competenciasterminales) {
		this.competenciasterminales = competenciasterminales;
	}
	
public ProgramaBO toBO() {
		
		ProgramaBO programa = new ProgramaBO();
		programa.setNombre(getNombre());
		programa.setIdPrograma(getCodigo());
		programa.setDescripcion(getDescripcion());
		return programa;
		
		
	}
	
}