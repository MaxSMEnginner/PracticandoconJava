import java.util.Scanner;

public class CalculadoraProject {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Caluculadoras ca =new Caluculadoras();


        int opcion;
        do {
            System.out.println("\n=== MENÚ ===");
            System.out.println("1) Calculadora aritmética");
            System.out.println("2) Calculadora lógica");
            System.out.println("3) Salir");
            System.out.print("Elige: ");
            opcion = leerEnteroSeguro();

            switch (opcion) {
                case 1 -> ca.CalculadoraAritmetica();
                case 2 -> ca.CalculadoraLogica();
                case 3 -> System.out.println("¡Adiós!");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 3);

        sc.close();
    }

    private static int leerEnteroSeguro() {
        while (!sc.hasNextInt()) {
            System.out.print("Ingresa un número válido: ");
            sc.next();
        }
        return sc.nextInt();
    }
}
