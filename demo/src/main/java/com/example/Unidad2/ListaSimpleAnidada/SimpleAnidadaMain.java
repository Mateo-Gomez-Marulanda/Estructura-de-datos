package com.example.Unidad2.ListaSimpleAnidada;

class Nodo {
    private int dato;
    private Nodo proximo; // Referencia al siguiente elemento

    public Nodo(int dato) {
        this.dato = dato;
        proximo = null; // Null inicialmente ya que no referencia a nada antes de estar en la lista
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
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
        return "Nodo{" +
                "dato=" + dato +
                ", proximo=" + proximo +
                '}';
    }
}

class ListaSimpleEnlazada {
    private Nodo primero;
    private int tam;

    public ListaSimpleEnlazada() {
        primero = null;
        tam = 0;
    }

    public void agregarPrimero(Nodo newNodo) {
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
        Nodo actual = primero;
        String mensaje = "[";
        do {
            mensaje += actual.getDato() + " ";
            actual = actual.getProximo();
        } while (actual != null);

        mensaje += "]";
        System.out.println(mensaje);
    }
}

public class SimpleAnidadaMain {
    public static void main(String[] args) {
        ListaSimpleEnlazada lista = new ListaSimpleEnlazada();

        Nodo test = new Nodo(8);
        lista.agregarPrimero(new Nodo(5));
        lista.agregarPrimero(new Nodo(6));
        lista.agregarPrimero(new Nodo(7));
        lista.agregarPrimero(test);

        lista.mostrar();
        System.out.println(test.toString());

    }
}
