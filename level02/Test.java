package level02;

import java.util.Collections;
import java.util.LinkedHashMap;

public class Test {

    public static void main(String[] args) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>(2, 0.75f, true);

        map.put("a", 1);
        map.put("b", 2);

        map.put("a", 3);

        System.out.println(map.toString());
    }
}
