package complejidad.ordenamientoburbuja;

public class OrdenamientoBurbuja {
    /**
     * Ordena in-place usando el "flag de intercambio": si una pasada completa no
     * hace ningún intercambio, el arreglo ya está ordenado y se corta la ejecución.
     * Sin este flag, el algoritmo siempre recorre las n² comparaciones aunque el
     * arreglo ya venga ordenado — el flag es lo que hace cierto el mejor caso O(n)
     * (ver README de este algoritmo).
     */
    public static void ordenar(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean huboIntercambio = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    huboIntercambio = true;
                }
            }
            if (!huboIntercambio) {
                break; // ya está ordenado, no hace falta seguir recorriendo
            }
        }
    }
}
