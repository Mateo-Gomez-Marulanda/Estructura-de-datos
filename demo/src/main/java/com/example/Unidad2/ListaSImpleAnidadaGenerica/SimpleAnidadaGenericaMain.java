package com.example.Unidad2.ListaSImpleAnidadaGenerica;

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
}

class ListaSimpleEnlazada<T> {
    private Nodo<T> primero;
    private int tam;

    public ListaSimpleEnlazada() {
        primero = null;
        tam = 0;
    }

    public void agregarPrimero(T dato) {
        Nodo<T> newNodo = new Nodo<>(dato);

        if (primero == null) {
            primero = newNodo;
            tam++;
        } else {
            newNodo.setProximo(primero);
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
        Nodo<T> newNodo = new Nodo<>(dato);
        if (primero == null) {
            primero = newNodo;
            tam++;
        } else {
            Nodo<T> actual = primero;
            while (actual.getProximo() != null) {
                actual = actual.getProximo();
            }
            actual.setProximo(newNodo);
            tam++;
        }
    }

    public void agregarPosicion(T dato, int posicion) {
        Nodo<T> newNodo = new Nodo<>(dato);
        if (primero == null) {
            primero = newNodo;
            tam++;
        } else {
            if (posicion == tam) {
                agregarUltimo(dato);
            } else {
                Nodo<T> actual = primero;
                for (int i = 0; i < tam; i++) {
                    if (i == posicion) {
                        actual.getProximo();
                    }
                }
                actual.setProximo(newNodo);
                tam++;
            }
        }
    }
}

public class SimpleAnidadaGenericaMain {
    public static void main(String[] args) {
        ListaSimpleEnlazada<String> lista = new ListaSimpleEnlazada<>();

        /*
         * lista.agregarPrimero("una lista");
         * lista.agregarPrimero("desde");
         * lista.agregarPrimero("A todos");
         */

        // lista.agregarPrimero(" Hola");

        lista.agregarPosicion("mondongo", 1);
        lista.agregarPosicion("azucar", 3);
        lista.agregarPosicion("pulido", 2);

        lista.mostrar();
    }
}
