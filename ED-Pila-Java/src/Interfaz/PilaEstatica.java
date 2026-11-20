package Interfaz;

import Excepcion.MatrizLlena;
import Excepcion.PilaVacia;

/**
 * 
 * Implementacion de una pila estatica mediante un array.
 *
 * @param <T> Tipo de elemento almacenado en la pila
 * 
 */
public class PilaEstatica<T> implements Stack<T>{
	
	/**
	 * Array donde almacenamos los elementos de la pila.
	 */
	private T [] stack;
	
	/**
	 * El valor del tamano maximo que va a poder tener la pila
	 */
	private int tamano;
	
	/**
	 * Posición del último elemento introducido (la cima de la pila).
	 */
	private int top = -1;
	
	/**
	 * Constructor que crea una pila estatica con un tamano dado.
	 * 
	 * @param tamano Tamano de la pila.
	 */
	public PilaEstatica(int tamano) {
		stack = (T[]) new Object[tamano]; // Convertimos el array a tipo T[]
		this.tamano = tamano; // Le damos a la pila un tamano
	}
	
	/**
	 * Agrega un elemento a la pila.
	 * 
	 * @throws MatrizLlena Si la implementacion de la pila tiene una capacidad limite y la alcanza.
	 */
	public void push(T elemento) throws MatrizLlena { // Metodo introducir elemento en pila
		if (top == tamano - 1) { // Si no queda mas hueco en la pila
			throw new MatrizLlena("Error. La Pila esta llena."); // Salta un mensaje de error
		} else { // Si hay espacio, se anade el valor a la pila
			top++; // Aumentamos en uno el valor del top
			stack[top] = elemento; // En la posicion que este el top anadimos ese nuevo valor
		}
	}
	
	/**
	 * Elimina y devuelve la cima de la pila.
	 * 
	 * @return Elemento en la cima de la pila.
	 * @throws PilaVacia Si la pila esta vacia.
	 */
	public T pop() throws PilaVacia { // Metodo eliminar elemento de la pila
		if(top == -1) { // Si la pila esta vacia salta un error
			throw new PilaVacia("Error. La Pila esta vacia.");
		} else { // Si hay elementos
			T elemento = stack[top]; // Seleccionamos ese elemento 
			top--; // Se decrementa el tamano de la pila (Pasamos al actual ultimo elemento)
			return elemento;
		}
	}
	
	/**
	 * Retorna el elemento en la cima de la pila sin eliminarlo.
	 * 
	 * @return Elemento en la cima de la pila.
	 * @throws PilaVacia Si la pila esta vacia.
	 */
	public T top()throws PilaVacia{ // Metodo que muestra cual es el elemento que se encuentra en el top
		if(top == -1) { // Si la pila esta vacia salta un error
			throw new PilaVacia("Error. La Pila esta vacia.");
		} else {
			return stack[top];
		}
	}
	
	/**
	 * Verifica si la pila esta vacia.
	 * 
	 * @return true si la pila esta vacia, false de lo contracio.
	 */
	public boolean isEmpty() { // Metodo que comprueba si la pila esta vacia
		return top == -1; // Si top vale -1, significa que no hay ningún nodo.
	}
	
	/**
	 * Retorna el tamano actual de la pila.
	 * 
	 * @return Tamano actual de la pila.
	 */
	public int size() { // Metodo que da el tamano actual de la pila
		return top + 1;
	}
	
	/**
	 * Retorna una representacion en cadena de la pila.
	 * 
	 * @return Cadena que representa los elementos contenidos en la pila.
	 */
	public String toString() { // Metodo para imprimir todos los elementos contenidos en la pila
		if(top == -1) { // Si la pila esta vacia
			return "La pila esta vacia";
		} else {
			System.out.print("[");
			for(int i=top; i >= 0; i--) { // Recorremos los elementos de la pila desde el ultimo elemento colocado (la cima) hasta el inicio
				System.out.print(" " + stack[i] + " "); // Imprimimos el valor en el que se encuentra la pila actualmente
			}
			System.out.println("]");
		}
		return null;
	}
}
