/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Unidad1.Generico;

import java.util.LinkedList;

class Producto implements Comparable<Producto> {
    private String nombre;
    private String id;

    public Producto(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Producto{" + "nombre: " + nombre + ", id: " + id + '}';
    }
}

interface IAlmacenable<T extends Comparable <T>> {
    void guardar (T producto);
    T maximo();
    
}

class Almacen implements IAlmacenable<Producto>{
    LinkedList<Producto> listaProductos = new LinkedList<>();
    
    @Override
    public void guardar (Producto producto){
        listaProductos.add(producto);
    }
    
    @Override
    public Producto maximo(){
        Producto max = listaProductos.get(0);
        for(Producto producto : listaProductos){
            if(max.compareTo(producto) < 0){
                max = producto;
            }
        }
        return max;
    }
}

/**
 *
 * @author Mateo
 */
public class ElementoAlmacenadoMain {
    
}
