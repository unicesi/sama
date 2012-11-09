package co.edu.unicesi.sama.bo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



public class CompetenciasprofesionaleBO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idCompetenciaProfesional;

	private String descripcion;

	private int nivel;

	private String nombre;

	//bi-directional many-to-one association to Competenciasprofesionale
    @ManyToOne
	@JoinColumn(name="idPadre")
	private CompetenciasprofesionaleBO competenciasprofesionale;

	//bi-directional many-to-one association to Competenciasprofesionale
	@OneToMany(mappedBy="competenciasprofesionale")
	private Set<CompetenciasprofesionaleBO> competenciasprofesionales;

	//bi-directional many-to-one association to Programa
    @ManyToOne
	@JoinColumn(name="idPrograma")
	private ProgramaBO programa;

	public CompetenciasprofesionaleBO() {
		super();
	}

	public int getIdCompetenciaProfesional() {
		return idCompetenciaProfesional;
	}

	public void setIdCompetenciaProfesional(int idCompetenciaProfesional) {
		this.idCompetenciaProfesional = idCompetenciaProfesional;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public CompetenciasprofesionaleBO getCompetenciasprofesionale() {
		return competenciasprofesionale;
	}

	public void setCompetenciasprofesionale(
			CompetenciasprofesionaleBO competenciasprofesionale) {
		this.competenciasprofesionale = competenciasprofesionale;
	}

	public Set<CompetenciasprofesionaleBO> getCompetenciasprofesionales() {
		return competenciasprofesionales;
	}

	public void setCompetenciasprofesionales(
			Set<CompetenciasprofesionaleBO> competenciasprofesionales) {
		this.competenciasprofesionales = competenciasprofesionales;
	}

	public ProgramaBO getPrograma() {
		return programa;
	}

	public void setPrograma(ProgramaBO programa) {
		this.programa = programa;
	}


	//bi-directional many-to-one association to Lineadecompetencia

}
