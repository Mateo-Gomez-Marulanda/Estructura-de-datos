package com.example.Unidad1.Generico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InvertirListaMain {
    
    public static <T>  List<T> invertirLista(List<T> lista){
        List<T> invertida = new ArrayList<>(lista);
        Collections.reverse(invertida);
        return invertida;
    
    }

    public static void main(String[] args) {
        List<String> lista = List.of("toño","manolo", "sapo perro");
        System.out.println(invertirLista(lista));

    }
}
