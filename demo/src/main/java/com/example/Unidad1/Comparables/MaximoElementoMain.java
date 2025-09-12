package com.example.Unidad1.Comparables;

import java.util.List;
import java.util.Optional;

public class MaximoElementoMain {

    public static <T extends Comparable<T>> T obtenerMaximo(List<T> lista) {
        // Usamos Stream API para procesar la lista sin necesidad de ciclos explícitos.
        // max() recibe un comparador. Como los elementos ya son Comparable, usamos
        // compareTo.
        Optional<T> maximo = lista.stream().max((a, b) -> a.compareTo(b));

        // Optional<T> evita problemas si la lista está vacía.
        // Si hay un valor, se retorna; si no, devolvemos null.
        return maximo.orElse(null);
    }


        public static void main(String[] args) {
            // Ejemplo 1: lista de enteros
            List<Integer> numeros = List.of(10, 25, 3, 88, 42);
            Integer maxNumero = obtenerMaximo(numeros);
            System.out.println("El máximo número es: " + maxNumero);

            // Ejemplo 2: lista de cadenas (alfabéticamente)
            List<String> palabras = List.of("manzana", "pera", "banana", "kiwi");
            String maxPalabra = obtenerMaximo(palabras);
            System.out.println("La palabra máxima es: " + maxPalabra);
        }
    
}