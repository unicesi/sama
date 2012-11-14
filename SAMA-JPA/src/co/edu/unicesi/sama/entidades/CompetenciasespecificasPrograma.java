package co.edu.unicesi.sama.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the competenciasespecificas_programas database table.
 * 
 */
@Entity
@Table(name="competenciasespecificas_programas")
public class CompetenciasespecificasPrograma implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CompetenciasespecificasProgramaPK id;

	//bi-directional many-to-one association to BloquesCompetenciasespecifica
	@OneToMany(mappedBy="competenciasespecificasPrograma")
	private Set<BloquesCompetenciasespecifica> bloquesCompetenciasespecificas;

	//bi-directional many-to-one association to MateriasCompetenciasespecifica
	@OneToMany(mappedBy="competenciasespecificasPrograma")
	private Set<MateriasCompetenciasespecifica> materiasCompetenciasespecificas;

    public CompetenciasespecificasPrograma() {
    }

	public CompetenciasespecificasProgramaPK getId() {
		return this.id;
	}

	public void setId(CompetenciasespecificasProgramaPK id) {
		this.id = id;
	}
	
	public Set<BloquesCompetenciasespecifica> getBloquesCompetenciasespecificas() {
		return this.bloquesCompetenciasespecificas;
	}

	public void setBloquesCompetenciasespecificas(Set<BloquesCompetenciasespecifica> bloquesCompetenciasespecificas) {
		this.bloquesCompetenciasespecificas = bloquesCompetenciasespecificas;
	}
	
	public Set<MateriasCompetenciasespecifica> getMateriasCompetenciasespecificas() {
		return this.materiasCompetenciasespecificas;
	}

	public void setMateriasCompetenciasespecificas(Set<MateriasCompetenciasespecifica> materiasCompetenciasespecificas) {
		this.materiasCompetenciasespecificas = materiasCompetenciasespecificas;
	}
	
}