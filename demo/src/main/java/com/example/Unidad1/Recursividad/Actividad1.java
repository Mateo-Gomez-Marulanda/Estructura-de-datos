package com.example.Unidad1.Recursividad;

/*
 *3.Contar números pares en un arreglo
 Dado un arreglo de enteros, determine cuántos elementos son pares utilizando Divide y Vencerás.

 tipos de recusividad usadas en este caso: recursividad multiple
 */
public class Actividad1 {

    public static int contarPares(int[] arr, int inicio, int fin) {
        // Caso base
        if (inicio == fin) {
            if (arr[inicio] % 2 == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        // metodo para hallar el punto medio del arreglo para poder dividirlo en partes
        // pequeñas
        int medio = (inicio + fin) / 2;

        // contar pares en la mitad izquierda
        int izquierda = contarPares(arr, inicio, medio);

        // contar pares en la mitad derecha
        int derecha = contarPares(arr, medio + 1, fin);

        // juntar resultados
        return izquierda + derecha;
    }

    public static void main(String[] args) {
        int[] arreglo = {2, 7, 8, 3, 10};

        int resultado = contarPares(arreglo, 0, arreglo.length - 1);

        System.out.println("Cantidad de números pares: " + resultado);
    }
}
