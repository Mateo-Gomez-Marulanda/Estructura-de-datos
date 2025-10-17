package com.example.Unidad2.ListasCirculares.CircularSimpleEnlazada;

public class SimpleEnlazada {

    public static void main(String[] args) {
        ListaCircular<Integer> lista = new ListaCircular<>();

        lista.agregarPrimero(10);
        lista.agregarPrimero(20);
        lista.agregarUltimo(5);
        lista.agregarUltimo(1);

        lista.mostrar();
    }
}