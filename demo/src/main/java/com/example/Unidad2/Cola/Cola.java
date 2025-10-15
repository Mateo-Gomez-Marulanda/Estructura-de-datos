package com.example.Unidad2.Cola;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cola<T extends Comparable<? super T>> {

    private Nodo<T> inicio;
    private Nodo<T> fin;
    private int tam;

    public Cola() {
        inicio = null;
        fin = null;
        tam = 0;
    }

    public Nodo<T> getInicio() {
        return inicio;
    }

    public void setInicio(Nodo<T> inicio) {
        this.inicio = inicio;
    }

    public Nodo<T> getFin() {
        return fin;
    }

    public void setFin(Nodo<T> fin) {
        this.fin = fin;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public void encolar(T dato) {
        Nodo<T> newNodo = new Nodo<>(dato);
        if (inicio == null) {
            inicio = fin = newNodo;
            tam++;
            return;
        }
        fin.setProximo(newNodo);
        fin = newNodo;
        tam++;
    }

    public T desencolar() {
        if (inicio == null) {
            // cola vacía
            return null;
        }

        T dato = inicio.getDato();
        inicio = inicio.getProximo();
        tam--;

        if (inicio == null) {
            fin = null;
        }

        return dato;
    }

    private void ordenarColaSimple(Comparator<? super T> comp) {
        if (inicio == null)
            return;

        List<T> datos = new ArrayList<>();
        Nodo<T> actual = inicio;
        while (actual != null) {
            datos.add(actual.getDato());
            actual = actual.getProximo();
        }

        datos.sort(comp);

        actual = inicio;
        for (T dato : datos) {
            actual.setDato(dato);
            actual = actual.getProximo();
        }
    }

    public void imprimirCola() {
        if (inicio == null) {
            System.out.println("La cola está vacía.");
            return;
        }

        Nodo<T> actual = inicio;
        System.out.print("Cola: ");
        while (actual != null) {
            System.out.print(actual.getDato());
            if (actual.getProximo() != null) {
                System.out.print(" -> ");
            }
            actual = actual.getProximo();
        }
        System.out.println(" -> null");
    }

    public void ordenarNatural() {
        ordenarColaSimple(Comparator.naturalOrder());
    }

    public void ordenarAscendente() {
        ordenarColaSimple(Comparator.naturalOrder());
    }

    public void ordenarDescendente() {
        ordenarColaSimple(Comparator.reverseOrder());
    }
}