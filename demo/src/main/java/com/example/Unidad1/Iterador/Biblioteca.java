package com.example.Unidad1.Iterador;

public class Biblioteca implements Iterable<Libro> {

    private int cantidadLibros;

    public Biblioteca(int cantidadLibros) {
        this.cantidadLibros = cantidadLibros;
    }

    public void agregarLibro(Libro newLibro) {

    }
}

class Libro implements Comparable<Libro> {

    private String nombre;
    private int isbn;

    public Libro(String nombre, int isbn) {
        this.nombre = nombre;
        this.isbn = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Libro [nombre: " + nombre + ", isbn: " + isbn + "]";
    }

}

class IteratorBiblioteca implements Iterator<Libro> {

    private Biblioteca biblioteca;
    private int index;

    public IteratorBiblioteca(Biblioteca biblioteca, int index) {
        this.biblioteca = biblioteca;
        this.index = 0;
    }

}

class Main {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(5);

    }
}

// 315 4530677 asesorias
