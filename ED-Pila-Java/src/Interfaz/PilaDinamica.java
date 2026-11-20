package Interfaz;

import Excepcion.PilaVacia;

/**
 * 
 * Implementacion de una pila dinamica mediante nodos enlazados.
 *
 * @param <T> Tipo de elemento almacenado en la pila.
 * 
 */
public class PilaDinamica<T> implements Stack<T> {
	
	/**
	 * Objeto que indica cual es la posicion siguiente al elemento
	 */
	private Nodo<T> top; // Nodo superior de la pila
	
	/**
	 * Tamano de la pila
	 */
	private int tamano; // tamano actual de la pila
	
	/**
	 * Costuctor de la clase PilaDinamica.
	 */
	public PilaDinamica() {
		top = null; // No nos encontramos en ninguna posicion.
		this.tamano = 0; // Inicializa la pila como vacia.
	}
	
	/**
	 * Agrega un elemento a la pila.
	 * 
	 * @param elemento Elemento a agregar.
	 */
	public void push(T elemento) { // Metodo introducir elemento en pila
		Nodo<T> aux = new Nodo<T>(elemento,top); // Creamos nuevo nodo con los parametros "elemento" y "siguiente" que es el elemento que vamos a introducir
		top = aux;// Lo igualamos al top
		this.tamano++; // Se incrementa el tamano de la pila  
	}

	/**
	 * Elimina y devuelve el elemento en la cima de la pila.
	 * 
	 * @return Elemento en la cima de la pila.
	 * @throws PilaVacia Si la pila esta vacia.
	 */
	public T pop()throws PilaVacia { // Metodo eliminar elemento de la pila
		if(isEmpty()) { // Si la pila esta vacia salta un error
			throw new PilaVacia("Error. La Pila esta vacia.");
		}else { 
			T aux = top.getElemento(); // Guardamos el elemento de la cima
			 /*referenciarlo pero no me asegura que se haya eliminado el elemento que se encontraba en el top
			top=top.getSiguiente();*/
			Nodo<T> siguiente = top.getSiguiente(); // Guardamos una referencia al nodo que está debajo del actua
			/**
			 * Actualizamos la cima
	 		 */
			top = siguiente; // Deja de apuntar al nodo que era la cima y apunta al siguiente
			this.tamano--; // Se decrementa el tamano de la pila
			return aux;
		}
		
	}

	/**
	 * Retorna el elemento en la cima de la pila sin eliminarlo.
	 * 
	 * @return Elemento en la cima de la pila.
	 * @throws PilaVacia Si la pila esta vacia.
	 */
	public T top() throws PilaVacia { // te muestra cual es el elemento que se encuentra en el top
		if(isEmpty()) { // Si la pila esta vacia salta un error
			throw new PilaVacia("Error. La Pila esta vacia.");
		}else
			return top.getElemento();
	}	

	/**
	 * Verifica si la pila esta vacia.
	 * 
	 * @return true si la pila esta vacia, false de lo contracio.
	 */
	public boolean isEmpty() { // Metodo que comprueba si la pila esta vacia
		return top == null; // Si top vale null, significa que no hay ningún nodo.
	}	

	/**
	 * Retorna el tamano actual de la pila.
	 * 
	 * @return Tamano actual de la pila.
	 */
	public int size() { // Metodo que da el tamano actual de la pila
		return this.tamano;
	}
	
	/**
	 * Retorna una representacion en cadena de la pila.
	 * 
	 * @return Cadena que representa los elementos contenidos en la pila.
	 */
	public String toString() { // Imprime todos elementos contenidos en la pila
		if(isEmpty()) { // Si la pila esta vacia
			return "La pila esta vacia";
		}else { 
			String res = " "; // Creamos un String "res" donde guardaremos la impresion de la pila
			Nodo<T> aux = top; // Creamos un nodo auxiliar que empieza apuntando a top
			while(aux!=null) { // Recorremos hasta que sea nulo el uxiliar
				res= res + aux.getElemento(); // Cogemos el elemento y lo anadimos al String "res"
				aux = aux.getSiguiente(); // Pasamos al siguiente nodo
				res = res + " "; // Anadimos un espacio entre elemento y elemento
			}	
			return res;
		}
	}
}