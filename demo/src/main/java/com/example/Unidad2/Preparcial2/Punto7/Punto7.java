package com.example.Unidad2.Preparcial2.Punto7;

import com.example.Unidad2.Cola.*;

class Pila2Colas<T extends Comparable<T>> {

    private Cola<T> cola1;
    private Cola<T> cola2; // uso auxiliar para el metodo pop()

    public Pila2Colas(Cola<T> cola1, Cola<T> cola2) {
        this.cola1 = cola1;
        this.cola2 = cola2;
    }

    // empilar LiFo
    public void push(T dato) {
        cola1.encolar(dato);
    }

    // desenpilar LiFo
    public T pop() {

        while (cola1.getTam() > 1) {

            cola2.encolar(cola1.desencolar());
        }

        T cima = cola1.desencolar();

        Cola<T> temp = cola1;
        cola1 = cola2;
        cola2 = temp;

        return cima;
    }
}

public class Punto7 {

    /*
     * Implementación de una pila con dos colas. Crear una clase Pila2Colas que
     * implementa una pila utilizando dos colas(propias). La pila debe ser capaz de
     * realizar las operaciones push y pop.
     */

    public static void main(String[] args) {
        Cola<Integer> cola1 = new Cola<>();
        Cola<Integer> cola2 = new Cola<>();

        Pila2Colas<Integer> pila = new Pila2Colas<>(cola1, cola2);

        pila.push(10);
        pila.push(20);
        pila.push(30);

        System.out.println("Desenpilando: " + pila.pop()); // 30
        System.out.println("Desenpilando: " + pila.pop()); // 20
        System.out.println("Desenpilando: " + pila.pop()); // 10
    }
}
