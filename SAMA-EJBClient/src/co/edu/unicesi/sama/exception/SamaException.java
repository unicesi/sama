package co.edu.unicesi.sama.exception;

import java.io.Serializable;

public class SamaException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 */
	public SamaException() {		
	}
	
	/**
	 * Constructor
	 * @param message - String - mensaje de la excepcion.
	 */
	public SamaException (String message){
		
		super(message);
	}

	
}
