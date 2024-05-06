import java.util.Scanner;

public class Main2 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Ingrese un número entero N: ");
    int n = scanner.nextInt();

    System.out.println("Posibles descomposiciones de " + n + ":");
    descomposiciones(n, "");
  }

  public static void descomposiciones(int n, String descomp) {
    // Si n es cero, se alcanzó el final de una descomposición válida
    if (n == 0) {
      System.out.println(descomp.trim());
      return;
    }

    // Recorremos desde 1 hasta el número actual n
    for (int i = 1; i <= n; i++) {
      // manejo de error
      if (i > n) {
        break;
      }
      // Llamada recursiva restando el valor actual y agregándolo a la descomposición
      String nuevaDescomp = descomp.isEmpty()
          ? n + " = " + i
          : descomp + " + " + i;

      descomposiciones(n - i, nuevaDescomp);

    }
  }
}
