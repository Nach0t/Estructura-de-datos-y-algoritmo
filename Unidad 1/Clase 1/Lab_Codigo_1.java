import java.util.Scanner;

public class Lab_Codigo_1 {

    //no recursiva
    public static int multiplicacionNoRecursiva(int a, int b) {
        int resultado = 0;
        for (int i = 0; i < b; i++) {
            resultado += a;
        }
        return resultado;
    }

    //recursiva
    public static int multiplicacionRecursiva(int a, int b) {
        if (b == 0) {
            return 0;
        } else if (b < 0) {
            return -multiplicacionRecursiva(a, -b);
        } else {
            return a + multiplicacionRecursiva(a, b - 1);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el valor de a: ");
        int a = scanner.nextInt();

        System.out.println("Ingrese el valor de b: ");
        int b = scanner.nextInt();


        System.out.println("Multiplicación no recursiva: " + multiplicacionNoRecursiva(a, b));
        System.out.println("Multiplicación recursiva: " + multiplicacionRecursiva(a, b));
    }
}