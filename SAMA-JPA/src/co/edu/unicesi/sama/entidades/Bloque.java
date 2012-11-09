package co.edu.unicesi.sama.entidades;

import java.io.Serializable;
import javax.persistence.*;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.MateriaBO;

import java.util.ArrayList;
import java.util.Set;


/**
 * The persistent class for the bloques database table.
 * 
 */
@Entity
@Table(name="bloques")
@NamedQueries({
	@NamedQuery(name="buscarBloqueporPrograma", query="SELECT c FROM Bloque c WHERE c.programa.idPrograma LIKE :programa"),
	@NamedQuery(name="buscarBloqueporId", query="SELECT c FROM Bloque c WHERE c.idBloque LIKE :id")
})
public class Bloque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idBloque;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-many association to Materia
    @ManyToMany
	@JoinTable(
		name="bloques_materias"
		, joinColumns={
			@JoinColumn(name="FK_idBloque")
			}
		, inverseJoinColumns={
			@JoinColumn(name="FK_idMateria")
			}
		)
	private Set<Materia> materias;

	//bi-directional many-to-one association to Programa
    @ManyToOne
	@JoinColumn(name="FK_idPrograma")
	private Programa programa;

    public Bloque() {
    }

	public int getIdBloque() {
		return this.idBloque;
	}

	public void setIdBloque(int idBloque) {
		this.idBloque = idBloque;
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

	public Set<Materia> getMaterias() {
		return this.materias;
	}

	public void setMaterias(Set<Materia> materias) {
		this.materias = materias;
	}
	
	public Programa getPrograma() {
		return this.programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}
	

	public BloqueBO toBO() {
		BloqueBO BO=new BloqueBO();
		BO.setDescripcion(this.descripcion);
		BO.setIdBloque(idBloque);
		BO.setNombre(nombre);
		BO.setPrograma(programa.toBO());
		
		ArrayList<MateriaBO> ListaMateria= new ArrayList();
		for (Materia m : materias){
			ListaMateria.add(m.toBO());
		}
		BO.setMaterias(ListaMateria);		
		return BO;
		
	}
	
}