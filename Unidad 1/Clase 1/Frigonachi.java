import java.util.ArrayList;
import java.util.Scanner;

public class Frigonachi {

    public static ArrayList<Integer> fibonacci(int n) {
        ArrayList<Integer> fibonacciSeq = new ArrayList< >();
        fibonacciSeq.add(0);
        fibonacciSeq.add(1);
        
        for (int i = 2; i < n; i++) {
            int nextNum = fibonacciSeq.get(i - 1) + fibonacciSeq.get(i - 2);
            fibonacciSeq.add(nextNum);
        }
        
        return fibonacciSeq;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el valor de 'n' para generar la secuencia de Fibonacci: ");
        int n = scanner.nextInt();
        
        ArrayList<Integer> fibonacciSequence = fibonacci(n);
        
        System.out.println("Secuencia de Fibonacci hasta el término " + n + ":");
        for (int num : fibonacciSequence) {
            System.out.print(num + " ");
        }
        
        scanner.close();
    }
}
