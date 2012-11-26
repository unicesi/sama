package co.edu.unicesi.sama.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Clase de la llave primaria de la tabla bloques_competenciasespecificas en la base de datos.
 */
@Embeddable
public class BloquesCompetenciasespecificaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String FK_CodigoPrograma;

	private int FK_idCompetenciaEspecifica;

	private int FK_IdBloque;

    public BloquesCompetenciasespecificaPK() {
    }
	public String getFK_CodigoPrograma() {
		return this.FK_CodigoPrograma;
	}
	public void setFK_CodigoPrograma(String FK_CodigoPrograma) {
		this.FK_CodigoPrograma = FK_CodigoPrograma;
	}
	public int getFK_idCompetenciaEspecifica() {
		return this.FK_idCompetenciaEspecifica;
	}
	public void setFK_idCompetenciaEspecifica(int FK_idCompetenciaEspecifica) {
		this.FK_idCompetenciaEspecifica = FK_idCompetenciaEspecifica;
	}
	public int getFK_IdBloque() {
		return this.FK_IdBloque;
	}
	public void setFK_IdBloque(int FK_IdBloque) {
		this.FK_IdBloque = FK_IdBloque;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BloquesCompetenciasespecificaPK)) {
			return false;
		}
		BloquesCompetenciasespecificaPK castOther = (BloquesCompetenciasespecificaPK)other;
		return 
			this.FK_CodigoPrograma.equals(castOther.FK_CodigoPrograma)
			&& (this.FK_idCompetenciaEspecifica == castOther.FK_idCompetenciaEspecifica)
			&& (this.FK_IdBloque == castOther.FK_IdBloque);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.FK_CodigoPrograma.hashCode();
		hash = hash * prime + this.FK_idCompetenciaEspecifica;
		hash = hash * prime + this.FK_IdBloque;
		
		return hash;
    }
}