package Excepcion;

/**
 * 
 * Excepcion que indica que la pila esta vacaa y no se puede realizar ciertas operaciones.
 *
 */
public class PilaVacia extends Exception {
	
	/**
	 * Constructor de la clase PilaVacia.
	 * 
	 * @param message Mensaje descriptivo de la excepcion.
	 */
	public PilaVacia(String message) {
		super(message);
	}
}