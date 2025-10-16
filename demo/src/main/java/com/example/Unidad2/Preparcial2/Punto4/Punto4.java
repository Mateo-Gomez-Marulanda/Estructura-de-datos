package com.example.Unidad2.Preparcial2.Punto4;

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

    public Integer convercionDecimalBinario(Integer dato) {

        if (dato < 0) {
            throw new IllegalArgumentException("El numero debe ser positivo");
        }

        while (dato > 0) {
            int residuo = dato % 2;
            empilar(residuo);
            dato = dato / 2;
        }

        StringBuilder binario = new StringBuilder();
        while (!estaVacia()) {
            binario.append(desempilar());
        }

        return Integer.parseInt(binario.toString());
    }
}

public class Punto4 {
    /*
     * Escriba un método que lea un número entero positivo e imprima su
     * representación binaria,
     * use pilas o colas. El método debe retornar un entero.
     * 
     * -como recomendacion personal es mejor usar pilas por su logica LiFo
     */
    public static void main(String[] args) {
        Pila pila = new Pila();
        System.out.println("El numero en binario es: " + pila.convercionDecimalBinario(10));
    }
}
