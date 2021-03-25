package factorySort;

import java.util.Comparator;

public class QuickSortSorterImpl<T> implements Sorter<T> {

    private Comparator<T> c;

    @Override
    public void sort(T[] arr, Comparator<T> comparator) {
        this.c = comparator;
        quickSort(arr, 0, arr.length - 1);
    }

    void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    int partition(T[] arr, int low, int high) {
        T pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            if (c.compare(arr[j], pivot) < 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
}
