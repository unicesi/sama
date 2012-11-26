package co.edu.unicesi.sama.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/** 
 * Clase encargada de la persistencia de la tabla competenciasgenerales en la base de datos.
 */
@Entity
@Table(name="competenciasgenerales")
public class Competenciasgenerale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descripción;

	private String nombre;

	//bi-directional many-to-many association to Programa
    @ManyToMany
	@JoinTable(
		name="competenciasgenerales_programas"
		, joinColumns={
			@JoinColumn(name="FK_IdCompetenciaGeneral")
			}
		, inverseJoinColumns={
			@JoinColumn(name="FK_CodigoPrograma")
			}
		)
	private Set<Programa> programas;

	//bi-directional many-to-one association to Competenciasterminale
	@OneToMany(mappedBy="competenciasgenerale")
	private Set<Competenciasterminale> competenciasterminales;

    public Competenciasgenerale() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripción() {
		return this.descripción;
	}

	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Programa> getProgramas() {
		return this.programas;
	}

	public void setProgramas(Set<Programa> programas) {
		this.programas = programas;
	}
	
	public Set<Competenciasterminale> getCompetenciasterminales() {
		return this.competenciasterminales;
	}

	public void setCompetenciasterminales(Set<Competenciasterminale> competenciasterminales) {
		this.competenciasterminales = competenciasterminales;
	}
	
}