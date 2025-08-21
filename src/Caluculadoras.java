import java.util.Scanner;

public class Caluculadoras {
    Scanner sc= new Scanner(System.in);
    public void CalculadoraAritmetica(){
        boolean seguir=true;
        while(seguir){
            System.out.print("Ingresa el primer numero: ");
            double a= sc.nextDouble();
            System.out.print("Ingresa el segundo numero: ");
            double b= sc.nextDouble();

            char c;


            System.out.print("Que operacion quieres hacer? *,/,+,-: ");
            c = sc.next().charAt(0);
            switch (c){
                case '*':
                    System.out.printf("Multiplicacion: %.2f%n",(a*b));
                    break;
                case '/':
                    if(b!=0){
                        System.out.printf("Division: %.2f%n",(a/b));
                    }else{
                        System.out.println("Division: infinito");
                    }
                    break;
                case '+':
                    System.out.printf("Suma: %.2f%n",(a+b));
                    break;
                case '-':
                    System.out.printf("Resta: %.2f%n",(a-b));
                    break;
                default:
                    System.out.println("Opcion Invalida");
                    break;
            }
            System.out.print("Quieres volver a hacer otra operacion(true o false)?: ");
            seguir= sc.nextBoolean();
        }
        System.out.println("Adios");

    }

    public void CalculadoraLogica(){
        boolean seguir=true;
        while(seguir){
            System.out.print("Ingresa A(true/false): ");
            boolean a= sc.nextBoolean();
            System.out.print("Ingresa B(true/false): ");
            boolean b= sc.nextBoolean();
            String c;
            System.out.print("Operación (AND, OR, NOT): ");
            c = sc.next().toUpperCase();
            switch (c){
                case "AND":
                    System.out.printf("A && B: %b%n",(a&&b));
                    System.out.printf("A & B: %b%n",(a&b));
                    break;
                case "OR":
                    System.out.printf("A || B: %b%n",(a||b));
                    System.out.printf("A | B: %b%n",(a|b));
                    break;
                case "NOT":
                    System.out.printf("!A: %b%n",(!a));
                    System.out.printf("!B: %b%n",(!b));
                    break;
                default:
                    System.out.println("Opcion Invalida");
                    break;
            }
            System.out.print("Quieres repetirlo(true o false)?: ");
            seguir= sc.nextBoolean();
        }
        System.out.println("Adios");
    }


}
