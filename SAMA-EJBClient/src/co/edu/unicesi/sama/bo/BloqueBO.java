package co.edu.unicesi.sama.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * 
 * Esta clase se encarga de crear el Business Object de un bloque.
 *
 */
public class BloqueBO implements Serializable {
	
	/**
	 * idBloque - int - id del bloque.
	 */
	private int idBloque;

	/**
	 * descripcion - String - descripcion del bloque.
	 */
	private String descripcion;

	/**
	 * nombre - String - nombre del bloque.
	 */
	private String nombre;
	
	/**
	 * materias - ArrayList<MateriaBO> es el conjunto de Business Object de materias del bloque.
	 */
	private ArrayList<MateriaBO> materias;

	//bi-directional many-to-one association to Programa
	/**
	 * programa - ProgramaBO - Business Object del programa al cual el bloque esta asociado.
	 */
    @ManyToOne
	@JoinColumn(name="FK_idPrograma")
	private ProgramaBO programa;

	//bi-directional many-to-one association to BloquesLineadecompetencia
	@OneToMany(mappedBy="bloque")
	private Set<BloquesLineadecompetenciaBO> bloquesLineadecompetencias;

	public int getIdBloque() {
		return idBloque;
	}

	public void setIdBloque(int idBloque) {
		this.idBloque = idBloque;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ProgramaBO getPrograma() {
		return programa;
	}

	public void setPrograma(ProgramaBO programa) {
		this.programa = programa;
	}

	public Set<BloquesLineadecompetenciaBO> getBloquesLineadecompetencias() {
		return bloquesLineadecompetencias;
	}

	public void setBloquesLineadecompetencias(
			Set<BloquesLineadecompetenciaBO> bloquesLineadecompetencias) {
		this.bloquesLineadecompetencias = bloquesLineadecompetencias;
	}

	public ArrayList<MateriaBO> getMaterias() {
		return materias;
	}

	public void setMaterias(ArrayList<MateriaBO> materias) {
		this.materias = materias;
	}

}
