import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Ingrese un número entero N: ");
    int n = scanner.nextInt();

    System.out.println("Posibles descomposiciones de " + n + ":");
    descomposiciones(n, n, new ArrayList<>());
  }

  public static void descomposiciones(int n, int original, List<Integer> lista) {
    // Si n es cero, se alcanzó el final de una descomposición válida
    if (n == 0) {
      imprimirDescomposicion(lista, original);
      return;
    }

    // Recorremos desde 1 hasta el número actual n
    for (int i = 1; i <= n; i++) {
      // Llamada recursiva restando el valor actual y agregándolo a la lista
      List<Integer> nuevaLista = new ArrayList<>(lista);
      nuevaLista.add(i);
      descomposiciones(n - i, original, nuevaLista);
    }
  }

  public static void imprimirDescomposicion(List<Integer> lista, int original) {
    System.out.print(original + " = "); // Indica el número original
    for (int i = 0; i < lista.size(); i++) {
      System.out.print(lista.get(i));
      if (i < lista.size() - 1) {
        System.out.print(" + ");
      }
    }
    System.out.println(); // Salto de línea después de imprimir la descomposición
  }
}
