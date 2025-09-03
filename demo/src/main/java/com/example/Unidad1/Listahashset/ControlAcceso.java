package com.example.Unidad1.Listahashset;

import java.util.HashSet;

public class ControlAcceso {

    public static void main(String[] args) {
        HashSet<String> empleados = new HashSet<>();

        String[] codigos = {"EMP001", "EMP002", "EMP003", "EMP001", "EMP004"};

        for (String codigo : codigos) {
            if (empleados.add(codigo)) {
                System.out.println("Acceso permitido: " + codigo);
            } else {
                System.out.println("Acceso denegado (duplicado): " + codigo);
            }
        }
    }
}
