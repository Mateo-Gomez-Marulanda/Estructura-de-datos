package com.example.Unidad3.Arboles.ArbolBinario;

public class ArbolBinarioMain {
    public static void main(String[] args) {
        ArbolBinario<Integer> arbol = new ArbolBinario<>();

        arbol.insertarOrdenado(50);
        arbol.insertarOrdenado(30);
        arbol.insertarOrdenado(70);
        arbol.insertarOrdenado(20);
        arbol.insertarOrdenado(40);
        arbol.insertarOrdenado(60);
        arbol.insertarOrdenado(80);

        System.out.println("Existe 40: " + arbol.existP(40)); // true
        System.out.println("Existe 90: " + arbol.existP(90)); // false

        arbol.recorrerInOrden();
        arbol.recorrerPreOrden();
        arbol.recorrerPostOrden();

        int peso = arbol.peso();
        System.out.println("el peso del arbol es: " + peso);
    }
}

//la mala para losa arboles