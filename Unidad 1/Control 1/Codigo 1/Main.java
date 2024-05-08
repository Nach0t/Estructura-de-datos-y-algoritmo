/*
  Creación: 07-05-2024
  
  Integrantes:
  - Ignacio Rehbein
  - Claucio Diaz
  
  Curso: Estructura de Datos y Algoritmos
  
  Descripción:
  Este archivo implementa el código 2 del Taller 1 de la unidad 1 del curso de
  Estructura de Datos y Algoritmos.
*/

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    int numeroDescomposiciones = 0;

    // Verificación del ingreso de un número entero
    while (true) {
      System.out.print("Ingrese un número entero positivo: ");
      try {
        numeroDescomposiciones = entrada.nextInt();
        if (numeroDescomposiciones <= 0) {
          System.out.println("Por favor, ingrese un número positivo.");
          continue; // Si el número es negativo o cero, se pide nuevamente
        }
        break; // Si se ingresó un número entero positivo, se rompe el bucle
      } catch (InputMismatchException e) {
        System.out.println("Entrada no válida. Ingrese un número entero.");
        entrada.next(); // Limpiar el buffer para evitar un bucle infinito
      }
    }

    System.out.println("Posibles descomposiciones de " + numeroDescomposiciones + ":");
    descomponer(numeroDescomposiciones, numeroDescomposiciones, new ArrayList<>());
  }

  // Función recursiva para descomponer un número
  public static void descomponer(int valor, int valorOriginal, List<Integer> combinacionActual) {
    // Si `valor` es cero, se alcanzó el final de una descomposición válida
    if (valor == 0) {
      imprimirDescomposicion(combinacionActual, valorOriginal);
      return;
    }

    // Recorremos desde 1 hasta el número actual
    for (int i = 1; i <= valor; i++) {
      // Llamada recursiva restando el valor actual y agregándolo a la combinación
      // actual
      List<Integer> nuevaCombinacion = new ArrayList<>(combinacionActual);
      nuevaCombinacion.add(i);
      descomponer(valor - i, valorOriginal, nuevaCombinacion);
    }
  }

  public static void imprimirDescomposicion(List<Integer> combinacion, int valorOriginal) {
    System.out.print(valorOriginal + " = "); // Indica el número original
    for (int i = 0; i < combinacion.size(); i++) {
      System.out.print(combinacion.get(i));
      if (i < combinacion.size() - 1) {
        System.out.print(" + ");
      }
    }
    System.out.println(); // Salto de línea después de imprimir la descomposición
  }
}
