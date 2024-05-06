import java.util.Scanner;

public class Main {

  // Método para contar el número de maneras de formar n con las denominaciones en
  // L
  public static int countWays(int[] L, int m, int n) {
    if (n == 0) {
      return 1; // Si el valor es 0, hay exactamente una manera (no usar monedas)
    }
    if (n < 0) {
      return 0; // No se puede formar un número negativo
    }
    if (m <= 0 && n >= 1) {
      return 0; // Si no hay más monedas y n es mayor que 0, no es posible
    }

    // Contar el total de maneras considerando dos opciones:
    return countWays(L, m - 1, n) + countWays(L, m, n - L[m - 1]);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Ingrese la cantidad de denominaciones: ");
    int size = scanner.nextInt();

    if (size <= 0) {
      System.out.println("La cantidad de denominaciones debe ser positiva.");
      scanner.close();
      return;
    }

    int[] L = new int[size];

    System.out.println("Ingrese las denominaciones:");
    for (int i = 0; i < size; i++) {
      L[i] = scanner.nextInt();
    }

    System.out.print("Ingrese el valor para el cual quiere contar las maneras de formar: ");
    int n = scanner.nextInt();

    // Limitamos el valor objetivo para prevenir cálculos excesivamente grandes
    int maxValue = 1000; // Este es un límite arbitrario, puedes ajustarlo según tus necesidades
    if (n > maxValue) {
      System.out.println("El valor es demasiado grande para calcular.");
      scanner.close();
      return;
    }

    // Calcular el número de maneras
    int result = countWays(L, size, n);

    if (result == 0) {
      System.out.println("No es posible formar " + n + " con las denominaciones dadas.");
    } else {
      System.out.println("Número de maneras de formar " + n + " con las denominaciones dadas: " + result);
    }

    scanner.close();
  }
}
