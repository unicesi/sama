package co.edu.unicesi.sama.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the facultades database table.
 * 
 */
@Entity
@Table(name="facultades")
public class Facultade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idFACULTAD;

	private String nombre;

	//bi-directional many-to-one association to Materia
	@OneToMany(mappedBy="facultade")
	private Set<Materia> materias;

	//bi-directional many-to-one association to Programa
	@OneToMany(mappedBy="facultade")
	private Set<Programa> programas;

    public Facultade() {
    }

	public int getIdFACULTAD() {
		return this.idFACULTAD;
	}

	public void setIdFACULTAD(int idFACULTAD) {
		this.idFACULTAD = idFACULTAD;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Materia> getMaterias() {
		return this.materias;
	}

	public void setMaterias(Set<Materia> materias) {
		this.materias = materias;
	}
	
	public Set<Programa> getProgramas() {
		return this.programas;
	}

	public void setProgramas(Set<Programa> programas) {
		this.programas = programas;
	}
	
}