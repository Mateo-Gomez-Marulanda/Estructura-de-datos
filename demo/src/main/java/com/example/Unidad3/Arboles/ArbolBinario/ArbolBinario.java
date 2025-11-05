package com.example.Unidad3.Arboles.ArbolBinario;

/*
 * criterio de busqueda:
 * 1> es nulo
 * 2> la raiz coincide con la busqueda
 * 3> es lo que buscamos?
 * 3> es mayor o menor a la raiz 
 * 4> se elije antes o despues, y se va por un lado u otro 
 * 5> repetir
*/
public class ArbolBinario<T extends Comparable<T>> {
    private NodoDobleEnlazado<T> raiz;

    public void insertarOrdenado(T valor) {
        NodoDobleEnlazado<T> newNodo = new NodoDobleEnlazado<>(valor);
        if (raiz == null) {
            raiz = newNodo;
        } else {
            insertarOrdenadoR(valor, raiz);
        }
    }

    public void insertarOrdenadoR(T valor, NodoDobleEnlazado<T> actual) {
        if (valor.equals(actual.getValor())) {
            System.out.print("no se puenden repetidos");
        } else if (valor.compareTo(actual.getValor()) > 0) {
            if (actual.getIzquierdo() == null) {
                NodoDobleEnlazado<T> valorNodo = new NodoDobleEnlazado<>(valor);
                actual.setIzquierdo(valorNodo);
            } else {
                actual = actual.getIzquierdo();
                insertarOrdenadoR(valor, actual);
            }
        } else {
            if (actual.getDerecho() == null) {
                NodoDobleEnlazado<T> valorNodo = new NodoDobleEnlazado<>(valor);
                actual.setDerecho(valorNodo);
            } else {
                actual = actual.getDerecho();
                insertarOrdenadoR(valor, actual);
            }
        }
    }

    public boolean existP(T valor) {
        if (raiz == null) {
            return false;
        } else {
            return exist(valor, raiz);
        }
    }

    public boolean exist(T valor, NodoDobleEnlazado<T> actual) {
        if (actual.getValor().equals(valor)) {
            return true;
        } else if (valor.compareTo(actual.getValor()) > 0) {
            if (actual.getIzquierdo() == null) {
                return false;
            } else {
                actual = actual.getIzquierdo();
                return exist(valor, actual);
            }
        } else {
            if (actual.getDerecho() == null) {
                return false;
            } else {
                actual = actual.getDerecho();
                return exist(valor, actual);
            }
        }
    }

    public void recorrerInOrden() {
        if (raiz == null) {
            System.out.println("El árbol está vacío.");
        } else {
            recorrerInOrdenR(raiz);
            System.out.println(); // salto de línea al final
        }
    }

    private void recorrerInOrdenR(NodoDobleEnlazado<T> actual) {
        if (actual != null) {
            recorrerInOrdenR(actual.getDerecho()); // Recorre el subárbol izquierdo
            System.out.print(actual.getValor() + " "); // Muestra el valor del nodo actual
            recorrerInOrdenR(actual.getIzquierdo()); // Recorre el subárbol derecho
        }
    }

    public void recorrerPreOrden() {
        if (raiz == null) {
            System.out.println("El árbol está vacío.");
        } else {
            recorrerPreOrdenR(raiz);
            System.out.println();
        }
    }

    private void recorrerPreOrdenR(NodoDobleEnlazado<T> actual) {
        if (actual != null) {
            System.out.print(actual.getValor() + " "); // actual
            recorrerPreOrdenR(actual.getDerecho()); // izquierda
            recorrerPreOrdenR(actual.getIzquierdo()); // derecha
        }
    }

    public void recorrerPostOrden() {
        if (raiz == null) {
            System.out.println("El árbol está vacío.");
        } else {
            recorrerPostOrdenR(raiz);
            System.out.println();
        }
    }

    private void recorrerPostOrdenR(NodoDobleEnlazado<T> actual) {
        if (actual != null) {
            recorrerPostOrdenR(actual.getDerecho()); // izquierda
            recorrerPostOrdenR(actual.getIzquierdo()); // derecha
            System.out.print(actual.getValor() + " "); // actual
        }
    }

    public int peso() {
        return pesoArbol(raiz);
    }

    public int pesoArbol(NodoDobleEnlazado<T> actual) {

        if (actual == null) {
            return 0;
        } else {
            int pesoIzquierda = pesoArbol(actual.getIzquierdo());
            int pesoDerecha = pesoArbol(actual.getDerecho());

            return 1 + pesoIzquierda + pesoDerecha;
        }
    }
}