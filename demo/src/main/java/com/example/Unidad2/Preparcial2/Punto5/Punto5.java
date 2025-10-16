package com.example.Unidad2.Preparcial2.Punto5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Nodo {
    private char dato;
    private Nodo proximo;

    public Nodo(char dato) {
        this.dato = dato;
        proximo = null;
    }

    public char getDato() {
        return dato;
    }

    public void setDato(char dato) {
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

    public void empilar(char dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.setProximo(cima);
        cima = nuevo;
        tam++;
    }

    public Character desempilar() {
        if (estaVacia()) {
            return null;
        }
        char dato = cima.getDato();
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

    private void ordenarPila(Comparator<Character> comp) {
        List<Character> datos = new ArrayList<>();
        Nodo actual = cima;
        while (actual != null) {
            datos.add(actual.getDato());
            actual = actual.getProximo();
        }

        datos.sort(comp);

        actual = cima;
        for (char dato : datos) {
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

    public boolean verificarParentesis() {
        Nodo actual = cima;
        int cantidadAbierto = 0;
        int cantidadCerrado = 0;

        boolean flag = false;

        while (actual != null) {
            if (actual.getDato() == '(') {
                cantidadAbierto++;
            } else if (actual.getDato() == ')') {
                cantidadCerrado++;
            }
            actual = actual.getProximo();
        }

        if (cantidadAbierto == cantidadCerrado) {
            flag = true;
        }
        return flag;
    }

    public boolean verificarLlaves() {
        Nodo actual = cima;
        int cantidadAbierto = 0;
        int cantidadCerrado = 0;

        boolean flag = false;

        while (actual != null) {
            if (actual.getDato() == '{') {
                cantidadAbierto++;
            } else if (actual.getDato() == '}') {
                cantidadCerrado++;
            }
            actual = actual.getProximo();
        }

        if (cantidadAbierto == cantidadCerrado) {
            flag = true;
        }
        return flag;
    }

    public boolean verificarCorchetes() {
        Nodo actual = cima;
        int cantidadAbierto = 0;
        int cantidadCerrado = 0;

        boolean flag = false;

        while (actual != null) {
            if (actual.getDato() == '[') {
                cantidadAbierto++;
            } else if (actual.getDato() == ']') {
                cantidadCerrado++;
            }
            actual = actual.getProximo();
        }

        if (cantidadAbierto == cantidadCerrado) {
            flag = true;
        }
        return flag;
    }

    public boolean verficarCadenaBalanceada(String cadena) {
        boolean flag = false;

        for (int i = 0; i < cadena.length(); i++) {
            char letra = cadena.charAt(i);
            empilar(letra);

        }
        if (verificarLlaves() == true && verificarCorchetes() == true && verificarParentesis() == true) {
            flag = true;
        }
        return flag;
    }
}

public class Punto5 {
    /*
     * Escriba un método que reciba como parámetro una cadena de caracteres y que
     * usando una Pila determine si sus paréntesis, llaves y corchetes están
     * balanceados. Debe retornar un boolean. Ejemplo: “(6-7)/4]” está mala.
     * “[(1+2)*4]+5” está bien
     */

    public static void main(String[] args) {
        Pila pila = new Pila();
        String cadena = "{[(1+2)*4]+5}";
        System.out.println("Cadena: " + cadena);
        System.out.println("¿Está balanceada? " + pila.verficarCadenaBalanceada(cadena));
    }
}
