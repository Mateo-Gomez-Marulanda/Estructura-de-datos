package com.example.Unidad2.Preparcial2.Punto3;

/*
 * Dada una Cola de Personas (nombre, edad, sexo), 
 * escribir un método que quite de la cola a los hombres cuya edad está entre los 30 y 50 años, 
 * los demás elementos de la Cola deben quedar en el mismo orden en el que estaban originalmente.
 */

class Persona {
    private String nombre;
    private int edad;
    private char sexo; // 'M' para masculino, 'F' para femenino

    public Persona(String nombre, int edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", sexo=" + sexo +
                '}';
    }
}

class Nodo {
    private Persona dato;
    private Nodo proximo;
    private Nodo anterior;

    public Nodo(Persona dato) {
        this.dato = dato;
        proximo = null;
        anterior = null;
    }

    public Persona getDato() {
        return dato;
    }

    public void setDato(Persona dato) {
        this.dato = dato;
    }

    public Nodo getProximo() {
        return proximo;
    }

    public void setProximo(Nodo proximo) {
        this.proximo = proximo;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return "Nodo{" +
                "dato=" + dato +
                ", anterior=" + anterior +
                ", proximo=" + proximo +
                '}';
    }
}

class Cola {

    private Nodo inicio;
    private Nodo fin;
    private int tam;

    public Cola() {
        inicio = null;
        fin = null;
        tam = 0;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public Nodo getFin() {
        return fin;
    }

    public void setFin(Nodo fin) {
        this.fin = fin;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public void encolar(Persona dato) {
        Nodo newNodo = new Nodo(dato);
        if (inicio == null) {
            inicio = fin = newNodo;
            tam++;
            return;
        }
        fin.setProximo(newNodo);
        fin = newNodo;
        tam++;
    }

    public Persona desencolar() {
        if (inicio == null) {
            return null;
        }

        Persona dato = inicio.getDato();
        inicio = inicio.getProximo();
        tam--;

        if (inicio == null) {
            fin = null;
        }

        return dato;
    }

    public void imprimirCola() {
        if (inicio == null) {
            System.out.println("La cola está vacía.");
            return;
        }

        Nodo actual = inicio;
        System.out.print("Cola: ");
        while (actual != null) {
            System.out.print(actual.getDato());
            if (actual.getProximo() != null) {
                System.out.print(" -> ");
            }
            actual = actual.getProximo();
        }
        System.out.println(" -> null");
    }

    public void eliminarHombresPorEdad() {

        Nodo actual = inicio;

        while (actual.getProximo() != null) {
            if (actual.getDato().getSexo() == 'M' && actual.getDato().getEdad() >= 30
                    && actual.getDato().getEdad() <= 50) {
                actual.setDato(actual.getProximo().getDato());
                actual.setProximo(actual.getProximo().getProximo());
            }
            actual = actual.getProximo();
        }
    }
}

public class Punto3 {
    public static void main(String[] args) {
        Cola cola = new Cola();

        cola.encolar(new Persona("Juan", 25, 'M'));
        cola.encolar(new Persona("Ana", 32, 'F'));
        cola.encolar(new Persona("Carlos", 45, 'M'));
        cola.encolar(new Persona("María", 29, 'F'));
        cola.encolar(new Persona("Luis", 51, 'M'));
        cola.encolar(new Persona("Sofía", 40, 'M'));

        System.out.println("Cola original:");
        cola.imprimirCola();

        cola.eliminarHombresPorEdad();

        System.out.println("Cola después de eliminar hombres entre 30 y 50 años:");
        cola.imprimirCola();
    }
}
