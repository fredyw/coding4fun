package coding4fun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Given a map and a filter function, write a function that will go through and filter
 * the object, then return a filtered object.
 *
 * Examples:
 * <pre>
 * Input : {a=1, b={c=2, d=-3, e={f={g=-4}}, h={i=5, j=6}}}, x -> x >= 0
 * Output: {a=1, b={c=2, h={i=5, j=6}}}
 *
 * Input : {a=1, b={c=2, d=-3, e={f={g=-4}}, h={i=5, j=6}}}, x -> x >= 0
 * Output: {b={h={i=5, j=6}}}
 *
 * Input : {a=1, b={c=2, d=-3, e={f={g=-4}}, h={i=5, j=6}}}, x -> x >= 0
 * Output: {}
 * </pre>
 */
public class Problem58 {
    private static Map<String, Object> deepFilter(Map<String, Object> map, Predicate<Integer> predicate) {
        deepFilterRecurse(map, predicate);
        return map;
    }

    private static boolean deepFilterRecurse(Map<String, Object> map, Predicate<Integer> predicate) {
        boolean deleteAll = true;
        for (String key : new ArrayList<>(map.keySet())) {
            Object val = map.get(key);
            boolean delete;
            if (val instanceof Map) {
                delete = deepFilterRecurse((Map<String, Object>) val, predicate);
            } else { // it must be an Integer
                Integer i = (Integer) val;
                delete = !(predicate.test(i));
            }
            if (delete) {
                map.remove(key);
            }
            deleteAll &= delete;
        }
        return deleteAll;
    }

    private static Map<String, Object> testData() {
        Map<String, Object> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", new HashMap<>() {{
            put("c", 2);
            put("d", -3);
            put("e", new HashMap<>() {{
                put("f", new HashMap<>() {{
                    put("g", -4);
                }});
            }});
            put("h", new HashMap<>() {{
                put("i", 5);
                put("j", 6);
            }});
        }});
        return map;
    }

    public static void main(String[] args) {
        Map<String, Object> map = testData();
        System.out.println(deepFilter(map, x -> x >= 0)); // {a=1, b={c=2, h={i=5, j=6}}}

        map = testData();
        System.out.println(deepFilter(map, x -> x >= 4)); // {b={h={i=5, j=6}}}

        map = testData();
        System.out.println(deepFilter(map, x -> x >= 8)); // {}
    }
}
