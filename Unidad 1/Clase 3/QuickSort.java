import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce los números separados por comas: ");
        String[] numeros = scanner.nextLine().split(",");
        int[] arr = new int[numeros.length];
        for (int i = 0; i < numeros.length; i++) {
            arr[i] = Integer.parseInt(numeros[i]);
        }
        // Se mueve la impresión del arreglo original fuera del bucle
        System.out.println("Array original: " + Arrays.toString(arr));
        quicksort(arr, 0, arr.length - 1);
        System.out.println("Array ordenado: " + Arrays.toString(arr));
    }

    public static void quicksort(int[] arr, int bajo, int alto) {
        if (bajo < alto) {
            int indicePivote = particion(arr, bajo, alto);
            quicksort(arr, bajo, indicePivote - 1);
            quicksort(arr, indicePivote + 1, alto);
        }
    }

    public static int particion(int[] arr, int bajo, int alto) {
        int pivote = arr[alto];
        int i = (bajo - 1);
        for (int j = bajo; j < alto; j++) {
            if (arr[j] < pivote) {
                i++;
                intercambiar(arr, i, j);
            }
        }
        intercambiar(arr, i + 1, alto);
        return i + 1;
    }

    public static void intercambiar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
