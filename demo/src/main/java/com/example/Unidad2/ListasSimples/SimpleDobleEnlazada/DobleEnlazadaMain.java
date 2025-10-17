package com.example.Unidad2.ListasSimples.SimpleDobleEnlazada;

public class DobleEnlazadaMain {

    public static void main(String[] args) {
        ListaDobleEnlazada<Integer> lista = new ListaDobleEnlazada<>();

        lista.agregarPrimero(10);
        lista.agregarPrimero(20);
        lista.agregarUltimo(5);
        lista.agregarEnPosicionEspecifica(15, 1);
        lista.mostrar(); // Debería mostrar: [20 15 10 5 ]
    }
}
