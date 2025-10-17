package com.example.Unidad2.Preparcial2.Punto8;

import java.util.Stack;

public class StackReverse {

    public static Stack<Integer> reverseStack(Stack<Integer> s, int i, int j) {
        if (i < 0 || j > s.size() || i >= j) {
            throw new IllegalArgumentException("Invalid indices");
        }
        Stack<Integer> tempStack = new Stack<>();
        Stack<Integer> auxStack = new Stack<>();

        int n = s.size();
        for (int k = 0; k < n; k++) {
            int element = s.pop();
            if (k >= i && k < j) {
                auxStack.push(element);
            } else {
                tempStack.push(element);
            }
        }

        while (!auxStack.isEmpty()) {
            s.push(auxStack.pop());
        }

        while (!tempStack.isEmpty()) {
            s.push(tempStack.pop());
        }

        return s;
    }

    public static void main(String[] args) {

        /*
         * Realizar la prueba de escritorio e imprimir el resultado final
         * 
         * - como la pregunta era analisar el codigo actual y ver cual es su resultado
         */
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        Stack<Integer> reversed = reverseStack(s, 1, 4);

        System.out.println("Stack after reversing sequence: " + reversed);
    }
}
