import java.util.Scanner;

public class Codigo_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fac = 0;

        while (fac >= 1) {
            System.out.println(
                    "Ingrese el número del que desea calcular el factorial (Ingrese un número menor que 1 para salir): ");
            fac = scanner.nextInt();

            if (fac < 1) {
                break; // Salir del bucle si el número ingresado es menor que 1
            }

            int fac2 = 1;
            for (int i = 1; i <= fac; i++) {
                fac2 *= i;
            }
            System.out.println("El factorial de " + fac + " es: " + fac2);
        }

        System.out.println("El programa ha terminado.");
    }
}
