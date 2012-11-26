package co.edu.unicesi.sama.bo;

import java.io.Serializable;


import javax.persistence.Embeddable;

/**
 * 
 * Esta clase se encarga de crear el BusinesObject de una asociacion especifica.
 *
 */
@Embeddable
public class AsociacionEspecificaBO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int aplica;

	private int ensena;

	private int introduce;

	public int getAplica() {
		return aplica;
	}

	public void setAplica(int aplica) {
		this.aplica = aplica;
	}

	public int getEnsena() {
		return ensena;
	}

	public void setEnsena(int ensena) {
		this.ensena = ensena;
	}

	public int getIntroduce() {
		return introduce;
	}

	public void setIntroduce(int introduce) {
		this.introduce = introduce;
	}

	
	

	

}
