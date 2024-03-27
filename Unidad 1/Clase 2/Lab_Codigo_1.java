
public class Lab_Codigo_1 {
    public static int sumarNoRecursivo(int[] vector) {
        int suma = 0;
        for (int i = 0; i < vector.length; i++) {
            suma += vector[i];
        }
        return suma;
    }

    public static int sumarRecursivo(int[] vector, int index) {
        if (index == vector.length) {
            return 0;
        }
        return vector[index] + sumarRecursivo(vector, index + 1);
    }
}
