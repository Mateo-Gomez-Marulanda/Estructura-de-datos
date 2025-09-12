package com.example.Unidad1.Iterador;

import java.util.Iterator;

class Biblioteca implements Iterable<Libro>{
    private Libro[] libros;
    private int indexLibro;

    public Biblioteca(int cantidadLibros) {
        this.indexLibro = 0;
        libros = new Libro[cantidadLibros];
    }
    public void agregarLibro(Libro newLibro){
        libros[indexLibro] = newLibro;
        indexLibro++;
    }
    public Libro obtenerLibro(int indexLibro){
        return libros[indexLibro];
    }
    public int size(){
        return indexLibro;
    }
    @Override
    public Iterator<Libro> iterator() {
        return new IteratorBiblioteca(this);
    }
}

class IteratorBiblioteca implements Iterator<Libro> {
    private Biblioteca biblioteca;
    private int index;

    public IteratorBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        index = 0;
    }
    @Override
    public boolean hasNext() {
        return index < biblioteca.size();
    }
    @Override
    public Libro next() {
        return biblioteca.obtenerLibro(index++);
    }
}

class Libro {
    private String nombre;

    public Libro(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}

public class BibliotecaMain {
    public static void main(String[] args) {
        Biblioteca newBiblioteca = new Biblioteca(5);
        newBiblioteca.agregarLibro(new Libro("Cien años de soledad."));
        newBiblioteca.agregarLibro(new Libro("El nombre del viento."));
        newBiblioteca.agregarLibro(new Libro("El arte de la guerra."));

        for (Libro libro : newBiblioteca){
            System.out.println(libro);
        }

        Iterator<Libro> iterator = newBiblioteca.iterator();

        while (iterator.hasNext()){
            Libro libro = iterator.next();
            System.out.println(libro);
        }
    }
}

// 315 4530677 asesorias
