package co.edu.unicesi.sama.bo;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * 
 * Esta clase se encarga de crear el Business Object de un BloqueMateriaPK.
 *
 */
@Embeddable
public class BloquesMateriaPKBO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * FK_idMateria - int - id de la materia.
	 */
	private int FK_idMateria;

	/**
	 * FK_idBloque - int - id del bloque.
	 */
	private int FK_idBloque;

	public int getFK_idMateria() {
		return FK_idMateria;
	}

	public void setFK_idMateria(int fK_idMateria) {
		FK_idMateria = fK_idMateria;
	}

	public int getFK_idBloque() {
		return FK_idBloque;
	}

	public void setFK_idBloque(int fK_idBloque) {
		FK_idBloque = fK_idBloque;
	}

	public BloquesMateriaPKBO() {
		super();
	}
	
}
