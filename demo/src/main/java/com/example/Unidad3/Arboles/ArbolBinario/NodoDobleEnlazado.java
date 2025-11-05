package com.example.Unidad3.Arboles.ArbolBinario;

public class NodoDobleEnlazado<T> {
    private T dato;
    private NodoDobleEnlazado<T> izquierdo;
    private NodoDobleEnlazado<T> derecho;

    public NodoDobleEnlazado(T dato) {
        this.dato = dato;
        izquierdo = null; // Null inicialmente ya que no referencia a nada antes de estar en la lista
        derecho = null;
    }

    public T getValor() {
        return dato;
    }

    public void setValor(T dato) {
        this.dato = dato;
    }

    public NodoDobleEnlazado<T> getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoDobleEnlazado<T> izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoDobleEnlazado<T> getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoDobleEnlazado<T> derecho) {
        this.derecho = derecho;

    }

    @Override
    public String toString() {
        return "Nodo{" +
                "dato=" + dato + ", derecho=" + derecho +
                ", izquierdo=" + izquierdo +
                '}';
    }
}
