public class Lab_Codigo_2 {
    // Función no recursiva para buscar un número en un vector
    public static boolean buscarNumeroNoRecursivo(int[] vector, int x) {
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] == x) {
                return true;
            }
        }
        return false;
    }

    // Función recursiva para buscar un número en un vector
    public static boolean buscarNumeroRecursivo(int[] vector, int x, int index) {
        if (index >= vector.length) {
            return false;
        }
        if (vector[index] == x) {
            return true;
        }
        return buscarNumeroRecursivo(vector, x, index + 1);
    }
}
