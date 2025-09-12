package com.example.Unidad1.Recursividad;

class InversionMatriz {
    // sin recursividad
    public int[][] invertirMatriz(int[][] matriz) {
        int fila = matriz.length;
        int columna = matriz[0].length;

        int[][] matrizInvertida = new int[fila][columna];

        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[f].length; c++) {
                matrizInvertida[c][f] = matriz[f][c];
            }
        }
        return matrizInvertida;
    }

    public void imprimirMatriz(int[][] matriz) {
        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[f].length; c++) {

                System.out.print(matriz[f][c] + "");
            }
        }
        System.out.println();
    }
}

class InversionMatrizRecursiva {

    // Método recursivo que llena la matriz invertida
    public void invertirMatriz(int[][] original, int[][] invertida, int fila, int columna) {
        // Caso base: si ya pasamos la última fila, terminamos
        if (fila == original.length) {
            return;
        }

        // Si llegamos al final de la fila, pasamos a la siguiente fila
        if (columna == original[fila].length) {
            invertirMatriz(original, invertida, fila + 1, 0);
            return;
        }

        // Paso recursivo: copiar valor invertido
        invertida[columna][fila] = original[fila][columna];

        // Avanzar a la siguiente columna
        invertirMatriz(original, invertida, fila, columna + 1);
    }

    // Método para imprimir la matriz
    public void imprimirMatriz(int[][] matriz, int fila, int columna) {
        // Caso base: terminamos todas las filas
        if (fila == matriz.length) {
            return;
        }

        // Caso base de la fila: si terminamos las columnas, salto de línea y pasamos a
        // la siguiente fila
        if (columna == matriz[fila].length) {
            System.out.println();
            imprimirMatriz(matriz, fila + 1, 0);
            return;
        }

        // Imprimir el elemento actual
        System.out.print(matriz[fila][columna] + " ");

        // Paso recursivo: siguiente columna
        imprimirMatriz(matriz, fila, columna + 1);
    }
}

public class MatrizInverzaMain {
    public static void main(String[] args) {

        
        InversionMatriz inversionMatriz = new InversionMatriz();

        int[][] matriz = new int[2][2];

        matriz[0][0] = 1;
        matriz[0][1] = 2;
        matriz[1][0] = 3;
        matriz[1][1] = 4;

        System.out.println("matriz transpuesta sin recursividad");

        inversionMatriz.imprimirMatriz(matriz);
        System.out.println();
        int[][] matrizInvertida = inversionMatriz.invertirMatriz(matriz);
        inversionMatriz.imprimirMatriz(matrizInvertida);



        InversionMatrizRecursiva inversionMatrizRecursiva = new InversionMatrizRecursiva();

        // Crear la nueva matriz invertida con dimensiones volteadas
        int[][] matrizInvertida2 = new int[matriz[0].length][matriz.length];

         System.out.println("matriz transpuesta con recursividad");
        
        // Llamada recursiva para invertir
        inversionMatrizRecursiva.invertirMatriz(matriz, matrizInvertida2, 0, 0);

        System.out.println("\nMatriz invertida:");
        inversionMatrizRecursiva.imprimirMatriz(matrizInvertida2, 0, 0);
    }
}
