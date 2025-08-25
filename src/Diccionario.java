import java.util.HashMap;

public class Diccionario {
    HashMap<String,String> diccionario = new HashMap<>(){{
        put("manzana","apple");
        put("mama","mom");
    }
    };

//    public String traduciresping(String palabra){
//        if (diccionario.containsKey(palabra)){
//            return diccionario.get(palabra);
//        }else{
//            return "No se encuentra";
//        }
//    }
    public String traduciresping(String palabra){
        return diccionario.getOrDefault(palabra, "No se encuentra");
    }


    public void agregar(String esp, String eng){
        diccionario.put(esp, eng);
    }


    public void mostrarDiccionario(){
        for (String clave : diccionario.keySet()){
            System.out.printf("%s -> %s%n", clave, diccionario.get(clave));
        }
    }


    public static void main(String[] args){
        Diccionario d= new Diccionario();
        System.out.println(d.traduciresping(""));

    }
}
