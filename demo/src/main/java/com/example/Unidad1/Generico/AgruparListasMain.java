package com.example.Unidad1.Generico;

/*
 * Implementar un método genérico que reciba dos listas de cualquier tipo(List) y devuelva una nueva LinkedList con la unión de ambas listas, eliminando los elementos duplicados. Usa las clases e interfaces de java.util.Collections(no se pueden usar ciclos,  ni recursividad).

 */

import java.util.LinkedList;
import java.util.List;

class Generic<T> {
    private List<T> lista = new LinkedList<>();

    public void unirListas(List<T> lista2) {
        lista.addAll(lista2);
    }

    public void agregarElemento(T elemento) {
        lista.add(elemento);
    }

    public void eliminarElementoRepetido() {
        lista = new LinkedList<>(lista.stream().distinct().toList());
    }

    public List<T> getLista() {
        return lista;
    }

    @Override
    public String toString() {
        return "Lista: " + lista;
    }
}

public class AgruparListasMain {
    public static void main(String[] args) {
        Generic<String> lista1 = new Generic<>();
        Generic<String> lista2 = new Generic<>();

        lista1.agregarElemento("zunga");
        lista1.agregarElemento("tup");
        lista1.agregarElemento("w yandel");

        lista2.agregarElemento("pepe");
        lista2.agregarElemento("zunga");
        lista2.agregarElemento("teto");

        lista1.unirListas(lista2.getLista());
        lista1.eliminarElementoRepetido();

        System.out.println(lista1);
        

    }
}
