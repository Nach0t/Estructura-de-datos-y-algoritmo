/*
  Creación: 07-05-2024
  Última modificación: [fecha de última modificación]
  
  Integrantes:
  - Ignacio Rehbein
  - Claucio Diaz
  
  Curso: Estructura de Datos y Algoritmos
  
  Descripción:
  Este archivo implementa el codigo 1 del Taller 1 de la unidad 1 del curso de
  Estructura de Datos y Algoritmos.
*/

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

  // Método recursivo para encontrar todas las combinaciones para formar n
  // utilizando solo los elementos de L
  public static void findCombinations(
      // lista anilada
      List<List<Integer>> allCombinations,
      // lista normal
      List<Integer> currentCombination,
      int[] L,
      int start,
      int n) {
    if (n == 0) {
      // Si hemos formado el valor deseado, agregamos la combinación actual a la lista
      // de combinaciones
      allCombinations.add(new ArrayList<>(currentCombination));
      return;
    }
    if (n < 0) {
      return; // Si el valor es negativo, esta combinación no es válida
    }

    // Recorremos las denominaciones desde la posición actual
    for (int i = start; i < L.length; i++) {
      currentCombination.add(L[i]);
      findCombinations(allCombinations, currentCombination, L, i, n - L[i]);
      currentCombination.remove(currentCombination.size() - 1); // Eliminamos el último elemento
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int size = 0;

    // Validación para obtener un número positivo para la cantidad de denominaciones
    while (true) {
      try {
        System.out.print("Ingrese la cantidad de denominaciones: ");
        size = scanner.nextInt();
        if (size <= 0) {
          throw new IllegalArgumentException("La cantidad de denominaciones debe ser positiva.");
        }
        break; // Si es válido, salimos del bucle
      } catch (InputMismatchException e) {
        System.out.println("Por favor ingrese un número entero.");
        scanner.next(); // Limpiar el buffer
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }

    int[] L = new int[size];

    // Validación para obtener las denominaciones
    System.out.println("Ingrese las denominaciones:");
    for (int i = 0; i < size; i++) {
      while (true) {
        try {
          System.out.printf("Ingresa número %d: ", i + 1);
          L[i] = scanner.nextInt();
          break; // Si es válido, salimos del bucle interno
        } catch (InputMismatchException e) {
          System.out.println("Por favor ingrese un número entero.");
          scanner.next(); // Limpiar el buffer
        }
      }
    }

    // Construcción de un mensaje con las denominaciones ingresadas
    StringBuilder denominaciones = new StringBuilder();
    for (int i = 0; i < size; i++) {
      denominaciones.append(L[i]);
      if (i < size - 1) {
        denominaciones.append(", ");
      }
    }

    int n = 0;
    // Validación para obtener el valor a formar, con mensaje personalizado
    while (true) {
      try {
        System.out.printf("¿Qué número quieres formar usando las denominaciones %s? ", denominaciones.toString());
        n = scanner.nextInt();
        if (n <= 0) {
          throw new IllegalArgumentException("El valor debe ser positivo.");
        }
        break; // Si es válido, salimos del bucle
      } catch (InputMismatchException e) {
        System.out.println("Por favor ingrese un número entero.");
        scanner.next(); // Limpiar el buffer
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }

    List<List<Integer>> allCombinations = new ArrayList<>();
    findCombinations(allCombinations, new ArrayList<>(), L, 0, n);

    if (allCombinations.isEmpty()) {
      System.out.println("No es posible formar " + n + " con las denominaciones dadas.");
    } else {
      System.out
          .println("Número de maneras de formar " + n + " con las denominaciones dadas: " + allCombinations.size());
      System.out.println("Combinaciones posibles:");
      for (List<Integer> combination : allCombinations) {
        System.out.println(combination);
      }
    }

    scanner.close();
  }
}
