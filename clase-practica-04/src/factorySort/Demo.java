package factorySort;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Comparator;

public class Demo {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, IOException, InstantiationException, NoSuchMethodException, ClassNotFoundException {
        Integer[] iArr = {5, 3, 1, 5, 2, 6};
        String[] sArr = {"tomi", "lisandro", "rodrigo", "aa"};

        Comparator<Integer> c1 = (a, b)-> a.compareTo(b);
        Comparator<String> c2 = (a,b) -> a.compareTo(b);

        Sorter s = (Sorter) MyFactory.getInstance("sorter");

        s.sort(iArr, c1);
        s.sort(sArr, c2);
        System.out.println("\n *** " + s.getClass().getName() + " *** \n");
        System.out.println(Arrays.toString(iArr));
        System.out.println(Arrays.toString(sArr));
    }
}
