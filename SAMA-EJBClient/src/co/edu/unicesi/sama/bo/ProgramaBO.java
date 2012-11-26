package co.edu.unicesi.sama.bo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;

/**
 * Esta clase se encarga de crear el BussinesObject de un programa.
 *
 */
@Entity
@Table(name="Programas")
public class ProgramaBO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * idPrograma - int - id del programa.
	 */
	@Id
	private String idPrograma;

	/**
	 * descripcion - String - descripcion del programa.
	 */
	private String descripcion;

	/**
	 * nombre - String - nombre del programa.
	 */
	private String nombre;

	/**
	 * Constructor.
	 */
    public ProgramaBO() {
    }

	public String getIdPrograma() {
		return this.idPrograma;
	}

	public void setIdPrograma(String idPrograma) {
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