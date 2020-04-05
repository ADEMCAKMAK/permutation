import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class StringToMapConverter {

    public static Map<Character, Integer> convert(String sequence){

        Map<Character, Integer> map = new HashMap<>();

        if ( Objects.isNull(sequence) || sequence.isEmpty() )
            return map;

        char[] charArray = sequence.toCharArray();
        for(char ch : charArray){
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        return map;
    }
}
