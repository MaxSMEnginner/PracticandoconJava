import java.util.*;

public class Buscador {
    private String actual=null;
    private final Deque<String> anterior = new LinkedList<>();
    private final Deque<String> adelante = new LinkedList<>();


    public void  checar(){
        if (actual == null){
            System.out.println("No a navegado");
        }else{
            System.out.println("Checar Actual: "+actual);
            if (!anterior.isEmpty()) System.out.println("Checar Anterior: "+anterior);
            if (!adelante.isEmpty()) System.out.println("Checar Adelante: "+adelante);
        }
    }

    public void visitar(String url){
        if (actual!=null) anterior.push(actual);
        actual=url;
        adelante.clear();


    }

    public void atras(){
        if (anterior.isEmpty()){ System.out.println("No tenemos mas busquedas");}else{
            adelante.push(actual);
            actual=anterior.peek();
            System.out.println("Actual--> "+ actual);
            System.out.println("Adelante--> "+ adelante.peek());
            anterior.pollFirst();
            if (!anterior.isEmpty()) System.out.println("Anterior--> "+anterior.peek());
        }

    }

    public void frente(){
//        [1,2,3]
        if (adelante.isEmpty()){
            System.out.println("No hay mas paginas adelante");
        }else{
            anterior.push(actual);
            actual=adelante.pollFirst();
            System.out.println("Actual<--"+ actual);
            if (!adelante.isEmpty())System.out.println("Adelante<-- "+ adelante.peek());
            System.out.println("Anterior<-- "+anterior.peek());
        }
    }



    public static void main(String[] args){
        Buscador b = new Buscador();
        b.visitar("google.com");
        b.checar();
        b.visitar("google2.com");
        b.visitar("google3.com");
        b.atras();
        b.atras();
        b.frente();
        b.frente();
        b.frente();
    }
}
