package ordenamiento;

public class ComparatorIntDescImpl implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        return b-a;
    }
}
