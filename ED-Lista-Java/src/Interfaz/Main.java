package Interfaz;

import java.util.InputMismatchException;
import java.util.Scanner;

// Excepciones
import Excepciones.Duplicado;
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
		Scanner scanner = new Scanner(System.in);
        Diccionario<String> diccionario = new Diccionario<>();
        boolean parar = true;
        
    	while(parar){

			// Mostrar menu de opciones
			System.out.println("\nIndique el numero de la consulta a realizar:\r\n"
					+ "1. Anadir una palabra al diccionario\r\n"
					+ "2. Eliminar una palabra\r\n"
					+ "3. Busqueda de palabra\r\n"
					+ "4. Numero de palabras del diccionario\r\n"
					+ "5. Salir\r\n");


			try {
				int valor = scanner.nextInt();
				scanner.nextLine();

				// Comprobamos que el numero introducido este dentro del rango de valores permitidos
				if (valor < 1 || valor > 5) {
					throw new NumeroFueraRangoException("Error: debe introducir un número entre 1 y 5.");
				}

				// Llama al metodo correspondiente segun la opcion elegida por el usuario
				switch (valor) {
					case 1: 
						System.out.println();
						System.out.println("Que palabra quieres anadir al diccionario?");
						String palabra = scanner.nextLine();
						System.out.println();
						System.out.println("Ingrese el significado: ");
						String significado = scanner.nextLine();

						// Convertimos los datos a un objeto String del tipo nueva palabra
						Palabra<String> nuevaPalabra = new Palabra<>(palabra, significado);
						
						try { // Para la coaptura de error por duplicado
							diccionario.agregarPalabra(nuevaPalabra); // Enviamos la palabra a guardar
							System.out.println(nuevaPalabra + " ha sido agregada al diccionario.");

						} catch (Duplicado e) {
							System.out.println(e.getMessage());
							
						}
						break;
						
					case 2:
						System.out.println();
						System.out.println("Que palabra quieres eliminar?");
						String palabraEliminar = scanner.nextLine();
						boolean eliminado = diccionario.eliminarPalabra(palabraEliminar); // Enviamos la palabra a eliminar y guardamos si se ha eliminado o no

						if (eliminado) { 
							System.out.println(palabraEliminar + " ha sido eliminada del diccionario.");
						} else {
							System.out.println(palabraEliminar + " no se encontraba en el diccionario");
						}
						break;
						
					case 3:
						System.out.println();
						System.out.println("Ingrese una palabra para buscar su significado: ");
						String palabraBuscada = scanner.nextLine();
						String significadoBuscado = diccionario.buscarSignificado(palabraBuscada);
							System.out.println("El significado de la palabra \"" + palabraBuscada + "\" es: " + significadoBuscado);
						break;
						
					case 4:
						System.out.println();
						System.out.println("El diccionario tiene: " + diccionario.obtenerCantidadPalabras() + " palabras");
						break;
						
					case 5:
						System.out.println();
						System.out.println("Gracias por usar esta aplicacion...");	
						parar=false;
						break;
						
					default:
						System.out.println();
						System.out.println("Opcion no valida");
						break;
				}
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