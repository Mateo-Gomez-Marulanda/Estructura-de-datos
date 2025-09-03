package com.example.Unidad1.ListaArray;

import java.util.ArrayList;

class Multiplicidad {

    private ArrayList<Integer> numeros = new ArrayList<>();

    public void eliminarMultiploCinco() {
        /* esto permite reemplazar un foreach, ademas de un if, lo cual permite q se puedan  eliminar elementos a medida q se recorre la lista  */
        numeros.removeIf(num -> num % 5 == 0);
    }

    public void agregarNumero(Integer num) {
        numeros.add(num);
    }

    @Override
    public String toString() {
        return "numeros: " + numeros;
    }
}

public class MultiploCinco {

    public static void main(String[] args) {
        Multiplicidad numeros = new Multiplicidad();

        numeros.agregarNumero(4);
        numeros.agregarNumero(5);
        numeros.agregarNumero(10);
        numeros.agregarNumero(3);
        numeros.eliminarMultiploCinco();
        System.out.println(numeros);
    }
}
