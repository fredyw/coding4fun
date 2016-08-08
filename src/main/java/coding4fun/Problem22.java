package coding4fun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find all the common elements in two sorted lists of numbers.
 * <p>
 * <pre>
 * Input : [2, 5, 5, 5], [2, 2, 3, 5, 5, 7]
 * Output: [2, 5, 5]
 *
 * Input : [2, 2, 3, 5, 5, 7], [2, 3, 5, 5, 6]
 * Output: [2, 3, 5, 5]
 *
 * Input : [1, 3], [1, 1, 3]
 * Output: [1, 3]
 *
 * Input : [1, 1, 3], [3]
 * Output: [3]
 *
 * Input : [1, 3], [2, 4]
 * Output: []
 * </pre>
 */
public class Problem22 {
    public static List<Integer> findCommonElements(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<>();
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < list1.size() && idx2 < list2.size()) {
            int val1 = list1.get(idx1);
            int val2 = list2.get(idx2);
            if (val1 == val2) {
                idx1++;
                idx2++;
                result.add(val1);
            } else {
                if (val1 < val2) {
                    idx1++;
                } else {
                    idx2++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findCommonElements(
            Arrays.asList(2, 5, 5, 5), Arrays.asList(2, 2, 3, 5, 5, 7)));

        System.out.println(findCommonElements(
            Arrays.asList(2, 2, 3, 5, 5, 7), Arrays.asList(2, 3, 5, 5, 6)));

        System.out.println(findCommonElements(
            Arrays.asList(1, 3), Arrays.asList(1, 1, 3)));

        System.out.println(findCommonElements(
            Arrays.asList(1, 1, 3), Arrays.asList(3)));

        System.out.println(findCommonElements(
            Arrays.asList(1, 3), Arrays.asList(2, 4)));
    }
}
