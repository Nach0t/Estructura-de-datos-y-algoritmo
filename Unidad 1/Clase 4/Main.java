import java.util.Stack;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a number: ");
    int number = scanner.nextInt();

    System.out.println(factorial(number));
  }

  public static int factorial(int n) {
    Stack<Integer> stack = new Stack<>();
    while (n > 0) {
      stack.push(n);
      n--;
    }

    int result = 1;
    while (!stack.empty()) {
      result *= stack.pop();
    }
    return result;
  }
}