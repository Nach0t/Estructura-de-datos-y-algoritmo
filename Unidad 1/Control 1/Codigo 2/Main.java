/*
  Creación: 07-05-2024
  
  Integrantes:
  - Ignacio Rehbein
  - Claucio Diaz
  
  Curso: Estructura de Datos y Algoritmos
  
  Descripción:
  Este archivo implementa el código 1 del Taller 1 de la unidad 1 del curso de
  Estructura de Datos y Algoritmos.
*/

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

  // Método recursivo para encontrar todas las combinaciones para formar un número
  // utilizando solo los elementos de la lista de denominaciones
  public static void encontrarCombinaciones(
      // Lista anidada para almacenar todas las combinaciones posibles
      List<List<Integer>> todasLasCombinaciones,
      // Lista temporal para mantener la combinación actual
      List<Integer> combinacionActual,
      int[] denominaciones,
      int indiceInicio,
      int objetivo) {
    if (objetivo == 0) {
      // Si hemos alcanzado el valor objetivo, agregamos la combinación actual a la
      // lista
      todasLasCombinaciones.add(new ArrayList<>(combinacionActual));
      return;
    }
    if (objetivo < 0) {
      // Si el valor es negativo, esta combinación no es válida
      return;
    }

    // Recorremos las denominaciones desde la posición actual
    for (int i = indiceInicio; i < denominaciones.length; i++) {
      combinacionActual.add(denominaciones[i]);
      encontrarCombinaciones(todasLasCombinaciones, combinacionActual, denominaciones, i, objetivo - denominaciones[i]);
      combinacionActual.remove(combinacionActual.size() - 1); // Eliminamos el último elemento
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int cantidadDenominaciones = 0;

    // Validación para obtener un número positivo para la cantidad de denominaciones
    while (true) {
      try {
        System.out.print("Ingrese la cantidad de denominaciones: ");
        cantidadDenominaciones = scanner.nextInt();
        if (cantidadDenominaciones <= 0) {
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

    int[] denominaciones = new int[cantidadDenominaciones];

    // Validación para obtener las denominaciones
    System.out.println("Ingrese las denominaciones:");
    for (int i = 0; i < cantidadDenominaciones; i++) {
      while (true) {
        try {
          System.out.printf("Ingrese la denominación %d: ", i + 1);
          denominaciones[i] = scanner.nextInt();
          break; // Si es válido, salimos del bucle interno
        } catch (InputMismatchException e) {
          System.out.println("Por favor ingrese un número entero.");
          scanner.next(); // Limpiar el buffer
        }
      }
    }

    StringBuilder denominacionesString = new StringBuilder();
    for (int i = 0; i < cantidadDenominaciones; i++) {
      denominacionesString.append(denominaciones[i]);
      if (i < cantidadDenominaciones - 1) {
        // Corrección: usar `denominacionesString`
        denominacionesString.append(", ");
      }
    }

    int objetivo = 0;
    // Validación para obtener el valor a formar, con mensaje personalizado
    while (true) {
      try {
        System.out.printf("¿Qué número quieres formar usando las denominaciones %s? ", denominacionesString.toString());
        objetivo = scanner.nextInt();
        if (objetivo <= 0) {
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

    // Encuentra todas las combinaciones para formar el número objetivo
    List<List<Integer>> todasLasCombinaciones = new ArrayList<>();
    encontrarCombinaciones(todasLasCombinaciones, new ArrayList<>(), denominaciones, 0, objetivo);

    if (todasLasCombinaciones.isEmpty()) {
      System.out.println("No es posible formar " + objetivo + " con las denominaciones dadas.");
    } else {
      System.out.println(
          "Número de maneras de formar " + objetivo + " con las denominaciones dadas: " + todasLasCombinaciones.size());
      System.out.println("Combinaciones posibles:");
      for (List<Integer> combinacion : todasLasCombinaciones) {
        System.out.println(combinacion);
      }
    }

    scanner.close();
  }
}
