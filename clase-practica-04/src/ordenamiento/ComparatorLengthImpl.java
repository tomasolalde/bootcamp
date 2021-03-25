package ordenamiento;

public class ComparatorLengthImpl implements Comparator<String> {

    @Override
    public int compare(String a, String b) {
        return a.length() - b.length();
    }

}
