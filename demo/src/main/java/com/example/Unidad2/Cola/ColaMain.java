package com.example.Unidad2.Cola;

public class ColaMain {
    public static void main(String[] args) {
        Cola<Integer> cola = new Cola<>();

        cola.encolar(5);
        cola.encolar(10);
        cola.encolar(15);

        System.out.println(cola);

        System.out.println("Desencolando: " + cola.desencolar());
        System.out.println(cola);

        System.out.println("Desencolando: " + cola.desencolar());
        System.out.println(cola);

        System.out.println("Desencolando: " + cola.desencolar());
        System.out.println(cola);

        System.out.println("Desencolando de una cola vacía: " + cola.desencolar());
        
        cola.ordenarAscendente();
        System.out.println(cola);
        cola.ordenarDescendente();
        System.out.println(cola);
    }
}
