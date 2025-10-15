package com.example.Unidad2.ListasSimples;

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

class ListaDoblementeEnlazada<T extends Comparable<T>> {
    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int tam;

    public ListaDoblementeEnlazada() {
        primero = null;
        ultimo = null;
        tam = 0;
    }

    public void agregarPrimero(T dato) {
        Nodo<T> newNodo = new Nodo(dato);

        if (primero == null) {
            primero = newNodo;
            ultimo = newNodo;
            tam++;
        } else {
            newNodo.setProximo(primero);
            primero.setAnterior(newNodo);
            primero = newNodo;
            tam++;
        }
    }

    public void mostrar() {
        Nodo<T> actual = primero;
        String mensaje = "[";
        do {
            mensaje += actual.getDato() + " ";
            actual = actual.getProximo();
        } while (actual != null);

        mensaje += "]";
        System.out.println(mensaje);
    }

    public void agregarUltimo(T dato) {
        Nodo<T> newNodo = new Nodo(dato);
        if (primero == null) {
            primero = newNodo;
            tam++;
        } else {
            Nodo<T> actual = primero;
            while (actual.getProximo() != null) {
                actual = actual.getProximo();
            }
            actual.setProximo(newNodo);
            newNodo.setAnterior(actual);
            tam++;
        }
    }

    public void agregarEnPosicionEspecifica(T dato, int posicion) {

        if (posicion <= 0) { // si es posición 0 o negativa, agregar al inicio
            agregarPrimero(dato);
            return;
        }
        if (posicion >= tam) { // si es igual o mayor que el tamaño, agregar al final
            agregarUltimo(dato);
            return;
        }

        Nodo<T> nuevo = new Nodo<>(dato);
        Nodo<T> actual = primero;

        for (int i = 0; i < posicion - 1; i++) {
            actual = actual.getProximo();
        }

        Nodo<T> siguiente = actual.getProximo();

        nuevo.setProximo(siguiente);
        nuevo.setAnterior(actual);

        actual.setProximo(nuevo);
        if (siguiente != null) {
            siguiente.setAnterior(nuevo);
        }

        tam++;
    }

    public boolean esVacia(T datoBusqueda) {
        return primero == null && tam == 0;
    }

    public int localizar(T dato) {

        Nodo<T> actual = primero;
        int indexBusqueda = 0;

        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                return indexBusqueda;

            }
            indexBusqueda++;
            actual = actual.getProximo();

        }

        return -1;
    }

    public boolean buscar(T dato) {

        Nodo<T> actual = primero;
        boolean flag = false;

        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                flag = true;

            }
            actual = actual.getProximo();

        }

        return flag;
    }

    public boolean eliminar(T dato) {
        Nodo<T> actual = primero;

        if (actual.getDato().equals(dato)) {
            primero = actual.getProximo();
            tam--;
        } else {

            while (actual.getProximo() != null) {
                if (actual.getProximo().getDato().equals(dato)) {
                    actual.setProximo(actual.getProximo().getProximo());
                    tam--;
                    return true;
                }
                actual = actual.getProximo();
            }
        }
        return false;
    }

    // metodo para insercion de manera natural

    public void insercionNatural(T dato) {
        Nodo<T> nuevo = new Nodo(dato);

        if (primero == null || dato.compareTo(primero.getDato()) <= 0) {
            nuevo.setProximo(primero);
            primero = nuevo;
        } else {
            Nodo<T> actual = primero;
            while (actual.getProximo() != null && actual.getProximo().getDato().compareTo(dato) < 0) {
                actual = actual.getProximo();

            }

            nuevo.setProximo(actual.getProximo().getProximo());
            actual.setProximo(nuevo);

        }

        tam++;

    }

    public boolean eliminarEnPosicion(int posicion) {
        if (posicion < 0 || posicion >= tam) {
            return false; // posición fuera de rango
        }

        if (posicion == 0) {
            // eliminar primero
            primero = primero.getProximo();
            tam--;
            return true;
        }

        Nodo<T> actual = primero;
        for (int i = 0; i < posicion - 1; i++) {
            actual = actual.getProximo();
        }

        // actual está en el nodo anterior al que queremos eliminar
        actual.setProximo(actual.getProximo().getProximo());
        tam--;
        return true;
    }

    private void ordenarListaDoblementeEnlazada(Comparator<T> comp) {
        List<T> datos = new ArrayList<>();
        Nodo<T> actual = primero;
        while (actual != null) {
            datos.add(actual.getDato());
            actual = actual.getProximo();
        }
        datos.sort(comp);

        actual = primero;
        for (T dato : datos) {
            actual.setDato(dato);
            actual = actual.getProximo();
        }
    }

    public void ordenarNatural() {
        ordenarListaDoblementeEnlazada(Comparator.naturalOrder());
    }

    public void ordenarAscendente() {
        ordenarListaDoblementeEnlazada(Comparator.naturalOrder());
    }

    public void ordenarDescendente() {
        ordenarListaDoblementeEnlazada(Comparator.reverseOrder());
    }

}

public class DobleEnlazadaMain {

}
