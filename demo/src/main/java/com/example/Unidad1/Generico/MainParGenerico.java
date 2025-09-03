/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Unidad1.Generico;

/**
 *
 * @author Mateo
 */

class ParEntero{
    private int a, b; 

    public ParEntero(int a, int b) {
        this.a = a;
        this.b = b;
   }
    
    public ParEntero swap(){
        return new ParEntero(b,a);
    }
}


class ParEnteroGenerico<E> {
    private E a,b;

    public ParEnteroGenerico(E a, E b) {
        this.a = a;
        this.b = b;
    }
    
    public ParEnteroGenerico<E> swap(){
        return new ParEnteroGenerico<E>(b,a);
    }
} 

public class MainParGenerico {
     public static void main (String[] args){
         var par = new ParEnteroGenerico<>(1,3);
         System.out.println( par.swap());
         
         ParEntero parEntero = new ParEntero(2,3);
         System.out.println( parEntero.swap());
     }    
}
