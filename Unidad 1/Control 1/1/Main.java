/*
  Creación: 07-05-2024
  Última modificación: [fecha de última modificación]
  
  Integrantes:
  - Ignacio Rehbein
  - Claucio Diaz
  
  Curso: Estructura de Datos y Algoritmos
  
  Descripción:
  Este archivo implementa el codigo 2 del Taller 1 de la unidad 1 del curso de
  Estructura de Datos y Algoritmos.
*/

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = 0;

    // Verificación del ingreso de un número entero
    while (true) {
      System.out.print("Ingrese un número entero N: ");
      try {
        n = scanner.nextInt();
        if (n <= 0) {
          System.out.println("Por favor ingrese un número entero positivo.");
          continue; // Si el número es negativo o cero, se pide nuevamente
        }
        break; // Si se ingresó un número entero positivo, se rompe el bucle
      } catch (InputMismatchException e) {
        System.out.println("Entrada inválida. Por favor ingrese un número entero.");
        scanner.next(); // Limpiar el buffer para evitar un bucle infinito
      }
    }

    System.out.println("Posibles descomposiciones de " + n + ":");
    descomposiciones(n, n, new ArrayList<>());
  }

  // Funcion de recursividad
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
