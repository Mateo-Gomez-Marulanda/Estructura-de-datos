package com.example.Unidad2.Pila;

public class PilaMain {
    public static void main(String[] args) {
        Pila<Integer> pila = new Pila<>();

        pila.empilar(5);
        pila.empilar(2);
        pila.empilar(8);
        pila.empilar(1);

        System.out.println(pila);

        System.out.println("Desempilado: " + pila.desempilar());
        System.out.println(pila);

        System.out.println("Desempilado: " + pila.desempilar());
        System.out.println(pila);

        pila.empilar(10);
        System.out.println(pila);

        pila.ordenarAscendente();
        pila.ordenarDescendente();
        System.out.println(pila);
    }
}
