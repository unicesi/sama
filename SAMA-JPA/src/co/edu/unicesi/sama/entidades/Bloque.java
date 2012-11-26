package co.edu.unicesi.sama.entidades;

import java.io.Serializable;
import javax.persistence.*;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.MateriaBO;

import java.util.ArrayList;
import java.util.Set;


/**
 * Clase encargada de la persistencia de la tabla bloques en la base de datos.
 */
@Entity
@Table(name="bloques")
@NamedQueries({
	@NamedQuery(name="buscarBloqueporPrograma", query="SELECT c FROM Bloque c WHERE c.programa.codigo LIKE :programa"),
	@NamedQuery(name="buscarBloqueporId", query="SELECT c FROM Bloque c WHERE c.id LIKE :id")
})
public class Bloque implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * idBloque - int - id del bloque.
	 */
	@Id
	private int id;

	/**
	 * descripcion - String - descripcion del bloque.
	 */
	private String descripcion;
	
	/**
	 * nombre - String - nombre del bloque.
	 */
	private String nombre;

	//bi-directional many-to-one association to Programa
    @ManyToOne
	@JoinColumn(name="FK_idPrograma")
	private Programa programa;

	//bi-directional many-to-one association to BloquesCompetenciasespecifica
	@OneToMany(mappedBy="bloque")
	private Set<BloquesCompetenciasespecifica> bloquesCompetenciasespecificas;

	//bi-directional many-to-many association to Materia
    @ManyToMany
	@JoinTable(
		name="bloques_materias"
		, joinColumns={
			@JoinColumn(name="FK_IdBloque")
			}
		, inverseJoinColumns={
			@JoinColumn(name="FK_CodigoMateria")
			}
		)
	private Set<Materia> materias;

    /**
     * Constructor.
     */
    public Bloque() {
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

	public Programa getPrograma() {
		return this.programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}
	
	public Set<BloquesCompetenciasespecifica> getBloquesCompetenciasespecificas() {
		return this.bloquesCompetenciasespecificas;
	}

	public void setBloquesCompetenciasespecificas(Set<BloquesCompetenciasespecifica> bloquesCompetenciasespecificas) {
		this.bloquesCompetenciasespecificas = bloquesCompetenciasespecificas;
	}
	
	public Set<Materia> getMaterias() {
		return this.materias;
	}

	public void setMaterias(Set<Materia> materias) {
		this.materias = materias;
	}
	
	public BloqueBO toBO() {
		BloqueBO BO=new BloqueBO();
		BO.setDescripcion(this.descripcion);
		BO.setIdBloque(id);
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