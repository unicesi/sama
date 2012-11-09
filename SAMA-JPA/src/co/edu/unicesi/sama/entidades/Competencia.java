package co.edu.unicesi.sama.entidades;

import java.awt.List;
import java.io.Serializable;
import javax.persistence.*;

import co.edu.unicesi.sama.bo.CompetenciaBO;
import co.edu.unicesi.sama.bo.ProgramaBO;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Set;


/**
 * The persistent class for the competencias database table.
 * 
 */
@Entity
@Table(name="competencias")
@NamedQueries({
@NamedQuery(name="buscarCompetenciaPorTipo", query="SELECT m FROM Competencia m Where m.tipo LIKE :tipo"),

})
public class Competencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id_Competencia;

	private String descripcion;

	private String nivel;

	private String nombre;

	private int tipo;

	//bi-directional many-to-one association to Lineadecompetencia
	@OneToMany(mappedBy="competencia")
	private Set<Lineadecompetencia> lineadecompetencias;

	//bi-directional many-to-many association to Programa
	@ManyToMany(mappedBy="competencias")
	private Set<Programa> programas;

    public Competencia() {
    }

	public int getId_Competencia() {
		return this.id_Competencia;
	}

	public void setId_Competencia(int id_Competencia) {
		this.id_Competencia = id_Competencia;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNivel() {
		return this.nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
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

	public Set<Lineadecompetencia> getLineadecompetencias() {
		return this.lineadecompetencias;
	}

	public void setLineadecompetencias(Set<Lineadecompetencia> lineadecompetencias) {
		this.lineadecompetencias = lineadecompetencias;
	}
	
	public Set<Programa> getProgramas() {
		return this.programas;
	}

	public void setProgramas(Set<Programa> programas) {
		this.programas = programas;
	}

	public CompetenciaBO toBO() {
		// TODO Auto-generated method stub
		
		CompetenciaBO BO= new CompetenciaBO();
		BO.setId_Competencia(getId_Competencia());
		BO.setDescripcion(getDescripcion());
		BO.setNivel(getNivel());
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