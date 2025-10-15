package com.example.Unidad2.Pila;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Nodo<T> {
    private T dato;
    private Nodo<T> proximo; // Referencia al siguiente elemento

    public Nodo(T dato) {
        this.dato = dato;
        proximo = null; // Null inicialmente ya que no referencia a nada antes de estar en la lista
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

    @Override
    public String toString() {
        return "Nodo{" +
                "dato=" + dato +
                ", proximo=" + proximo +
                '}';
    }

    public void setAnterior(Nodo<T> actual) {
        this.proximo = actual;
    }
}

class Pila<T extends Comparable<? super T>> {
    private Nodo<T> cima;
    private int tam;

    public Pila() {
        cima = null;
        tam = 0;
    }

    public void empilar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.setProximo(cima);
        cima = nuevo;
        tam++;
    }

    public T desempilar() {
        if (estaVacia()) {
            return null;
        }

        T dato = cima.getDato();
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
        Nodo<T> actual = cima;
        while (actual != null) {
            sb.append(actual.getDato()).append(" -> ");
            actual = actual.getProximo();
        }
        sb.append("null");
        return sb.toString();
    }

    private void ordenarPila(Comparator<T> comp) {
        List<T> datos = new ArrayList<>();
        Nodo<T> actual = cima;
        while (actual != null) {
            datos.add(actual.getDato());
            actual = actual.getProximo();
        }
        datos.sort(comp);

        actual = cima;
        for (T dato : datos) {
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
}

public class PilaMain {
    public static void main(String[] args) {
         
    }
}
