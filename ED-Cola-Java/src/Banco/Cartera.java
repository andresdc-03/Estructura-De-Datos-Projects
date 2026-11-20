package Banco;

import java.util.LinkedList;
import java.util.*;
import java.util.Queue;

import Excepciones.AccionesInsuficientesException;

public class Cartera {
	
	// Atributos
	private Queue<PaqueteAccion> pack;
	private double gananciaTotal;
	
	// Metodo constructor
	public Cartera (Queue<PaqueteAccion> pack, double gananciaTotal) {
		this.pack=pack;
		this.gananciaTotal=gananciaTotal;
	}
	
	// Metodo para la compra de acciones (Caso 1)
	public int CompraAcciones(PaqueteAccion paquete) {
		int nAcc = 0; // Variable para guardar el total de acciones que tenemos
		pack.offer(paquete); // Insercion del paquete de acciones

		for (PaqueteAccion cartera : pack) { // Recorremos todas las acciones
			nAcc += cartera.getNacciones(); // Guardamos el total de las acciones
		}

		return nAcc;

	}

	// Metodo para la venta de acciones (Caso 2)
	public int VenderAccion(int cantidad, int precio) throws AccionesInsuficientesException{
		// Comporbamos que no se haya insertado el valor 0 como cantidad que se quiere vender
		if (cantidad <= 0) {
			throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
		}

		// Mientras que:
		//   - La cantidad que meto por teclado (la que quiero vender) sea mayor a 0
		//   - La cola no vacia (tengo acciones para vender)
		while (cantidad > 0 && !pack.isEmpty()) {
			
			// Coge el primer paquete de acciones con todos sus datos y lo guardo en paquete
			PaqueteAccion paquete = pack.peek();
			// Coge del primer paquete el numero de acciones que tiene este paquete y lo guarda en Nacc
			int Nacc = paquete.getNacciones();
			
			// Si el numero de acciones disponibles es menor que la cantidad que quiero vender
			if (Nacc <= cantidad) {
				pack.poll(); // Extrae y elimina el primer elemento de la cola (el primer paquete)
				gananciaTotal = gananciaTotal + (precio-paquete.getPrecioAccion()) * Nacc; // Calculamos las ganancias totales
				cantidad = cantidad - Nacc; // Restamos a la cantidad de accioens que se quieren vender el numero de acciones de este paquete
			}
			// Si el numero de acciones disponibles es mayor que la cantidad que quiero vender
			else {
				gananciaTotal = gananciaTotal + (precio-paquete.getPrecioAccion()) * cantidad; // Calculamos las ganancias totales
				paquete.setNacciones(Nacc - cantidad); // Guardamos el numero de acciones que sobran de este paquete
				cantidad=0; // Ponemos la cantidad que se quiere vender a 0
			}
		}

		// Cuando la cantidad de acciones que se quieren vender sea superior al del total de acciones que tienes en el total de los paquetes
		if (cantidad > 0) {
			throw new AccionesInsuficientesException ("La cantidad de acciones que usted quiere vender supera el numero de acciones disponibles!");
		}

		int nAcc = 0;
		for (PaqueteAccion paquete : pack) { // Recorremos todas las acciones
			nAcc += paquete.getNacciones(); // Guardamos el totla de las acciones
		}

		return nAcc; 
	}
	
	public double GananciaTotal() {
		return gananciaTotal;
	}
	
}