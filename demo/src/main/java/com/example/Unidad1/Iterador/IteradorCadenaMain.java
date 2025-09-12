package com.example.Unidad1.Iterador;

/*
 * Realizar una clase llamada MiLista que tenga un arreglo de cadenas, usar un iterador propio para que la clase MiLista permita recorrer la lista de cadenas solo con las posiciones pares.

 */
import java.util.Iterator;

class MiLista implements Iterable<String> {
    private String[] lista;
    private int index;

    public MiLista(int cantidadCadenas) {
        this.index = 0;
        lista = new String[cantidadCadenas];

    }

    public void agregarCadena(String cadena) {
        lista[index] = cadena;
        index++;
    }

    public String obtenerCadena(int index) {
        return lista[index];
    }

    public int tamanio() {
        return index;
    }

    public int obtenerPosicion(String cadena) {
        // Recorre todas las posiciones ocupadas de la lista
        for (int i = 0; i < index; i++) {
            // Si la cadena en la posición actual coincide con la buscada
            if (lista[i].equals(cadena)) {
                return i; // devuelve la posición encontrada
            }
        }
        // Si terminó el recorrido y no encontró la cadena
        return -1;
    }

    @Override
    public Iterator<String> iterator() {
        return new IteradorCadena(this);
    }
}

class IteradorCadena implements Iterator<String> {
    private MiLista lista;
    private int index;

    public IteradorCadena(MiLista lista) {
        this.lista = lista;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < lista.tamanio();
    }

    @Override
    public String next() {
        return lista.obtenerCadena(index++);
    }
}

public class IteradorCadenaMain {
    public static void main(String[] arg) {
        MiLista lista = new MiLista(5);
        lista.agregarCadena("mondongo");
        lista.agregarCadena("uwu");
        lista.agregarCadena("sapito");
        lista.agregarCadena("la mala para jean carlos");

        /*
         * Iterator<String> iterator = lista.iterator();
         * 
         * while(iterator.hasNext()){
         * String cadena = iterator.next();
         * System.out.println(cadena);
         * }
         */

        for (String cadena : lista) {
            if (lista.obtenerPosicion(cadena) % 2 == 0) {
                System.out.println(cadena);
            }
        }
    }
}
