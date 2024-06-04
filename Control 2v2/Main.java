import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArbolBinarioBusqueda arbol = null;
    ArbolAVL arbolAVL = null;
    boolean esAVL = false;

    System.out.println("Seleccione el tipo de árbol (1: BST/ABL, 2: AVL): ");
    int eleccion = scanner.nextInt();

    if (eleccion == 1) {
      arbol = new ArbolBinarioBusqueda();
    } else if (eleccion == 2) {
      arbolAVL = new ArbolAVL();
      esAVL = true;
    } else {
      System.out.println("Selección inválida.");
      return;
    }

    ArbolBinarioBusqueda arbolFinal = esAVL ? arbolAVL : arbol;
    JFrame frame = new JFrame("Visualización del Árbol");
    GraficoArbol grafico = new GraficoArbol(arbolFinal);
    frame.add(grafico);
    frame.setSize(800, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

    while (true) {
      System.out.println(
          "\nOperaciones: 1. Insertar 2. Eliminar 3. Altura 4. Cantidad de nodos 5. Recorrer in-order 6. Recorrer pre-order 7. Recorrer post-order 8. Mínimo 9. Máximo 10. Salir");
      int operacion = scanner.nextInt();

      switch (operacion) {
        case 1:
          System.out.println("Ingrese el valor a insertar: ");
          int valorInsertar = scanner.nextInt();
          if (esAVL)
            arbolAVL.insertar(valorInsertar);
          else
            arbol.insertar(valorInsertar);
          grafico.actualizar();
          break;
        case 2:
          System.out.println("Ingrese el valor a eliminar: ");
          int valorEliminar = scanner.nextInt();
          if (esAVL)
            arbolAVL.eliminar(valorEliminar);
          else
            arbol.eliminar(valorEliminar);
          grafico.actualizar();
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
          int minValor = esAVL ? arbolAVL.minValue(arbolAVL.raiz) : arbol.minValue(arbol.raiz);
          System.out.println("Valor mínimo: " + minValor);
          break;
        case 9:
          int maxValor = esAVL ? arbolAVL.maxValue(arbolAVL.raiz) : arbol.maxValue(arbol.raiz);
          System.out.println("Valor máximo: " + maxValor);
          break;
        case 10:
          System.exit(0);
        default:
          System.out.println("Operación no válida.");
      }
    }
  }
}
