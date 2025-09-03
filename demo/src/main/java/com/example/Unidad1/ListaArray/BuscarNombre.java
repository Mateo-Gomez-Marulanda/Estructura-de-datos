package com.example.Unidad1.ListaArray;

/* en este ejercicio se busca acceder a una posicion en una lista en base a su posicion */

import java.util.ArrayList;
import java.util.List;

class Usuario {

    private List<String> usuarios = new ArrayList<>();

    public void buscarUsuario(int index) {

        /* metodo usuarios.get(index) sirve para acceder a la posicion de un array list en base a su posicion indiacada en el index */
        System.out.println(usuarios.get(index));
    }

    public void agregarNombre(String nombre) {
        usuarios.add(nombre);
    }
}

public class BuscarNombre {

    public static void main(String[] args) {
        Usuario nombres = new Usuario();
        nombres.agregarNombre("pepe");
        nombres.agregarNombre("null");
        nombres.buscarUsuario(0);

    }
}
