package co.edu.unicesi.sama.entidades;

import java.io.Serializable;
import javax.persistence.*;

import co.edu.unicesi.sama.bo.AsociacionEspecificaBO;


/** 
 * Clase encargada de la persistencia de la tabla bloque_competenciasespecificas en la base de datos.
 */
@Entity
@Table(name="bloques_competenciasespecificas")
@NamedQueries({
@NamedQuery(name="consultaBloqueCompetenciaEspecifica", query="SELECT m FROM BloquesCompetenciasespecifica m WHERE m.bloque.id like :bloque"),

})
public class BloquesCompetenciasespecifica implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id - int - id de la competencia.
	 */
	@EmbeddedId
	private BloquesCompetenciasespecificaPK id;

	private int aplica;

	private int enseña;

	private int introduce;
	
	private int puntaje;

	//bi-directional many-to-one association to Bloque
    @ManyToOne
	@JoinColumn(name="FK_IdBloque", updatable = false, insertable = false)
	private Bloque bloque;

	//bi-directional many-to-one association to CompetenciasespecificasPrograma
    @ManyToOne
	@JoinColumns({
		@JoinColumn(name="FK_CodigoPrograma", referencedColumnName="FK_CodigoPrograma", updatable = false, insertable = false),
		@JoinColumn(name="FK_idCompetenciaEspecifica", referencedColumnName="FK_IdCompetenciaEspecifica", updatable = false, insertable = false)
		})
	private CompetenciasespecificasPrograma competenciasespecificasPrograma;

    public BloquesCompetenciasespecifica() {
    }

	public BloquesCompetenciasespecificaPK getId() {
		return this.id;
	}

	public void setId(BloquesCompetenciasespecificaPK id) {
		this.id = id;
	}
	
	public int getAplica() {
		return this.aplica;
	}

	public void setAplica(int aplica) {
		this.aplica = aplica;
	}

	public int getEnseña() {
		return this.enseña;
	}

	public void setEnseña(int enseña) {
		this.enseña = enseña;
	}

	public int getIntroduce() {
		return this.introduce;
	}

	public void setIntroduce(int introduce) {
		this.introduce = introduce;
	}

	public Bloque getBloque() {
		return this.bloque;
	}

	public void setBloque(Bloque bloque) {
		this.bloque = bloque;
	}
	
	public CompetenciasespecificasPrograma getCompetenciasespecificasPrograma() {
		return this.competenciasespecificasPrograma;
	}

	public void setCompetenciasespecificasPrograma(CompetenciasespecificasPrograma competenciasespecificasPrograma) {
		this.competenciasespecificasPrograma = competenciasespecificasPrograma;
	}
	
	public AsociacionEspecificaBO toBo(){
		AsociacionEspecificaBO bo= new AsociacionEspecificaBO();
		bo.setAplica(aplica);
		bo.setEnsena(enseña);
		bo.setIntroduce(introduce);
		return bo;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
}