package com.example.Unidad2.Cola;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Nodo<T> {
    private T dato;
    private Nodo<T> proximo;
    private Nodo<T> anterior;

    public Nodo(T dato) {
        this.dato = dato;
        proximo = null; // Null inicialmente ya que no referencia a nada antes de estar en la lista
        anterior = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getProximo() {
        return proximo;
    }

    public void setProximo(Nodo<T> proximo) {
        this.proximo = proximo;
    }

    public Nodo<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo<T> anterior) {
        this.anterior = anterior;

    }

    @Override
    public String toString() {
        return "Nodo{" +
                "dato=" + dato + ", anterior=" + anterior +
                ", proximo=" + proximo +
                '}';
    }
}

class Cola<T extends Comparable<? super T>> {

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

public class ColaMain {
    public static void main(String[] args) {
        
    }
}
