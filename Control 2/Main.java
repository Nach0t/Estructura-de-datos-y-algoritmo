import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Árbol Binario de Búsqueda");
    ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();
    GraficoArbol graficoArbol = new GraficoArbol(arbol);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(graficoArbol);
    frame.setSize(800, 600);
    frame.setVisible(true);

    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("Ingrese una opción: (1) Agregar, (2) Eliminar, (3) Mostrar Preorden, (4) Salir");
      int opcion = scanner.nextInt();
      switch (opcion) {
        case 1:
          System.out.println("Ingrese el valor a agregar:");
          int valorAgregar = scanner.nextInt();
          arbol.agregar(valorAgregar);
          graficoArbol.actualizar();
          break;
        case 2:
          System.out.println("Ingrese el valor a eliminar:");
          int valorEliminar = scanner.nextInt();
          arbol.eliminar(valorEliminar);
          graficoArbol.actualizar();
          break;
        case 3:
          System.out.println("Árbol en preorden:");
          arbol.preorden();
          System.out.println();
          break;
        case 4:
          System.exit(0);
        default:
          System.out.println("Opción no válida.");
      }
    }
  }
}
