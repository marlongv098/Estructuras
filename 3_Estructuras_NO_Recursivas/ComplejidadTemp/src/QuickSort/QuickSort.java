package QuickSort;

public class QuickSort {
    public static void quicksort(int[] arr, int izq, int der) {
        if (izq < der) {
            int pi = particion(arr, izq, der);
            quicksort(arr, izq, pi - 1);
            quicksort(arr, pi + 1, der);
        }
    }

    private static int particion(int[] arr, int izq, int der) {
        int pivote = arr[der];
        int i = izq - 1;
        for (int j = izq; j < der; j++) {
            if (arr[j] < pivote) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[der];
        arr[der] = temp;
        return i + 1;
    }
}
