package ordenamiento;

public class ComparatorIntAscImpl implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        return a-b;
    }
}
