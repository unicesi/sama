package co.edu.unicesi.sama.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;




public class BloqueBO implements Serializable {
	
	
	private int idBloque;

	private String descripcion;

	private String nombre;
	
	private ArrayList<MateriaBO> materias;

	//bi-directional many-to-one association to Programa
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
