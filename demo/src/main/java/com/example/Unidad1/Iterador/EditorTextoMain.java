package com.example.Unidad1.Iterador;
import java.util.Vector;

public class EditorTextoMain {

    // Vector para almacenar los cambios realizados
    private Vector<String> historialCambios;

    public EditorTextoMain() {
        historialCambios = new Vector<>();
    }

    // Registrar un nuevo cambio en el historial
    public void registrarCambio(String cambio) {
        historialCambios.add(cambio);
        System.out.println("Cambio registrado: " + cambio);
    }

    // Deshacer el último cambio realizado
    public void deshacerCambio() {
        if (!historialCambios.isEmpty()) {
            String cambioEliminado = historialCambios.remove(historialCambios.size() - 1);
            System.out.println("Se deshizo el cambio: " + cambioEliminado);
        } else {
            System.out.println("No hay cambios para deshacer.");
        }
    }

    // Mostrar historial de cambios actual
    public void mostrarHistorial() {
        System.out.println("Historial actual de cambios: " + historialCambios);
    }

    // Programa principal para prueba
    public static void main(String[] args) {
        EditorTextoMain editor = new EditorTextoMain();

        editor.registrarCambio("Se escribió 'Hola'");
        editor.registrarCambio("Se borró 'a'");
        editor.registrarCambio("Se agregó ' Mundo'");

        editor.mostrarHistorial();

        editor.deshacerCambio();
        editor.mostrarHistorial();

        editor.deshacerCambio();
        editor.mostrarHistorial();

        editor.deshacerCambio();
        editor.deshacerCambio();
    }
}
