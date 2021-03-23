package bootcamp.ejercicio3;

import java.util.Collection;

public class SortUtil {

    static <T> void ordenar(Precedable<T>[] arr) {
        Precedable<T> temp;
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++)
        {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++)
            {
                if (arr[j + 1].precedeA((T) arr[j]) > 0)
                {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) { break; }
        }
    }

}
