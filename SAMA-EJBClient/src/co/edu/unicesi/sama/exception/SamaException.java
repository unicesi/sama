package co.edu.unicesi.sama.exception;

import java.io.Serializable;

public class SamaException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SamaException() {
		
		
	}
	public SamaException (String message){
		
		super(message);
	}

	
}
