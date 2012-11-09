package co.edu.unicesi.sama.bo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the Programas database table.
 * 
 */
@Entity
@Table(name="Programas")
public class ProgramaBO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPrograma;

	private String descripcion;

	private String nombre;

    public ProgramaBO() {
    }

	public int getIdPrograma() {
		return this.idPrograma;
	}

	public void setIdPrograma(int idPrograma) {
		this.idPrograma = idPrograma;
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
}