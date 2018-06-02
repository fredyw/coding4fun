package coding4fun;

import java.util.HashMap;
import java.util.Map;

/**
 * https://stackoverflow.com/questions/50607128/creating-a-nested-dictionary-from-a-flattened-dictionary
 */
public class Problem54 {
    private static Map<String, Object> unflatten(Map<String, Object> flatten) {
        Map<String, Object> map = new HashMap<>();
        flatten.forEach((key, value) -> {
            unflatten(map, key, value);
        });
        return map;
    }

    private static void unflatten(Map<String, Object> map, String str, Object value) {
        int idx = str.indexOf("_");
        if (idx < 0) {
            map.put(str, value);
            return;
        }
        String sub = str.substring(0, idx);
        if (!map.containsKey(sub)) {
            map.put(sub, new HashMap<>());
        }
        unflatten((Map<String, Object>) map.get(sub), str.substring(idx + 1), value);
    }

    public static void main(String[] args) {
        Map<String, Object> flatten = new HashMap<>();
        flatten.put("X_a_one", 10);
        flatten.put("X_a_two", 20);
        flatten.put("X_b_one", 10);
        flatten.put("X_b_two", 20);
        flatten.put("Y_a_one", 10);
        flatten.put("Y_a_two", 20);
        flatten.put("Y_b_one", 10);
        flatten.put("Y_b_two", 20);
        System.out.println(unflatten(flatten));

        flatten = new HashMap<>();
        flatten.put("X_a_one_5", 10);
        flatten.put("X_a_two_2", 20);
        flatten.put("X_b_one_4", 10);
        flatten.put("X_b_two_4", 20);
        flatten.put("Y_a_one_5", 10);
        flatten.put("Y_a_two_1", 20);
        flatten.put("Y_b_one_9", 10);
        flatten.put("Y_b_two_2", 20);
        System.out.println(unflatten(flatten));
    }
}
