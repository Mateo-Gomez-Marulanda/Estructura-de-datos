/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mateo
 */

class Libro {

    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;
    private int ISBN;

    public Libro(String titulo, String autor, LocalDate fechaPublicacion, int ISBN) {
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "Libro{" + "titulo: " + titulo + ", autor: " + autor + ", fechaPublicacion: " + fechaPublicacion + ", ISBN: " + ISBN + '}';
    }
    
    
}

class BibliotecaDigital {
    private List<Libro> libros = new ArrayList<>();
    
    public void eliminarLibroISBN (int ISBN){
        for(Libro libro : libros){
            if(libro.getISBN() == ISBN ){
                libros.remove(libro);
            } 
        }
    }
    
    public void agregarLibroISBN (int ISBN){
        for(Libro libro : libros){
            if(libro.getISBN() == ISBN ){
                libros.add(libro);
            } 
        }
    }
    
    public void buscarLibroAutor (String autor){
        for(Libro libro : libros){
            if(libro.getAutor() == autor ){
                libros.toString();
            } 
        }
    }
}

public class Biblioteca {
    
}
