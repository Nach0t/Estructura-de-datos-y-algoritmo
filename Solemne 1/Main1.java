import java.util.Scanner;

public class Main1 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingrese la cantidad de números del vector: ");
    int n = scanner.nextInt();
    int[] array = new int[n]; // Inicialización del array

    for (int i = 0; i < n; i++) {
      System.out.println("Ingrese el número " + (i + 1) + ": ");
      array[i] = scanner.nextInt(); // Población del array
    }

    System.out.println("Suma no recursiva: " + sumNonRecursive(array));
    System.out.println("Suma recursiva: " + sumRecursive(array, 0));
  }

  // Método no recursivo para sumar elementos
  public static int sumNonRecursive(int[] array) {
    int sum = 0;
    for (int num : array) {
      sum += num;
    }
    return sum;
  }

  // Método recursivo para sumar elementos
  public static int sumRecursive(int[] array, int index) {
    if (index == array.length) {
      return 0;
    } else {
      return array[index] + sumRecursive(array, index + 1);
    }
  }
}
