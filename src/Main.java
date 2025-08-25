import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main m= new Main();
//        m.filabanco();
        Deque<String> dq = new ArrayDeque<>();

        // Como COLA (FIFO)
        dq.offerLast("A");
        dq.offerLast("B");
        dq.offerLast("C");
        System.out.println("FIFO pollFirst: " + dq.pollFirst()); // A
        System.out.println("FIFO peekFirst: " + dq.peekFirst()); // B
        System.out.println("Deque: " + dq);
        // Como PILA (LIFO)
        dq.clear();
        System.out.println("Deque: " + dq);
        dq.push("A");
        System.out.println("Deque: " + dq);
        dq.push("B");
        System.out.println("Deque: " + dq);
        dq.push("C");
        System.out.println("Deque: " + dq);
        System.out.println("LIFO pop: " + dq.pop()); // C
        System.out.println("Deque: " + dq);
        System.out.println("LIFO peek: " + dq.peek());// B (≡ peekFirst)
        System.out.println("Deque: " + dq);

    }

/*
* 🧩 Ejercicios para practicar

List: crea una lista de palabras, ordénala alfabéticamente y elimina duplicados.

Set: guarda nombres en un HashSet y muestra cuántos únicos hay.

Queue: simula una fila de clientes en un banco (poll() para atender).

Deque: implementa un historial de navegación (puedes ir atrás y adelante).

Map: crea un diccionario español-inglés con HashMap y busca traducciones.

TreeMap: guarda productos y precios, que se muestren ordenados por nombre.

EnumSet: crea un conjunto de permisos (LEER, ESCRIBIR, EJECUTAR) y revisa si un permiso existe.
* */
    public List<String> listas(){
        /*
List: crea una lista de palabras, ordénala alfabéticamente y elimina duplicados.*/
        List<String> lista= new ArrayList<>();
        lista.addAll(Arrays.asList("Python", "Java", "C++", "Python","Java", "C++"," C#"));
        Collections.sort(lista);
        //C++,C#, Java,Python
        List<String> lsd = new ArrayList<>();

        for(int i=0;i < lista.size();i++){
            if (!(lsd.contains(lista.get(i)))){
                lsd.add(lista.get(i));
            }

        }
        return lsd;
    }

    public List<String> listas2(){
        List<String> lista = new ArrayList<>(Arrays.asList("Python", "Java", "C++", "Python", "Java", "C++", "C#"));
        Set<String> lsd = new TreeSet<>(lista);

        return new ArrayList<>(lsd);
    }


    public List<String> listas3(){
        List<String> lista = new ArrayList<>(Arrays.asList("Python", "Java", "C++", "Python", "Java", "C++", "C#"));
        return lista.stream().distinct().sorted().toList();
    }


    public int nameunico(){
        /*
Set: guarda nombres en un HashSet y muestra cuántos únicos hay.*/
        HashSet<String> names= new HashSet<>(Arrays.asList("Maximiliano","Maria","Michelle","Alejandro","Maximiliano","Alejandro"));

        System.out.printf("Nombres Unicos: %s%n", names);
        return names.size();
    }

    public void filabanco(){
        /*Queue: simula una fila de clientes en un banco (poll() para atender).*/
        Queue<String> fila= new LinkedList<>(Arrays.asList("Maria","Nath","Sobreviviente","Maximiliano"));
        for(int i=0;!fila.isEmpty();i++){
            System.out.println("Turno: "+ fila.poll());
            if (!(fila.peek() == null)){
                System.out.println("Siguiente: "+ fila.peek());
            }else{
                System.out.println("Ya no hay mas gente en la fila");
            }

        }
    }

    public void filabanco2(){
        Queue<String> fila= new LinkedList<>(Arrays.asList("Maria","Nath","Sobreviviente","Maximiliano"));

        while(!fila.isEmpty()){
            System.out.println("Turno: "+ fila.poll());
            if (!(fila.peek() == null)){
                System.out.println("Siguiente: "+ fila.peek());
            }else{
                System.out.println("Ya no hay mas gente en la fila");
            }
        }
    }






      /*
  * Ejercicios para practicar

Crea un método0 que pida un número por consola y capture la excepción si el usuario escribe letras. (InputMismatchException).

Implementa un método0 division(int a, int b) que lance un IllegalArgumentException si b == 0.

Usa finally para cerrar un Scanner después de leer datos, aunque ocurra un error.*/
    public void metodo1(){
        try{
            Scanner sc = new Scanner(System.in);
            System.out.print("Escribe un numero: ");
            int numero= sc.nextInt();
        }catch (InputMismatchException e){
            System.out.printf("Error: %s%n", e.getMessage());
        }finally {
            System.out.println("Metodo1 Finalizado.");
        }

    }

    public int division(int a, int b){
        if (b == 0){
            throw new IllegalArgumentException("No se puede dividir entre 0");
        }
        return a/b;
    }


}