package com.example.Unidad2.Preparcial2.Punto2;

/*
 * Se tiene una pila de enteros positivos.
 * Con las operaciones básicas de pilas y colas escribir un método para poner todos los elementos primos
 * de la pila en la cola. Retorne la cola final.
 */

import com.example.Unidad2.Cola.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Nodo {
    private Integer dato;
    private Nodo proximo;

    public Nodo(Integer dato) {
        this.dato = dato;
        proximo = null;
    }

    public Integer getDato() {
        return dato;
    }

    public void setDato(Integer dato) {
        this.dato = dato;
    }

    public Nodo getProximo() {
        return proximo;
    }

    public void setProximo(Nodo proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "Nodo{" + "dato=" + dato + ", proximo=" + proximo + '}';
    }

    public void setAnterior(Nodo actual) {
        this.proximo = actual;
    }
}

class Pila {
    private Nodo cima;
    private int tam;

    public Pila() {
        cima = null;
        tam = 0;
    }

    public void empilar(Integer dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.setProximo(cima);
        cima = nuevo;
        tam++;
    }

    public Integer desempilar() {
        if (estaVacia()) {
            return null;
        }
        Integer dato = cima.getDato();
        cima = cima.getProximo();
        tam--;
        return dato;
    }

    public boolean estaVacia() {
        return tam == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Pila: ");
        Nodo actual = cima;
        while (actual != null) {
            sb.append(actual.getDato()).append(" -> ");
            actual = actual.getProximo();
        }
        sb.append("null");
        return sb.toString();
    }

    private void ordenarPila(Comparator<Integer> comp) {
        List<Integer> datos = new ArrayList<>();
        Nodo actual = cima;
        while (actual != null) {
            datos.add(actual.getDato());
            actual = actual.getProximo();
        }

        datos.sort(comp);

        actual = cima;
        for (Integer dato : datos) {
            actual.setDato(dato);
            actual = actual.getProximo();
        }
    }

    public void ordenarNatural() {
        ordenarPila(Comparator.naturalOrder());
    }

    public void ordenarAscendente() {
        ordenarPila(Comparator.naturalOrder());
    }

    public void ordenarDescendente() {
        ordenarPila(Comparator.reverseOrder());
    }

    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public Cola<Integer> conversionPilaCola(Pila pila) {
        Cola<Integer> cola = new Cola<>();

        Nodo actual = pila.cima;
        while (actual != null) {
            int valor = actual.getDato();
            if (esPrimo(valor)) {
                cola.encolar(valor);
            }
            actual = actual.getProximo();
        }
        return cola;
    }
}

// pila 1-2-3-4-5 first return 5 LiFo
// colaPrima 5-3-2 -> ordenar() [mera este tica]
// cola 1-2-3-4-5 fisrt return 1 FiFo
public class Punto2 {
    public static void main(String[] args) {
        Pila pila = new Pila();
        pila.empilar(1);
        pila.empilar(2);
        pila.empilar(3);
        pila.empilar(4);
        pila.empilar(5);

        System.out.println(pila);

        Cola<Integer> colaPrimos = pila.conversionPilaCola(pila);
        colaPrimos.imprimirCola();
    }
}
