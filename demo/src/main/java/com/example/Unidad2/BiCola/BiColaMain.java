package com.example.Unidad2.BiCola;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Nodo<T> {
    private T dato;
    private Nodo<T> proximo;
    private Nodo<T> anterior; // Referencia al siguiente elemento

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

    public Nodo<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo<T> anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return "Nodo{" +
                "dato=" + dato +
                ", proximo=" + proximo + ", anterior=" + anterior +
                '}';
    }

}

class BiCola<T extends Comparable<? super T>> {
    private Nodo<T> frente;
    private Nodo<T> fin;
    private int tam;

    public BiCola() {
        this.frente = null;
        this.fin = null;
        this.tam = 0;
    }

    // Agregar nodo al inicio
    public void agregarAlInicio(Nodo<T> nuevoNodo) {
        if (estaVacia()) {
            frente = nuevoNodo;
            fin = nuevoNodo;
        } else {
            nuevoNodo.setProximo(frente);
            frente.setAnterior(nuevoNodo);
            frente = nuevoNodo;
        }
        tam++;
    }

    // Agregar nodo al final
    public void agregarAlFin(Nodo<T> nuevoNodo) {
        if (estaVacia()) {
            frente = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.setProximo(nuevoNodo);
            nuevoNodo.setAnterior(fin);
            fin = nuevoNodo;
        }
        tam++;
    }

    // Eliminar nodo del inicio
    public Nodo<T> eliminarDelInicio() {
        if (estaVacia()) {
            return null;
        }

        Nodo<T> nodoEliminado = frente;

        if (frente == fin) {
            frente = null;
            fin = null;
        } else {
            frente = frente.getProximo();
            frente.setAnterior(null);
        }
        tam--;
        return nodoEliminado;
    }

    // Eliminar nodo del final
    public Nodo<T> eliminarDelFin() {
        if (estaVacia()) {
            return null;
        }

        Nodo<T> nodoEliminado = fin;

        if (frente == fin) {
            frente = null;
            fin = null;
        } else {
            fin = fin.getAnterior();
            fin.setProximo(null);
        }
        tam--;
        return nodoEliminado;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public int tamaño() {
        return tam;
    }

    private void ordenarBicola(Comparator<T> comp) {
        List<T> datos = new ArrayList<>();
        Nodo<T> actual = frente;
        while (actual != null) {
            datos.add(actual.getDato());
            actual = actual.getProximo();
        }
        datos.sort(comp);

        actual = frente;
        for (T dato : datos) {
            actual.setDato(dato);
            actual = actual.getProximo();
        }
    }

    public void ordenarNatural() {
        ordenarBicola(Comparator.naturalOrder());
    }

    public void ordenarAscendente() {
        ordenarBicola(Comparator.naturalOrder());
    }

    public void ordenarDescendente() {
        ordenarBicola(Comparator.reverseOrder());
    }
}

public class BiColaMain {

}
