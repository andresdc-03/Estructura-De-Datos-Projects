package Interfaz;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import Excepciones.Duplicado;

public class Diccionario<T extends Comparable<T>> {
    private List<Palabra<T>> palabras;

    public Diccionario() {
        palabras = new LinkedList<>();
    }

    // Añadir palabra al diccionario (Caso 1)
    public void agregarPalabra(Palabra<T> nuevaPalabra) throws Duplicado{
        boolean anadido = true;
        for (Palabra<T> p : palabras) { // Recorremos todas las palabras guardadas en el diccionario
            // Transformamos las palabras a tipo String y comparamos si la palabra del diccionario es igual a la palabra que buscamos para agregar
            if (p.getPalabra().toString().equalsIgnoreCase(nuevaPalabra.getPalabra().toString())) {
                throw new Duplicado("La palabra ya existe en el diccionario.");
            }
        }

        if (anadido) {
            palabras.add(nuevaPalabra); // Agregamos el objeto palabra, que contiene la palabra y su descripcion, a la lista palabras
            Collections.sort(palabras); // Ordenamos el diccionario alfabeticamente
        }
    }
    
    // Eliminar palabra del diccionario (Caso 2)
    public boolean eliminarPalabra(T palabraEliminar) {
        boolean eliminado = false;

        Palabra<T> palabraAEliminar = null; // Creamos el objeto palabra vacio
        for (Palabra<T> p : palabras) { // Recorremos todas las palabras guardadas en el diccionario
            // Transformamos las palabras a tipo String y comparamos si la palabra del diccionario es igual a la palabra que buscamos para eliminar
            if (p.getPalabra().toString().equalsIgnoreCase(palabraEliminar.toString())) { 
                palabraAEliminar = p; // Guardamos la palabra con su descripcion en el objeto "palabraAEliminar" 
                break; // Salimos del bucle
            }
        }
        
        if (palabraAEliminar != null) { // Si hemos encontrado la palabra
            palabras.remove(palabraAEliminar); // Eliminamos la palabra y su descripcion del diccionario
            eliminado = true;
        }

        return eliminado;
    }
    
    // Buscar la palabra pedida (Caso 3)
    public String buscarSignificado(T palabra) {
        for (Palabra<T> p : palabras) {
            if (p.getPalabra().toString().equalsIgnoreCase(palabra.toString())) {
                return p.getSignificado();
            }
        }

        return "Palabra no encontrada en el diccionario";
    }
    
    // Total de palabras del diccionario (Caso 4)
    public int obtenerCantidadPalabras() {
        return palabras.size();
    }

  }