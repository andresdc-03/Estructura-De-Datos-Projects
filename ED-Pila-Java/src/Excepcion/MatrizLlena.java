package Excepcion;

/**
 * 
 * Excepcion que indica que una matriz esta llena y no se puede agregar mas elementos.
 *
 */
public class MatrizLlena extends Exception {
	
	/**
	 * Constructor de la clase MatrizLlena.
	 * 
	 * @param message Mensaje descriptivo de la excepcion.
	 */
	public MatrizLlena(String message) {
		super(message);
	}
}