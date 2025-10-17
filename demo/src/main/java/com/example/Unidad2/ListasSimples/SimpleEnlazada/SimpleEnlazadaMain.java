package com.example.Unidad2.ListasSimples.SimpleEnlazada;

public class SimpleEnlazadaMain {

    public static void main(String[] args) {
        ListaSimpleEnlazada<Integer> lista = new ListaSimpleEnlazada<>();

        lista.agregarPrimero(10);
        lista.agregarPrimero(20);
        lista.agregarUltimo(5);
        lista.agregarEnPosicionEspecifica(15, 1);

        lista.mostrar();
    }
}
