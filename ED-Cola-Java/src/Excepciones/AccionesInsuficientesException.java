package Excepciones;

// Clase para controlar el error de acciones agotadas
public class AccionesInsuficientesException extends Exception{
	
	// Metodo constructor
	public AccionesInsuficientesException (String mensaje) {
		super (mensaje);
	}

}