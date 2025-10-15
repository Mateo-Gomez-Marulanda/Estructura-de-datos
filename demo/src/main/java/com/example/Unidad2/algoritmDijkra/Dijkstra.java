
// Paquete del proyecto
package com.example.Unidad2.algoritmDijkra;


// Importa todas las utilidades de Java (listas, mapas, colas, etc.)
import java.util.*;


// Clase para representar una arista (conexión entre dos nodos del grafo)
class Edge {
    String destino; // Nodo destino de la arista
    int peso;       // Peso o costo de la arista

    Edge(String destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }
}


// Clase para representar un pedido de entrega
class Pedido {
    String destino;   // Ciudad destino del pedido
    int prioridad;    // Prioridad del pedido (menor número = más urgente)

    Pedido(String destino, int prioridad) {
        this.destino = destino;
        this.prioridad = prioridad;
    }
}


// Clase principal que implementa el algoritmo de Dijkstra y simula la entrega de pedidos
public class Dijkstra {

    // Grafo representado como un mapa: ciudad -> lista de aristas (conexiones)
    private static Map<String, List<Edge>> grafo = new HashMap<>();

    // Método para agregar una arista bidireccional entre dos ciudades
    static void agregarArista(String origen, String destino, int peso) {
        grafo.putIfAbsent(origen, new ArrayList<>()); // Si no existe la ciudad, la agrega
        grafo.putIfAbsent(destino, new ArrayList<>());
        grafo.get(origen).add(new Edge(destino, peso)); // Agrega la arista de origen a destino
        grafo.get(destino).add(new Edge(origen, peso)); // Agrega la arista de destino a origen
    }

    // Implementación del algoritmo de Dijkstra para encontrar la distancia mínima desde un nodo de inicio
    static Map<String, Integer> dijkstra(String inicio) {
        Map<String, Integer> dist = new HashMap<>(); // Mapa para almacenar la distancia mínima a cada nodo
        for (String nodo : grafo.keySet())
            dist.put(nodo, Integer.MAX_VALUE); // Inicializa todas las distancias como infinito
        dist.put(inicio, 0); // La distancia al nodo de inicio es 0

        // Cola de prioridad para seleccionar el nodo con menor distancia conocida
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                Map.Entry.comparingByValue());
        pq.add(new AbstractMap.SimpleEntry<>(inicio, 0));

        while (!pq.isEmpty()) {
            String actual = pq.poll().getKey(); // Extrae el nodo con menor distancia

            // Recorre las aristas del nodo actual
            for (Edge e : grafo.get(actual)) {
                int nuevaDist = dist.get(actual) + e.peso; // Calcula la nueva distancia
                // Si la nueva distancia es menor, actualiza y agrega a la cola
                if (nuevaDist < dist.get(e.destino)) {
                    dist.put(e.destino, nuevaDist);
                    pq.add(new AbstractMap.SimpleEntry<>(e.destino, nuevaDist));
                }
            }
        }
        return dist; // Devuelve el mapa de distancias mínimas
    }

    // Método principal: simula la entrega de pedidos según prioridad y rutas más cortas
    public static void main(String[] args) {
        // Construcción del grafo (mapa de ciudades y distancias)
        agregarArista("Base", "A", 4); // Base ↔ A (4 km)
        agregarArista("Base", "B", 2); // Base ↔ B (2 km)
        agregarArista("A", "C", 3);   // A ↔ C (3 km)
        agregarArista("B", "C", 1);   // B ↔ C (1 km)
        agregarArista("C", "D", 5);   // C ↔ D (5 km)

        // Lista de pedidos a entregar, cada uno con su prioridad
        List<Pedido> pedidos = Arrays.asList(
                new Pedido("C", 1), // Pedido más urgente
                new Pedido("A", 2),
                new Pedido("D", 3));

        // Ordena los pedidos por prioridad (de menor a mayor)
        pedidos.sort(Comparator.comparingInt(p -> p.prioridad));

        String ubicacionActual = "Base"; // El vehículo parte desde la base

        // Recorre los pedidos en orden de prioridad
        for (Pedido p : pedidos) {
            // Calcula las distancias mínimas desde la ubicación actual
            Map<String, Integer> distancias = dijkstra(ubicacionActual);
            int distancia = distancias.get(p.destino); // Obtiene la distancia al destino del pedido
            // Imprime la ruta y la prioridad del pedido
            System.out.println("🚚 De " + ubicacionActual + " → " + p.destino +
                    " (Prioridad " + p.prioridad + ") = " + distancia + " km");
            ubicacionActual = p.destino; // El vehículo se mueve al nuevo punto
        }
    }
}
