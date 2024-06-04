import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

// Clase principal que maneja la entrada y salida del programa
public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // Crear un árbol binario de búsqueda o AVL dependiendo de la elección del
    // usuario
    ArbolBinarioBusqueda arbol = null;
    ArbolAVL arbolAVL = null;
    boolean esAVL = false;

    while (true) {
      System.out.println("Seleccione el tipo de árbol (1: BST/ABL, 2: AVL): ");
      try {
        int eleccion = scanner.nextInt();
        if (eleccion == 1) {
          arbol = new ArbolBinarioBusqueda();
          break;
        } else if (eleccion == 2) {
          arbolAVL = new ArbolAVL();
          esAVL = true;
          break;
        } else {
          System.out.println("Selección inválida. Por favor, ingrese 1 para BST/ABL o 2 para AVL.");
        }
      } catch (Exception e) {
        System.out.println("Entrada no válida. Por favor, ingrese un número válido.");
        scanner.nextLine(); // Limpiar el buffer del scanner
      }
    }

    ArbolBinarioBusqueda arbolFinal = esAVL ? arbolAVL : arbol;
    JFrame frame = new JFrame("Árbol");
    GraficoArbol grafico = new GraficoArbol(arbolFinal);
    frame.add(grafico);
    frame.setSize(650, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

    while (true) {
      System.out.println(
          "\n1. Insertar\n2. Eliminar\n3. Altura\n4. Cantidad de nodos\n5. Recorrer in-order\n6. Recorrer pre-order\n7. Recorrer post-order\n8. Mínimo\n9. Máximo\n10. volver al menú\n 11. Salir\nOperacion: ");
      int operacion;
      try {
        operacion = scanner.nextInt();
      } catch (Exception e) {
        System.out.println("Entrada no válida. Por favor, ingrese un número válido.");
        scanner.nextLine(); // Limpiar el buffer del scanner
        continue;
      }

      switch (operacion) {
        case 1:
          try {
            System.out.println("Ingrese el valor a insertar: ");
            int valorInsertar = scanner.nextInt();
            if (esAVL)
              arbolAVL.insertar(valorInsertar);
            else
              arbol.insertar(valorInsertar);
            grafico.actualizar();
          } catch (Exception e) {
            System.out.println("Entrada no válida. Por favor, ingrese un número entero válido.");
            scanner.nextLine(); // Limpiar el buffer del scanner
          }
          break;
        case 2:
          try {
            System.out.println("Ingrese el valor a eliminar: ");
            int valorEliminar = scanner.nextInt();
            if (esAVL) {
              if (arbolAVL.buscar(arbolAVL.raiz, valorEliminar) == null) {
                System.out.println("El número no está presente en el árbol AVL.");
              } else {
                arbolAVL.eliminar(valorEliminar);
                grafico.actualizar();
              }
            } else {
              if (arbol.buscar(arbol.raiz, valorEliminar) == null) {
                System.out.println("El número no está presente en el árbol BST/ABL.");
              } else {
                arbol.eliminar(valorEliminar);
                grafico.actualizar();
              }
            }
          } catch (Exception e) {
            System.out.println("Entrada no válida. Por favor, ingrese un número entero válido.");
            scanner.nextLine(); // Limpiar el buffer del scanner
          }
          break;
        case 3:
          int altura = esAVL ? arbolAVL.altura(arbolAVL.raiz) : arbol.altura(arbol.raiz);
          System.out.println("Altura del árbol: " + altura);
          break;
        case 4:
          int cantidadNodos = esAVL ? arbolAVL.contarNodos(arbolAVL.raiz) : arbol.contarNodos(arbol.raiz);
          System.out.println("Cantidad de nodos: " + cantidadNodos);
          break;
        case 5:
          System.out.print("Recorrido in-order: ");
          if (esAVL)
            arbolAVL.recorridoInOrder(arbolAVL.raiz);
          else
            arbol.recorridoInOrder(arbol.raiz);
          System.out.println();
          break;
        case 6:
          System.out.print("Recorrido pre-order: ");
          if (esAVL)
            arbolAVL.recorridoPreOrder(arbolAVL.raiz);
          else
            arbol.recorridoPreOrder(arbol.raiz);
          System.out.println();
          break;
        case 7:
          System.out.print("Recorrido post-order: ");
          if (esAVL)
            arbolAVL.recorridoPostOrder(arbolAVL.raiz);
          else
            arbol.recorridoPostOrder(arbol.raiz);
          System.out.println();
          break;
        case 8:
          if (esAVL) {
            if (arbolAVL.raiz == null) {
              System.out.println("No hay valores en el árbol AVL.");
            } else {
              int minValor = arbolAVL.minValue(arbolAVL.raiz);
              System.out.println("Valor mínimo: " + minValor);
            }
          } else {
            if (arbol.raiz == null) {
              System.out.println("No hay valores en el árbol BST/ABL.");
            } else {
              int minValor = arbol.minValue(arbol.raiz);
              System.out.println("Valor mínimo: " + minValor);
            }
          }
          break;
        case 9:
          if (esAVL) {
            if (arbolAVL.raiz == null) {
              System.out.println("No hay valores en el árbol AVL.");
            } else {
              int maxValor = arbolAVL.maxValue(arbolAVL.raiz);
              System.out.println("Valor máximo: " + maxValor);
            }
          } else {
            if (arbol.raiz == null) {
              System.out.println("No hay valores en el árbol BST/ABL.");
            } else {
              int maxValor = arbol.maxValue(arbol.raiz);
              System.out.println("Valor máximo: " + maxValor);
            }
          }
          break;
        case 10:
          System.out.println("Volviendo al menú principal.");
          break; // c: ta dificil hacerlo xD
        case 11:
          System.out.println("Saliendo del programa, hasta luego.");
          System.exit(0);
        default:
          System.out.println("Operación no válida.");
      }
    }
  }
}
