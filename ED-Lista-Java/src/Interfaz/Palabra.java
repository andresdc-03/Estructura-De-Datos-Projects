package Interfaz;

public class Palabra<T extends Comparable<T>> implements Comparable<Palabra<T>> { // La extension para comparar palabras
    private T palabra;
    private String significado;

    public Palabra(T palabra, String significado) {
        this.palabra = palabra;
        this.significado = significado;
    }

    public T getPalabra() {
        return palabra;
    }
    public String getSignificado() {
        return significado;
    }

    // Metodo para ordenar las palabras del diccionario segun el atributo palabra
    @Override
    public int compareTo(Palabra<T> other) {
        return this.palabra.compareTo(other.getPalabra());
    }
}