package coding4fun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find all the common elements in two sorted lists of numbers.
 *
 * <pre>
 * Input : [2, 5, 5, 5], [2, 2, 3, 5, 5, 7]
 * Output: [2, 5, 5]
 *
 * Input : [2, 3, 5, 5, 6], [2, 2, 3, 5, 5, 7]
 * Output: [2, 3, 5, 5]
 *
 * Input : [1, 3], [3, 1, 1]
 * Output: [1, 3]
 *
 * Input : [1, 3], [2, 4]
 * Output: []
 * </pre>
 */
public class Problem22 {
    public static List<Integer> findCommonElements(List<Integer> list1, List<Integer> list2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i : list1) {
            if (!map1.containsKey(i)) {
                map1.put(i, 1);
            } else {
                map1.put(i, map1.get(i)+1);
            }
        }
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i : list2) {
            if (!map2.containsKey(i)) {
                map2.put(i, 1);
            } else {
                map2.put(i, map2.get(i)+1);
            }
        }
        List<Integer> result = new ArrayList<>();
        map1.forEach((key, value) -> {
            if (map2.containsKey(key)) {
                int val1 = value;
                int val2 = map2.get(key);
                int n = Math.min(val1, val2);
                for (int i = 0; i < n; i++) {
                    result.add(key);
                }
            }
        });
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findCommonElements(
            Arrays.asList(2, 5, 5, 5), Arrays.asList(2, 2, 3, 5, 5, 7)));

        System.out.println(findCommonElements(
            Arrays.asList(2, 3, 5, 5, 6), Arrays.asList(2, 2, 3, 5, 5, 7)));

        System.out.println(findCommonElements(
            Arrays.asList(1, 3), Arrays.asList(3, 1, 1)));

        System.out.println(findCommonElements(
            Arrays.asList(1, 3), Arrays.asList(2, 4)));
    }
}
