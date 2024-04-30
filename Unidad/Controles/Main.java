import java.util.ArrayList;
import java.util.List;

public class Main {
  // Método recursivo para encontrar todas las particiones de un número entero
  public static void imprimirParticiones(int n, List<Integer> particion) {
    // Si n es 0, hemos encontrado una partición completa
    if (n == 0) {
      // Imprimimos la partición actual
      System.out.println(particion);
      return;
    }

    // Comenzar desde el número más grande que podemos usar hasta 1
    for (int i = 1; i <= n; i++) {
      // Crear una nueva partición con el nuevo valor
      List<Integer> nuevaParticion = new ArrayList<>(particion);
      nuevaParticion.add(i);

      // Llamar recursivamente con el valor restante
      imprimirParticiones(n - i, nuevaParticion);
    }
  }

  public static void main(String[] args) {
    int n = 4; // Cambia este valor para probar con otros números
    List<Integer> particionInicial = new ArrayList<>();
    imprimirParticiones(n, particionInicial);
  }
}
