package ordenamiento;

public class SortUtil {

    public static <T> void ordenar(T[] arr, Comparator<T> c) {
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (c.compare(arr[i], arr[i+1]) > 0) {
                    T aux = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = aux;
                }
            }
        }
    }
}
