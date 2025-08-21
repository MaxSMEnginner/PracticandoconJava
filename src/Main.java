import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Caluculadoras ca =new Caluculadoras();
        ca.CalculadoraLogica();

//        int opcion;
//        do {
//            System.out.println("\n=== MENÚ ===");
//            System.out.println("1) Calculadora aritmética");
//            System.out.println("2) Calculadora lógica");
//            System.out.println("3) Comparador relacional");
//            System.out.println("4) Salir");
//            System.out.print("Elige: ");
//            opcion = leerEnteroSeguro();
//
//            switch (opcion) {
//                case 1 ->
//                case 2 ->
//                case 3 ->
//                case 4 -> System.out.println("¡Adiós!");
//                default -> System.out.println("Opción inválida.");
//            }
//        } while (opcion != 4);
//
//        sc.close();
    }

    private static int leerEnteroSeguro() {
        while (!sc.hasNextInt()) {
            System.out.print("Ingresa un número válido: ");
            sc.next();
        }
        return sc.nextInt();
    }
}