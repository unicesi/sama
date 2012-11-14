package co.edu.unicesi.sama.entidades;

import java.io.Serializable;
import javax.persistence.*;

import co.edu.unicesi.sama.bo.CompetenciaEspecificaBO;

import java.util.Set;


/**
 * The persistent class for the competenciasespecificas database table.
 * 
 */
@Entity
@Table(name="competenciasespecificas")
@NamedQueries({
	@NamedQuery(name="buscarLineaDeCompetenciaPorCompetencia", query="SELECT c FROM Competenciasespecifica c WHERE c.competenciasterminale.id LIKE :id"),
	@NamedQuery(name="buscarLineaDeCompetenciaPorIdLinea", query="SELECT c FROM Competenciasespecifica c WHERE c.id LIKE :id"),
})
public class Competenciasespecifica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to Competenciasterminale
    @ManyToOne
	@JoinColumn(name="idCompetenciaTerminal")
	private Competenciasterminale competenciasterminale;

	//bi-directional many-to-many association to Programa
    @ManyToMany
	@JoinTable(
		name="competenciasespecificas_programas"
		, joinColumns={
			@JoinColumn(name="FK_IdCompetenciaEspecifica")
			}
		, inverseJoinColumns={
			@JoinColumn(name="FK_CodigoPrograma")
			}
		)
	private Set<Programa> programas;

    public Competenciasespecifica() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Competenciasterminale getCompetenciasterminale() {
		return this.competenciasterminale;
	}

	public void setCompetenciasterminale(Competenciasterminale competenciasterminale) {
		this.competenciasterminale = competenciasterminale;
	}
	
	public Set<Programa> getProgramas() {
		return this.programas;
	}

	public void setProgramas(Set<Programa> programas) {
		this.programas = programas;
	}
	public CompetenciaEspecificaBO toBO() {
		// TODO Auto-generated method stub
		CompetenciaEspecificaBO Bo=new CompetenciaEspecificaBO();
		Bo.setIdLineaDeCompetencia(getId());
		Bo.setCompetencia(competenciasterminale.toBO());
		Bo.setDescripcion(getDescripcion());
		Bo.setNombre(getNombre());
		
	
		
		return Bo;
	}
	
}