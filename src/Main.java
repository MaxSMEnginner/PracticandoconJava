import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main m= new Main();
        System.out.println(m.division(1,0));
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