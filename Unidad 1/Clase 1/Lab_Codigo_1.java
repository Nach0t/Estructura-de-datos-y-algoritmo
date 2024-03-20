public class Multiplicacion {

    // Función no recursiva
    public static int multiplicacionNoRecursiva(int a, int b) {
        int resultado = 0;
        for (int i = 0; i < b; i++) {
            resultado += a;
        }
        return resultado;
    }

    // Función recursiva
    public static int multiplicacionRecursiva(int a, int b) {
        if (b == 0) {
            return 0;
        } else if (b < 0) {
            return -multiplicacionRecursiva(a, -b);
        } else {
            return a + multiplicacionRecursiva(a, b - 1);
        }
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        System.out.println("Multiplicación no recursiva: " + multiplicacionNoRecursiva(5, 3));
        System.out.println("Multiplicación recursiva: " + multiplicacionRecursiva(5, 3));
    }
}