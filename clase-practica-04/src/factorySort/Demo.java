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

        Integer[] arrGrandote = new Integer[10000];
        for (int x=0; x < arrGrandote.length; x++) {
            arrGrandote[x] = (int) (Math.random()*1000)+1;
        }

        Time time = new Time();
        time.start();
        s.sort(arrGrandote, c1);
        System.out.println("\n *** " + s.getClass().getName() + " *** \n");
        System.out.println(Arrays.toString(iArr));
        time.stop();
        System.out.println("Timepo transcurrido: " + time.elapsedTime() + " milisegundos.");
    }
}
