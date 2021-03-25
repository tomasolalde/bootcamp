package ordenamiento;

import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {
        String sArr[] = {"Tomas", "Lisi", "Rocha"};
        Comparator<String> c1 = (a, b)->a.compareTo(b);
        SortUtil.ordenar(sArr, c1);
        System.out.println(Arrays.toString(sArr));
    }

}
