package co.edu.unicesi.sama.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the materias_competenciasespecificas database table.
 * 
 */
@Embeddable
public class MateriasCompetenciasespecificaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String FK_CodigoPrograma;

	private int FK_IdCompetenciaEspecifica;

	private String FK_CodigoMateria;

    public MateriasCompetenciasespecificaPK() {
    }
	public String getFK_CodigoPrograma() {
		return this.FK_CodigoPrograma;
	}
	public void setFK_CodigoPrograma(String FK_CodigoPrograma) {
		this.FK_CodigoPrograma = FK_CodigoPrograma;
	}
	public int getFK_IdCompetenciaEspecifica() {
		return this.FK_IdCompetenciaEspecifica;
	}
	public void setFK_IdCompetenciaEspecifica(int FK_IdCompetenciaEspecifica) {
		this.FK_IdCompetenciaEspecifica = FK_IdCompetenciaEspecifica;
	}
	public String getFK_CodigoMateria() {
		return this.FK_CodigoMateria;
	}
	public void setFK_CodigoMateria(String FK_CodigoMateria) {
		this.FK_CodigoMateria = FK_CodigoMateria;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MateriasCompetenciasespecificaPK)) {
			return false;
		}
		MateriasCompetenciasespecificaPK castOther = (MateriasCompetenciasespecificaPK)other;
		return 
			this.FK_CodigoPrograma.equals(castOther.FK_CodigoPrograma)
			&& (this.FK_IdCompetenciaEspecifica == castOther.FK_IdCompetenciaEspecifica)
			&& this.FK_CodigoMateria.equals(castOther.FK_CodigoMateria);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.FK_CodigoPrograma.hashCode();
		hash = hash * prime + this.FK_IdCompetenciaEspecifica;
		hash = hash * prime + this.FK_CodigoMateria.hashCode();
		
		return hash;
    }
}