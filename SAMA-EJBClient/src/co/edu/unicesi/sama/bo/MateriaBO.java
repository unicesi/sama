package co.edu.unicesi.sama.bo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="materias")
public class MateriaBO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idMateria;	

	private String descripcion;

	private String nombre;

	public MateriaBO() {
		super();
	}

	public String getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(String idMateria) {
		this.idMateria = idMateria;
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
	

}
