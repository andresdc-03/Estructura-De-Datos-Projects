package Banco;

import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.InputMismatchException;
import java.util.Queue;

// Clases para trabajar con fechas
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Excepciones
import Excepciones.AccionesInsuficientesException;
import Excepciones.NumeroFueraRangoException;

public class Main {
/* 
 ********************************
 * 
 *            Main
 *  
 ********************************
 */
	public static void main(String[] args) {
		Queue<PaqueteAccion> cola = new LinkedBlockingDeque<>(); // Creamos la cola
		Cartera cartera = new Cartera(cola, 0.0); // Creamos un objeto cartera que contendra la cola y la gananciatotal
		
		Scanner scanner = new Scanner(System.in);
		
		boolean salir = false;

		while (!salir) {
			// Mostrar menu de opciones
			System.out.println("\nIndique el numero de la consulta a realizar: \n");
			System.out.println("1. Comprar acciones");
			System.out.println("2. Vender acciones");
			System.out.println("3. Ganancia de capital hasta el momento");
			System.out.println("4. Salir");
			
			
			try {

				int opcion = scanner.nextInt();
				scanner.nextLine();

				// Comprobamos que el numero introducido este dentro del rango de valores permitidos
				if (opcion < 1 || opcion > 4) {
					throw new NumeroFueraRangoException("Error: debe introducir un número entre 1 y 4.");
				}

				// Llama al metodo correspondiente segun la opcion elegida por el usuario
				switch (opcion) {
					case 1: 
						System.err.println();
						System.out.println("Cuantas acciones quieres comprar?");
						int accionesCompra = scanner.nextInt();
						System.err.println();
						System.out.println("Ingrese el precio por accion:");
						int precioCompra = scanner.nextInt();

						// Creacion de la fecha actual
						LocalDate fecha = LocalDate.now(); // Obtenemos la fehca actual 
						DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Transformamos la fehca al formato dia/mes/año
						
						// Convertimos los datos a un objeto del tipo paquete
						PaqueteAccion paqueteAccion = new PaqueteAccion(accionesCompra, fecha.format(formato), precioCompra);
						System.out.println();
						System.out.println(paqueteAccion); // Imprimimos la informacion del paquete (para que se imprima de forma legible se usa el toString de PaqueteAccione)

						int nAccionesI = cartera.CompraAcciones(paqueteAccion); // Enviamos el paquete a la cola y devolvemos el total de las acciones
						System.out.println();
						System.out.println("Ingreso realizado, tienes " + nAccionesI + " acciones");
						break;
			
					case 2:
						System.err.println();
						System.out.println("Ingrese la cantidad de acciones a vender:");
						int accionesVenta = scanner.nextInt();
						System.err.println();
						System.out.println("Ingrese el precio al que quieres vender las acciones:");
						int precioVenta = scanner.nextInt();
						int nAccionesV = cartera.VenderAccion(accionesVenta, precioVenta); // Vendemos las acciones y devolvemos el total de las acciones
						System.out.println();
						System.out.println("Venta realizada, te quedan " + nAccionesV + " acciones");
						break;
						
					case 3:
						System.out.println();
						System.out.println("Ganancias totales: $" + cartera.GananciaTotal()); // Llamamos al metodo GananciaTotal para extraer el total ganado
						break;
		
					case 4:
						System.out.println();
						System.out.println("Gracias por usar esta aplicacion...");	
						salir = true;
						break;
			
					default:
						System.out.println("Opcion no valida");
				}
			} catch (AccionesInsuficientesException e) { // Para cuando no hay el numero suficiente de acciones que las que se quieren vender
				System.out.println(e.getMessage());
			} catch (InputMismatchException e) { // Para cuando se introduce una letra en vez de un numero
				System.out.println("Error: debe introducir un número, no una letra o simbolo. \n");
				scanner.nextLine(); // Elimina la entrada incorrecta ya que no puede leer esa letra y la dejaba pendiente en el Scanner
			} catch (NumeroFueraRangoException e) { // Para el numero fuera del rango
				System.out.println(e.getMessage());
			}
		}

		scanner.close();

	}
}
