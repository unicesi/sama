package co.edu.unicesi.sama.entidades;

import java.io.Serializable;
import javax.persistence.*;

import co.edu.unicesi.sama.bo.AsociacionEspecificaBO;


/**
 * Clase encargada de la persistencia de la tabla materias_competenciasespecificas en la base de datos.
 */
@Entity
@Table(name="materias_competenciasespecificas")
@NamedQueries({
	@NamedQuery(name="consultaMateriaCompetenciaEspecifica", query="SELECT m FROM MateriasCompetenciasespecifica m WHERE m.materia.codigo like :materia"),

})
public class MateriasCompetenciasespecifica implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MateriasCompetenciasespecificaPK id;

	private int aplica;

	private int enseña;

	private int introduce;

	private int puntaje;
	//bi-directional many-to-one association to Materia
    @ManyToOne
	@JoinColumn(name="FK_CodigoMateria", updatable = false, insertable = false)
	private Materia materia;

	//bi-directional many-to-one association to CompetenciasespecificasPrograma
    @ManyToOne
	@JoinColumns({
		@JoinColumn(name="FK_CodigoPrograma", referencedColumnName="FK_CodigoPrograma", updatable = false, insertable = false),
		@JoinColumn(name="FK_IdCompetenciaEspecifica", referencedColumnName="FK_IdCompetenciaEspecifica", updatable = false, insertable = false)
		})
	private CompetenciasespecificasPrograma competenciasespecificasPrograma;

    public MateriasCompetenciasespecifica() {
    }

	public MateriasCompetenciasespecificaPK getId() {
		return this.id;
	}

	public void setId(MateriasCompetenciasespecificaPK id) {
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

	public Materia getMateria() {
		return this.materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
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