package BusquedaLineal;

public class BusquedaLineal {
    public static int buscar(int[] arr, int objetivo) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == objetivo) {
                return i; // Elemento encontrado
            }
        }
        return -1; // No encontrado
    }
}
