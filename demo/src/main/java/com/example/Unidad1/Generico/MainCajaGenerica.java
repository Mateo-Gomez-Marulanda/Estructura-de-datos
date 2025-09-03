/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Unidad1.Generico;

/**
 *
 * @author Mateo
 */
class CajaNormal {
    private int numero;

    public CajaNormal(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}

class CajaGenerica<E>{
    private E elemento;

    public CajaGenerica(E elemento) {
        this.elemento = elemento;
    }

    public E getElemento() {
        return elemento;
    }

    public void setElemento(E elemento) {
        this.elemento = elemento;
    }
}

public class MainCajaGenerica {
    public static void main (String[] args){
        CajaGenerica<String> cajaGenerica = new CajaGenerica<>("juanito");
        System.out.println(cajaGenerica.getElemento());
    } 
}

