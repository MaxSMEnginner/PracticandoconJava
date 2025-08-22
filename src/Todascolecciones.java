import java.util.*;

public class Todascolecciones {
    public static void main(String[] args) {
        // List
        List<String> lista = new ArrayList<>();
        lista.add("A"); lista.add("B"); lista.add("A"); // permite duplicados
        System.out.println("List: " + lista);

        // Set
        Set<String> conjunto = new HashSet<>();
        conjunto.add("A"); conjunto.add("B"); conjunto.add("A"); // ignora duplicado
        System.out.println("Set: " + conjunto);

        // Queue
        Queue<Integer> cola = new LinkedList<>();
        cola.add(1); cola.add(2); cola.add(3);
        System.out.println("Queue poll: " + cola.poll());// saca el primero
        System.out.println("Queue poll: " + cola.poll());
        System.out.println("Queue poll: " + cola.poll());

        // Deque
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(10); deque.addLast(20); deque.add(12);deque.addFirst(20);deque.addLast(45);
        System.out.println("Deque: " + deque);

        // Map
        Map<String,Integer> mapa = new HashMap<>();
        mapa.put("Uno", 1); mapa.put("Dos", 2);
        System.out.println("Map: " + mapa);
    }
}