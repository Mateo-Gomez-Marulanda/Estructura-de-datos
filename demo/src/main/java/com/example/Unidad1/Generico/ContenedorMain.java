package com.example.Unidad1.Generico;

import java.util.LinkedList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mateo
 */

class Item {
    private String nombre;

    public Item(String nombre) {
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
        return "Item{" + "nombre=" + nombre + '}';
    }
}

interface IContenedor<T extends Comparable<T>>{
    void agregar(T item);
    void obtener(int index);
}

class ListaContenerdor<T> implements IContenedor {
    LinkedList listaItems = new LinkedList<>();
    
    
    @Override
    public void agregar(Item item){
        listaItems.add(item);
    }
    
    @Override
    
}

public class ContenedorMain {
    public static void main (String[] argd){
        
    }
}
