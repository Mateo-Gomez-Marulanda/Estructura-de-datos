package com.example.Unidad1.Recursividad;

class MultiplicacionRecursiva {
    public static int multiplicacion(int[] numeros, int inicio, int fin){
        if(inicio == fin){
            return numeros[inicio];
        }

        int mitad = (inicio+fin)/2;
        int mitad1 = multiplicacion(numeros, inicio, mitad);
        int mitad2 = multiplicacion(numeros, mitad+1, fin);

        return mitad1*mitad2;
    }
}

public class MultiplicarRecursivoMain {
    public static void main(String[] args) {
        int[] listaNumeros = {1,2,3,4,5,6,7};

        int multiplicacion = MultiplicacionRecursiva.multiplicacion(listaNumeros, 0, listaNumeros.length-1);
        System.out.println(multiplicacion);
    }
}
