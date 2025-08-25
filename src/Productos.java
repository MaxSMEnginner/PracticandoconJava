import java.util.TreeMap;

public class Productos {
    private final TreeMap<String,Double> catalogo= new TreeMap<>();

    public void guardar_producto(String producuto, Double precio){
        catalogo.put(producuto,precio);
        System.out.println("Producto Agregado con exito.");
//        System.out.println("Producto: "+ producuto);
//        System.out.println("Precio: "+precio);
    }

    public void mostrar_producto(){
        System.out.println("---PRODUCTOS---");
        for(String producto: catalogo.keySet()){
            System.out.printf("Producto: %s ----> $%f MXN%n",producto, catalogo.get(producto));
        }
    }


    public static void main(String[] args){
        Productos p= new Productos();
        p.guardar_producto("Manzana", 8.99);
        p.guardar_producto("Man2zana", 81.99);
        p.guardar_producto("Manz3ana", 83.99);
        p.mostrar_producto();
    }
}
