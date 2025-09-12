/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Unidad1.Generico;

import java.util.Collections;
import java.util.LinkedList;

class Producto implements Comparable<Producto> {
    private String id;
    private String nombre;

    public Producto(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public int compareTo(Producto o) {
        return this.id.compareTo(o.id);
        // return Integer.compare(x,y);
    }
}

interface IAlmacenable<T extends Comparable<T>> {
    void guardar(T producto);

    T maximo();

}

class Almacen implements IAlmacenable<Producto> {
    LinkedList<Producto> listProductos = new LinkedList<>();

    public Almacen() {
    }

    @Override
    public void guardar(Producto producto) {
        listProductos.add(producto);
    }

    @Override
    public Producto maximo() {
        // Opcion 1
        Collections.sort(listProductos);
        return listProductos.getLast();

        // Opcion 2
        // Producto max = listProductos.get(0);
        // for (Producto producto : listProductos) {
        // if (max.compareTo(producto) < 0){
        // max = producto;
        // }
        // }
        // return max;
    }
}

/**
 *
 * @author Mateo
 */
public class ElementoAlmacenadoMain {

}
