package ordenamiento;

public class ComparatorStringImpl implements Comparator<String> {

    @Override
    public int compare(String a, String b) {
        return a.compareTo(b);
    }

}
