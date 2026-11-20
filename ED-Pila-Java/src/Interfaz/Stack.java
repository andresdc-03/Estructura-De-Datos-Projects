package Interfaz;

import Excepcion.MatrizLlena;
import Excepcion.PilaVacia;

/**
 * 
 * Inerfaz que define el comportamiento de la pila (Acciones que puedes hacer en la pila).
 *
 * @param <T> Tipo generico de elemento almacenado en la pila
 * 
 */
public interface Stack<T> {
	
	/**
	 * Agrega un elemento a la pila.
	 * 
	 * @param element Elemento a agregar.
	 * @throws MatrizLlena Si la implementacion de la pila tiene una capacidad limite y la alcanza.
	 */
	void push(T element) throws MatrizLlena; // Agrega elemento si hay hueco 
	
	/**
	 * Elimina y devuelve el elemento en la cima de la pila.
	 * 
	 * @return Elemento en la cima de la pila.
	 * @throws PilaVacia Si la pila esta vacia.
	 */
	T pop() throws PilaVacia; // Si hay elemento en la pila elimina el elemento de la cima de la pila pero nos lo guardamos
	
	/**
	 * Retorna el elemento en la cima de la pila sin eliminarlo.
	 * 
	 * @return Elemento en la cima de la pila.
	 * @throws PilaVacia Si la pila esta vacia.
	 */
	T top() throws PilaVacia; // Si hay elemento en la pila devolvemos el elemento de la cima de la pila
	
	/**
	 * Verifica si la pila esta vacia.
	 * 
	 * @return true si la pila esta vacia, false de lo contrario.
	 */
	boolean isEmpty();
	
	/**
	 * Retorna el tamano actual de la pila.
	 * 
	 * @return Tamano actual de la pila.
	 */
	int size();
	
	/**
	 * Retorna una representacion en cadena de la pila.
	 * 
	 * @return Cadena que representa los elementos contenidos en la pila.
	 */
	String toString();
}
