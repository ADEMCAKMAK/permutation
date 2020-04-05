import java.util.Map;
import java.util.Objects;

public class Permutation {

    public static void main(String[] args) {
        test("baba", "abab");
        test("baba", "abc");
        test("lds", "loodos");
        test("", "");
        test(null, "loodos");
        test("aaabb", "aa");
    }

    public static void test(String sequence1, String sequence2){
        System.out.println(String.format("\"%s\" , \"%s\" => %s", sequence1,sequence2, isContainPermutation(sequence1, sequence2)));
    }

    public static boolean isContainPermutation(String sequence1, String sequence2) {

        if (Objects.isNull(sequence1) || Objects.isNull(sequence2))
            return false;
        else {
            return sequence1.length() >= sequence2.length() ?
                    checkoutContainPermutation(sequence1, sequence2):
                    checkoutContainPermutation(sequence2, sequence1);
        }
    }

    private static boolean checkoutContainPermutation(String source, String target) {

        Map<Character, Integer> sourceMap = StringToMapConverter.convert(source);
        Map<Character, Integer> targetMap = StringToMapConverter.convert(target);
        for ( Map.Entry<Character, Integer> entry : targetMap.entrySet() ){
            if (!sourceMap.containsKey(entry.getKey()) || (sourceMap.get(entry.getKey()) < entry.getValue())) {
                return false;
            }
        }
        return true;
    }
}
