package co.edu.unicesi.sama.entidades;

import java.io.Serializable;
import javax.persistence.*;

import co.edu.unicesi.sama.bo.*;

import java.util.ArrayList;
import java.util.Set;


/**
 * The persistent class for the competenciasterminales database table.
 * 
 */
@Entity
@Table(name="competenciasterminales")
@NamedQueries({
@NamedQuery(name="buscarCompetenciaPorTipo", query="SELECT m FROM Competenciasterminale m Where m.tipo LIKE :tipo"),

})
public class Competenciasterminale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descripcion;

	private String nombre;

	private int tipo;

	//bi-directional many-to-one association to Competenciasespecifica
	@OneToMany(mappedBy="competenciasterminale")
	private Set<Competenciasespecifica> competenciasespecificas;

	//bi-directional many-to-one association to Competenciasgenerale
    @ManyToOne
	@JoinColumn(name="idCompetenciaGeneral")
	private Competenciasgenerale competenciasgenerale;

	//bi-directional many-to-many association to Programa
    @ManyToMany
	@JoinTable(
		name="competenciasterminales_programas"
		, joinColumns={
			@JoinColumn(name="FK_idCompetenciaTerminal")
			}
		, inverseJoinColumns={
			@JoinColumn(name="FK_CodigoPrograma")
			}
		)
	private Set<Programa> programas;

    public Competenciasterminale() {
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

	public int getTipo() {
		return this.tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public Set<Competenciasespecifica> getCompetenciasespecificas() {
		return this.competenciasespecificas;
	}

	public void setCompetenciasespecificas(Set<Competenciasespecifica> competenciasespecificas) {
		this.competenciasespecificas = competenciasespecificas;
	}
	
	public Competenciasgenerale getCompetenciasgenerale() {
		return this.competenciasgenerale;
	}

	public void setCompetenciasgenerale(Competenciasgenerale competenciasgenerale) {
		this.competenciasgenerale = competenciasgenerale;
	}
	
	public Set<Programa> getProgramas() {
		return this.programas;
	}

	public void setProgramas(Set<Programa> programas) {
		this.programas = programas;
	}
	
	public CompetenciaTerminalBO toBO() {
		// TODO Auto-generated method stub
		
		CompetenciaTerminalBO BO= new CompetenciaTerminalBO();
		BO.setId_Competencia(getId());
		BO.setDescripcion(getDescripcion());
		BO.setNombre(getNombre());
		ArrayList<ProgramaBO> progBO=new ArrayList<ProgramaBO>();
		System.out.println(programas.size());
		for (Programa p: programas){
			
			
			
				progBO.add((ProgramaBO)p.toBO());
			
			
			
			
			
		}
		BO.setProgramas(progBO);
		
		
		
		
		return BO;
	}
	
}